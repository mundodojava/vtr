package br.com.javatar.votenorestaurante.model.pessoa.template;

import br.com.javatar.votenorestaurante.model.pessoa.Pessoa;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class PessoaTemplateLoader implements TemplateLoader {
    @Override
    public void load() {

        Fixture.of(Pessoa.class)

        .addTemplate("valid", new Rule() {
            {
                add("id", random(Long.class, range(1L, 200L)));
                add("nome", name());
            }
        })

        .addTemplate("valid_id_fixo").inherits("valid", new Rule() {
            {
                add("id", 1L);
            }
        })
        
        .addTemplate("valid_sem_id").inherits("valid", new Rule() {
            {
                add("id", null);
            }
        })

        ;
    }
}
