package br.com.javatar.votenorestaurante.model.ranking;

import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import br.com.votenorestaurante.fixture.util.Loader;
import br.com.votenorestaurante.test.util.EqualsHashCodeAsserts;

import com.google.code.beanmatchers.BeanMatchers;

public class VotoTest {

    @BeforeClass
    public static void setUp() {
        FixtureFactoryLoader.loadTemplates("br.com.javatar.votenorestaurante.model");
    }

    @Test
    public void deve_possuir_getters_and_setters_validos_para_todas_propriedades_excluindo_new() {
        assertThat(Voto.class, BeanMatchers.hasValidGettersAndSettersExcluding("new", "id"));
    }

    @Test
    public void deve_respeitar_contrato_equals_hash_code() {
        assertThat(Voto.class, BeanMatchers.hasValidBeanEqualsFor("id"));
        assertThat(Voto.class, BeanMatchers.hasValidBeanHashCodeFor("id"));
        EqualsHashCodeAsserts.equalsHashCodeValid(Fixture.from(Voto.class).gimme(2, "valid_id_fixo"), Loader.gimme(Voto.class, "valid_sem_id"));
    }

    @Test
    public void deve_sobrescrever_to_string() {
        assertThat(Voto.class, BeanMatchers.hasValidBeanToStringExcluding("new", "id"));
    }

}
