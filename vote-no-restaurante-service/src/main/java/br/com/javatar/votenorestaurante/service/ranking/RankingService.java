package br.com.javatar.votenorestaurante.service.ranking;

import static br.com.javatar.votenorestaurante.service.util.ValidatorUtil.checkViolations;
import static br.com.javatar.votenorestaurante.service.util.ValidatorUtil.validate;

import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.javatar.votenorestaurante.model.ranking.Ranking;
import br.com.javatar.votenorestaurante.model.ranking.TipoVoto;
import br.com.javatar.votenorestaurante.model.ranking.Voto;
import br.com.javatar.votenorestaurante.model.restaurante.Restaurante;
import br.com.javatar.votenorestaurante.persist.repository.pessoa.UsuarioRepository;
import br.com.javatar.votenorestaurante.persist.repository.ranking.RankingRepository;
import br.com.javatar.votenorestaurante.persist.repository.restaurante.RestauranteRepository;

import com.google.common.base.Preconditions;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

@Service
public class RankingService {

    @Autowired
    private RankingRepository rankingRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private ResourceBundleMessageSource messageSource;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void salvar(Ranking ranking) {
        validarRanking(ranking);
        mergeRestaurante(ranking);
        validarVotacaoPorRestaurante(ranking.getVotos());
        rankingRepository.save(ranking);
    }

    public void mergeRestaurante(Ranking ranking) {
        Preconditions.checkNotNull(ranking, "ranking nulo");
        Map<Long, Restaurante> restaurantes = new HashMap<>();
        for (Voto voto : ranking.getVotos()) {
            Long restauranteId = voto.getRestaurante().getId();
            if (restaurantes.containsKey(restauranteId)) {
                voto.setRestaurante(restaurantes.get(restauranteId));
                break;
            }
            Restaurante restaurante = restauranteRepository.findOne(restauranteId);
            if (restaurante == null) {
                throw new EmptyResultDataAccessException(messageSource.getMessage("restaurante_nao_encontrado", null, new Locale("pt_BR")), 1);
            }
            restaurantes.put(restauranteId, restaurante);
            voto.setRestaurante(restaurante);
        }
    }

    public void validarRanking(Ranking ranking) {
        Map<String, String> map = new HashMap<String, String>();
        if (ranking.getUsuario().isNew()) {
            map.put("usuarioId", messageSource.getMessage("email_obrigatorio", null, new Locale("pt_BR")));
        } else if (usuarioRepository.exists(ranking.getUsuario().getId()) && ranking.getUsuario().getPessoa() != null) {
            map.put("usuarioId", messageSource.getMessage("pessoa_existente", new Object[] { ranking.getUsuario().getPessoa().getNome() }, new Locale("pt_BR")));
        }
        validarRestauranteVoto(ranking.getVotos(), map);
        checkViolations(map, validate(ranking));
    }

    public void validarRestauranteVoto(Set<Voto> votos, Map<String, String> map) {
        for (Voto voto : votos) {
            if (voto.getRestaurante() != null && voto.getRestaurante().isNew()) {
                map.put("restauranteId", messageSource.getMessage("restaurante_obrigatorio", null, new Locale("pt_BR")));
            }
        }
    }

    public void validarVotacaoPorRestaurante(Set<Voto> votos) {
        Map<String, String> map = new HashMap<>();
        Multimap<Restaurante, TipoVoto> votosPorRestaurante = HashMultimap.create();

        for (Voto voto : votos) {
            votosPorRestaurante.put(voto.getRestaurante(), voto.getTipoVoto());
        }

        for (Entry<Restaurante, Collection<TipoVoto>> entry : votosPorRestaurante.asMap().entrySet()) {
            if (entry.getValue().size() != TipoVoto.values().length) {
                map.put("tipoVoto", messageSource.getMessage("voto_faltando", new Object[] { entry.getKey().getNome() }, new Locale("pt_BR")));
            }
        }

        checkViolations(map);
    }

}
