package br.com.javatar.votenorestaurante.service.ranking;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.context.support.ResourceBundleMessageSource;

import br.com.javatar.votenorestaurante.model.ranking.Ranking;
import br.com.javatar.votenorestaurante.model.ranking.TipoVoto;
import br.com.javatar.votenorestaurante.model.ranking.Voto;
import br.com.javatar.votenorestaurante.model.restaurante.Restaurante;
import br.com.javatar.votenorestaurante.persist.repository.ranking.RankingRepository;
import br.com.javatar.votenorestaurante.service.exception.BusinessException;
import br.com.javatar.votenorestaurante.service.pessoa.UsuarioService;
import br.com.javatar.votenorestaurante.service.restaurante.RestauranteService;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import br.com.votenorestaurante.fixture.util.Loader;

public class RankingServiceTest {

    @InjectMocks
    @Spy
    private RankingService rankingService;

    @Mock
    private UsuarioService usuarioService;
    
    @Mock
    private RestauranteService restauranteService;
    
    @Mock
    private RankingRepository rankingRepository;
    
    @Spy
    private ResourceBundleMessageSource messageSource;

    @BeforeClass
    public static void setUp() {
        FixtureFactoryLoader.loadTemplates("br.com.javatar.votenorestaurante.model");
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        messageSource.setUseCodeAsDefaultMessage(true);
    }

    @Test
    public void deve_salvar_um_ranking_valido() {
        Ranking gimme = Loader.gimme(Ranking.class, "valid");
        
        Mockito.when(restauranteService.buscar(Mockito.anyLong())).thenReturn(Loader.gimme(Restaurante.class, "valid_id_fixo"));
        preencherVotosValidos(gimme);
        
        rankingService.salvar(gimme);
        Mockito.verify(rankingService, Mockito.times(1)).validarRanking(gimme);
        Mockito.verify(rankingService, Mockito.times(1)).mergeRestaurante(gimme);
        Mockito.verify(rankingService, Mockito.times(1)).validarVotacaoPorRestaurante(gimme.getVotos());
    }
    
    @Test(expected=BusinessException.class)
    public void nao_deve_salvar_um_ranking_com_voto_faltando() {
        Ranking gimme = Loader.gimme(Ranking.class, "invalid");
        
        Mockito.when(restauranteService.buscar(Mockito.anyLong())).thenReturn(Loader.gimme(Restaurante.class, "valid_id_fixo"));
        
        rankingService.salvar(gimme);
    }

    private void preencherVotosValidos(Ranking gimme) {
        Voto[] votos = gimme.getVotos().toArray(new Voto[]{});
        TipoVoto[] tipos = TipoVoto.values();
        for (int i = 0; i < votos.length; i++) {
            Voto voto = votos[i];
            voto.setTipoVoto(tipos[i]);
        }
    }

}
