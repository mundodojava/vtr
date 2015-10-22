package br.com.javatar.votenorestaurante.model.ranking.template;

import br.com.javatar.votenorestaurante.model.pessoa.Usuario;
import br.com.javatar.votenorestaurante.model.ranking.Ranking;
import br.com.javatar.votenorestaurante.model.ranking.Voto;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class RankingTemplateLoader implements TemplateLoader {
    @Override
    public void load() {

        Fixture.of(Ranking.class)

        .addTemplate("valid", new Rule() {
            {
                add("id", random(Long.class, range(1L, 200L)));
                add("votos", has(5).of(Voto.class, "valid"));
                add("usuario", one(Usuario.class, "valid"));
            }
        })
        
        .addTemplate("invalid").inherits("valid", new Rule() {
            {
                add("id", 1L);
                add("votos", has(3).of(Voto.class, "valid"));
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
