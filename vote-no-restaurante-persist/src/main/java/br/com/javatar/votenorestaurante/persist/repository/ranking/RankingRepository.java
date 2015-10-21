package br.com.javatar.votenorestaurante.persist.repository.ranking;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.javatar.votenorestaurante.model.ranking.Ranking;
import br.com.javatar.votenorestaurante.model.ranking.RankingAtendimento;
import br.com.javatar.votenorestaurante.model.ranking.RankingCustoBeneficio;
import br.com.javatar.votenorestaurante.model.ranking.RankingCustoBeneficioUsuario;
import br.com.javatar.votenorestaurante.model.ranking.RankingDemora;
import br.com.javatar.votenorestaurante.model.ranking.RankingLocalizacao;
import br.com.javatar.votenorestaurante.model.ranking.RankingPreco;
import br.com.javatar.votenorestaurante.model.ranking.RankingSabor;
import br.com.javatar.votenorestaurante.model.ranking.RankingUsuario;
import br.com.javatar.votenorestaurante.model.ranking.TipoVoto;

public interface RankingRepository extends JpaRepository<Ranking, Long> {

    @Query(value = "SELECT r FROM RankingLocalizacao r ORDER BY r.media DESC")
    List<RankingLocalizacao> viewRankingLocalizacao();

    @Query(value = "SELECT r FROM RankingSabor r ORDER BY r.media DESC")
    List<RankingSabor> viewRankingSabor();
    
    @Query(value = "SELECT r FROM RankingPreco r ORDER BY r.media DESC")
    List<RankingPreco> viewRankingPreco();
    
    @Query(value = "SELECT r FROM RankingDemora r ORDER BY r.media DESC")
    List<RankingDemora> viewRankingDemora();
    
    @Query(value = "SELECT r FROM RankingAtendimento r ORDER BY r.media DESC")
    List<RankingAtendimento> viewRankingAtendimento();
    
    @Query(value = "SELECT r FROM RankingCustoBeneficio r ORDER BY r.media DESC")
    List<RankingCustoBeneficio> viewRankingCustoBeneficio();
    
    @Query(value = "SELECT r FROM RankingUsuario r WHERE r.usuario.id = :usuarioId AND r.tipoVoto = :tipoVoto ORDER BY r.media DESC")
    List<RankingUsuario> viewPorUsuarioETipo(@Param("usuarioId") String usuarioId, @Param("tipoVoto") TipoVoto tipoVoto);
    
    @Query(value = "SELECT r FROM RankingCustoBeneficioUsuario r WHERE r.usuario.id = :usuarioId ORDER BY r.media DESC")
    List<RankingCustoBeneficioUsuario> viewRankingCustoBeneficioUsuario(@Param("usuarioId") String usuarioId);
    
}
