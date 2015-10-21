package br.com.javatar.votenorestaurante.model.restaurante.template;

import br.com.javatar.votenorestaurante.model.restaurante.Restaurante;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class RestauranteTemplateLoader implements TemplateLoader {
    @Override
    public void load() {

        Fixture.of(Restaurante.class)

        .addTemplate("valid", new Rule() {
            {
                add("id", random(Long.class, range(1L, 5L)));
                add("nome", random("Subway", "Mc Donald's", "OutBack", "América", "The Fifties"));
                add("banner", regex("\\w{150}"));
                add("logo", regex("\\w{150}"));
            }
        })

        .addTemplate("valid_id_fixo").inherits("valid", new Rule() {
            {
                add("id", 1L);
            }
        })

        .addTemplate("invalid").inherits("valid", new Rule() {
            {
                add("id", null);
                add("nome", null);
            }
        })

        .addTemplate("valid_sem_id").inherits("valid", new Rule() {
            {
                add("id", null);
            }
        })

        .addTemplate("valid_so_id").inherits("valid", new Rule() {
            {
                add("banner", null);
                add("logo", null);
            }
        })

        ;
    }
}
