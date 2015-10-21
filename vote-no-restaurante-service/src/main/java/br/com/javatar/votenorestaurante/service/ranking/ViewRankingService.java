package br.com.javatar.votenorestaurante.service.ranking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.javatar.votenorestaurante.model.ranking.RankingAtendimento;
import br.com.javatar.votenorestaurante.model.ranking.RankingCustoBeneficio;
import br.com.javatar.votenorestaurante.model.ranking.RankingCustoBeneficioUsuario;
import br.com.javatar.votenorestaurante.model.ranking.RankingDemora;
import br.com.javatar.votenorestaurante.model.ranking.RankingLocalizacao;
import br.com.javatar.votenorestaurante.model.ranking.RankingPreco;
import br.com.javatar.votenorestaurante.model.ranking.RankingSabor;
import br.com.javatar.votenorestaurante.model.ranking.RankingUsuario;
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
     * View ranking localizacao.
     *
     * @return O(a)(s) list
     */
    public List<RankingLocalizacao> viewRankingLocalizacao() {
        return rankingRepository.viewRankingLocalizacao();
    }

    /**
     * View ranking sabor.
     *
     * @return O(a)(s) list
     */
    public List<RankingSabor> viewRankingSabor() {
        return rankingRepository.viewRankingSabor();
    }

    /**
     * View ranking ranking atendimento.
     *
     * @return O(a)(s) list
     */
    public List<RankingAtendimento> viewRankingRankingAtendimento() {
        return rankingRepository.viewRankingAtendimento();
    }

    /**
     * View ranking preco.
     *
     * @return O(a)(s) list
     */
    public List<RankingPreco> viewRankingPreco() {
        return rankingRepository.viewRankingPreco();
    }

    /**
     * View ranking demora.
     *
     * @return O(a)(s) list
     */
    public List<RankingDemora> viewRankingDemora() {
        return rankingRepository.viewRankingDemora();
    }

    /**
     * View ranking custo beneficio.
     *
     * @return O(a)(s) list
     */
    public List<RankingCustoBeneficio> viewRankingCustoBeneficio() {
        return rankingRepository.viewRankingCustoBeneficio();
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
    public List<RankingCustoBeneficioUsuario> viewRankingCustoBeneficioUsuario(String usuarioId) {
        return rankingRepository.viewRankingCustoBeneficioUsuario(usuarioId);
    }

}
