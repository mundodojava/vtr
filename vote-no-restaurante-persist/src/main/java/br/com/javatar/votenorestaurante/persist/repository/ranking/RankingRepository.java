package br.com.javatar.votenorestaurante.persist.repository.ranking;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.javatar.votenorestaurante.model.ranking.Ranking;
import br.com.javatar.votenorestaurante.model.ranking.RankingGeral;
import br.com.javatar.votenorestaurante.model.ranking.RankingGeralCustoBeneficio;
import br.com.javatar.votenorestaurante.model.ranking.RankingUsuario;
import br.com.javatar.votenorestaurante.model.ranking.RankingUsuarioCustoBeneficio;
import br.com.javatar.votenorestaurante.model.ranking.TipoVoto;

/**
 * The Interface RankingRepository.
 * 
 * @author ismael
 */
public interface RankingRepository extends JpaRepository<Ranking, Long> {

    /**
     * View ranking custo beneficio.
     *
     * @return O(a)(s) list
     */
    @Query(value = "SELECT r FROM RankingGeralCustoBeneficio r ORDER BY r.media DESC")
    List<RankingGeralCustoBeneficio> viewRankingGeralCustoBeneficio();

    /**
     * View por usuario e tipo.
     *
     * @param usuarioId O(a)(s) usuario id
     * @param tipoVoto O(a)(s) tipo voto
     * @return O(a)(s) list
     */
    @Query(value = "SELECT r FROM RankingUsuario r WHERE r.usuario.id = :usuarioId AND r.tipoVoto = :tipoVoto ORDER BY r.media DESC")
    List<RankingUsuario> viewPorUsuarioETipo(@Param("usuarioId") String usuarioId, @Param("tipoVoto") TipoVoto tipoVoto);

    /**
     * View ranking custo beneficio usuario.
     *
     * @param usuarioId O(a)(s) usuario id
     * @return O(a)(s) list
     */
    @Query(value = "SELECT r FROM RankingUsuarioCustoBeneficio r WHERE r.usuario.id = :usuarioId ORDER BY r.media DESC")
    List<RankingUsuarioCustoBeneficio> viewRankingUsuarioCustoBeneficio(@Param("usuarioId") String usuarioId);

    /**
     * View ranking geral por tipo.
     *
     * @param tipo O(a)(s) tipo
     * @return O(a)(s) list
     */
    @Query(value = "SELECT r FROM RankingGeral r WHERE r.tipoVoto = :tipoVoto ORDER BY r.media DESC")
    List<RankingGeral> viewRankingGeralPorTipo(@Param("tipoVoto") TipoVoto tipoVoto);

}
