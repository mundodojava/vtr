package br.com.javatar.votenorestaurante.service.pessoa;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import br.com.javatar.votenorestaurante.persist.repository.pessoa.UsuarioRepository;
import br.com.javatar.votenorestaurante.service.pessoa.UsuarioService;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

public class UsuarioServiceTest {

    @InjectMocks
    @Spy
    private UsuarioService usuarioService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @BeforeClass
    public static void setUp() {
        FixtureFactoryLoader.loadTemplates("br.com.javatar.votenorestaurante.model");
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void deve_retornar_se_o_usuario_existe() {
        String id = "usuariid";
        usuarioService.exists(id);
        Mockito.verify(usuarioRepository, Mockito.only()).exists(id);
    }
}
