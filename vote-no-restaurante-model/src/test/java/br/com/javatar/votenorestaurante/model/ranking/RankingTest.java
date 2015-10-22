package br.com.javatar.votenorestaurante.model.ranking;

import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import br.com.votenorestaurante.fixture.util.Loader;
import br.com.votenorestaurante.test.util.EqualsHashCodeAsserts;

import com.google.code.beanmatchers.BeanMatchers;

public class RankingTest {

    @BeforeClass
    public static void setUp() {
        FixtureFactoryLoader.loadTemplates("br.com.javatar.votenorestaurante.model");
    }

    @Test
    public void deve_possuir_getters_and_setters_validos_para_todas_propriedades_excluindo_new() {
        assertThat(Ranking.class, BeanMatchers.hasValidGettersAndSettersExcluding("new", "id"));
    }

    @Test
    public void deve_respeitar_contrato_equals_hash_code() {
        assertThat(Ranking.class, BeanMatchers.hasValidBeanEqualsFor("id"));
        assertThat(Ranking.class, BeanMatchers.hasValidBeanHashCodeFor("id"));
        EqualsHashCodeAsserts.equalsHashCodeValid(Fixture.from(Ranking.class).gimme(2, "valid_id_fixo"), Loader.gimme(Ranking.class, "valid_sem_id"));
    }

    @Test
    public void deve_sobrescrever_to_string() {
        assertThat(Ranking.class, BeanMatchers.hasValidBeanToStringExcluding("new", "id"));
    }

}
