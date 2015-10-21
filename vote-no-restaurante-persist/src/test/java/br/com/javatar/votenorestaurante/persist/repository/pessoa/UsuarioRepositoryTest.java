package br.com.javatar.votenorestaurante.persist.repository.pessoa;

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

import br.com.javatar.votenorestaurante.model.pessoa.Usuario;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import br.com.votenorestaurante.fixture.util.Loader;

import com.github.springtestdbunit.DbUnitTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:persist-config-test.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class, TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
//@DatabaseSetup(value={"classpath:usuarioData.xml"})
// @Category(IntegrationTests.class)
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @BeforeClass
    public static void setUp() {
        FixtureFactoryLoader.loadTemplates("br.com.javatar.votenorestaurante.model");
    }

    @Test
    public void deve_salvar_usuario_valido() {
        Usuario save = usuarioRepository.save(Loader.gimme(Usuario.class, "valid"));
        Assert.assertNotNull(save.getId());
    }
    
    @Test(expected=TransactionSystemException.class)
    public void nao_deve_salvar_usuario_invalido() {
        Usuario save = usuarioRepository.save(Loader.gimme(Usuario.class, "invalid"));
        Assert.assertNotNull(save.getId());
    }

}
