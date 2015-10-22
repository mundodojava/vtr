package br.com.javatar.votenorestaurante.model.ranking.template;

import br.com.javatar.votenorestaurante.model.ranking.TipoVoto;
import br.com.javatar.votenorestaurante.model.ranking.Voto;
import br.com.javatar.votenorestaurante.model.restaurante.Restaurante;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class VotoTemplateLoader implements TemplateLoader {
    @Override
    public void load() {

        Fixture.of(Voto.class)

        .addTemplate("valid", new Rule() {
            {
                add("id", random(Long.class, range(1L, 200L)));
                add("nota", random(Integer.class, range(1,5)));
                add("tipoVoto", random(TipoVoto.class));
                add("restaurante", one(Restaurante.class, "valid_id_fixo"));
            }
        })

        .addTemplate("valid_id_fixo").inherits("valid", new Rule() {
            {
                add("id", 1L);
                add("tipoVoto", TipoVoto.ATENDIMENTO);
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
