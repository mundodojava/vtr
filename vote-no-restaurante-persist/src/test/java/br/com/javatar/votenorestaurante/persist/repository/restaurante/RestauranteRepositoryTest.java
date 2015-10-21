package br.com.javatar.votenorestaurante.persist.repository.restaurante;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.TransactionSystemException;

import br.com.javatar.votenorestaurante.model.restaurante.Restaurante;
import br.com.javatar.votenorestaurante.persist.repository.ranking.RankingRepository;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import br.com.votenorestaurante.fixture.util.Loader;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:persist-config-test.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class, TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DatabaseSetup(value = { "classpath:testData.xml" })
// @Category(IntegrationTests.class)
public class RestauranteRepositoryTest {

    @Autowired
    private RestauranteRepository restauranteRepository;
    
    @Autowired
    private RankingRepository rankingRepository;

    @BeforeClass
    public static void setUp() {
        FixtureFactoryLoader.loadTemplates("br.com.javatar.votenorestaurante.model");
    }

    @Test
    public void deve_listar_restaurantes() {
        List<Restaurante> findAll = restauranteRepository.findAll();
        Assert.assertTrue(findAll.size() == 5);
    }

    @Test
    public void deve_salvar_restaurante_valido() {
        Restaurante save = restauranteRepository.save(Loader.gimme(Restaurante.class, "valid_sem_id"));
        Assert.assertNotNull(save.getId());
    }

    @Test(expected = TransactionSystemException.class)
    public void nao_deve_salvar_restaurante_invalido() {
        Restaurante save = restauranteRepository.save(Loader.gimme(Restaurante.class, "invalid"));
        Assert.assertNotNull(save.getId());
    }

}
