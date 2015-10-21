package br.com.javatar.votenorestaurante.model.pessoa.template;

import br.com.javatar.votenorestaurante.model.pessoa.Pessoa;
import br.com.javatar.votenorestaurante.model.pessoa.Usuario;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class UsuarioTemplateLoader implements TemplateLoader {
    @Override
    public void load() {

        Fixture.of(Usuario.class)

        .addTemplate("valid", new Rule() {
            {
                add("id", regex("\\w{10}@email.com"));
                add("pessoa", one(Pessoa.class, "valid"));
            }
        })

        .addTemplate("valid_id_fixo").inherits("valid", new Rule() {
            {
                add("id", "teste@email.com");
            }
        })
        
        .addTemplate("invalid").inherits("valid", new Rule() {
            {
                add("pessoa", null);
            }
        })
        
        .addTemplate("valid_sem_id").inherits("valid", new Rule() {
            {
                add("id", null);
                add("pessoa", one(Pessoa.class, "valid_sem_id"));
            }
        })

        ;
    }
}
