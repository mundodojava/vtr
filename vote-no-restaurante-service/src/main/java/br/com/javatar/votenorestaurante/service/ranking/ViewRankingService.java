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

@Service
public class ViewRankingService {

    @Autowired
    private RankingRepository rankingRepository;

    public List<RankingLocalizacao> viewRankingLocalizacao() {
        return rankingRepository.viewRankingLocalizacao();
    }

    public List<RankingSabor> viewRankingSabor() {
        return rankingRepository.viewRankingSabor();
    }

    public List<RankingAtendimento> viewRankingRankingAtendimento() {
        return rankingRepository.viewRankingAtendimento();
    }

    public List<RankingPreco> viewRankingPreco() {
        return rankingRepository.viewRankingPreco();
    }

    public List<RankingDemora> viewRankingDemora() {
        return rankingRepository.viewRankingDemora();
    }

    public List<RankingCustoBeneficio> viewRankingCustoBeneficio() {
        return rankingRepository.viewRankingCustoBeneficio();
    }

    public List<RankingUsuario> viewRankingPorUsuarioETipoVoto(String usuarioId, TipoVoto tipo) {
        return rankingRepository.viewPorUsuarioETipo(usuarioId, tipo);
    }

    public List<RankingCustoBeneficioUsuario> viewRankingCustoBeneficioUsuario(String usuarioId) {
        return rankingRepository.viewRankingCustoBeneficioUsuario(usuarioId);
    }

}
