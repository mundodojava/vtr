package br.com.javatar.votenorestaurante.service.ranking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.javatar.votenorestaurante.model.ranking.RankingGeral;
import br.com.javatar.votenorestaurante.model.ranking.RankingGeralCustoBeneficio;
import br.com.javatar.votenorestaurante.model.ranking.RankingUsuario;
import br.com.javatar.votenorestaurante.model.ranking.RankingUsuarioCustoBeneficio;
import br.com.javatar.votenorestaurante.model.ranking.TipoVoto;
import br.com.javatar.votenorestaurante.persist.repository.ranking.RankingRepository;

/**
 * The Class ViewRankingService.
 * 
 * @author ismael
 */
@Service
public class ViewRankingService {

    /** O(a)(s) ranking repository. */
    @Autowired
    private RankingRepository rankingRepository;

    /**
     * View ranking custo beneficio.
     *
     * @return O(a)(s) list
     */
    public List<RankingGeralCustoBeneficio> viewRankingCustoBeneficio() {
        return rankingRepository.viewRankingGeralCustoBeneficio();
    }

    /**
     * View ranking por usuario e tipo voto.
     *
     * @param usuarioId O(a)(s) usuario id
     * @param tipo O(a)(s) tipo
     * @return O(a)(s) list
     */
    public List<RankingUsuario> viewRankingPorUsuarioETipoVoto(String usuarioId, TipoVoto tipo) {
        return rankingRepository.viewPorUsuarioETipo(usuarioId, tipo);
    }

    /**
     * View ranking custo beneficio usuario.
     *
     * @param usuarioId O(a)(s) usuario id
     * @return O(a)(s) list
     */
    public List<RankingUsuarioCustoBeneficio> viewRankingCustoBeneficioUsuario(String usuarioId) {
        return rankingRepository.viewRankingUsuarioCustoBeneficio(usuarioId);
    }

    /**
     * View ranking geral por tipo.
     *
     * @param tipo O(a)(s) tipo
     * @return O(a)(s) list
     */
    public List<RankingGeral> viewRankingGeralPorTipo(TipoVoto tipo) {
        return rankingRepository.viewRankingGeralPorTipo(tipo);
    }

}
