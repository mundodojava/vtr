package br.com.javatar.votenorestaurante.dto.ranking;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.hateoas.ResourceSupport;

import br.com.javatar.votenorestaurante.dto.pessoa.UsuarioDTO;

/**
 * The Class RankingDTO.
 * 
 * @author ismael
 */
public class RankingDTO extends ResourceSupport implements Serializable {

    /** A Constante serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** O(a)(s) ranking id. */
    private Long rankingId;

    /** O(a)(s) usuario. */
    private UsuarioDTO usuario;

    /** O(a)(s) votos. */
    private List<VotoDTO> votos;

    /**
     * Obtém o valor do(a)(s) usuario.
     *
     * @return O(a)(s) usuario
     */
    public UsuarioDTO getUsuario() {
        return usuario;
    }

    /**
     * Define o valor do(a)(s) usuario.
     *
     * @param usuario o novo valor do(a)(s) usuario
     */
    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    /**
     * Define o valor do(a)(s) votos.
     *
     * @param votos o novo valor do(a)(s) votos
     */
    public void setVotos(List<VotoDTO> votos) {
        this.votos = votos;
    }

    /**
     * Obtém o valor do(a)(s) votos.
     *
     * @return O(a)(s) votos
     */
    public List<VotoDTO> getVotos() {
        if (votos == null) {
            this.votos = new ArrayList<>();
        }
        return votos;
    }

    /**
     * Obtém o valor do(a)(s) ranking id.
     *
     * @return O(a)(s) ranking id
     */
    public Long getRankingId() {
        return rankingId;
    }

    /**
     * Define o valor do(a)(s) ranking id.
     *
     * @param rankingId o novo valor do(a)(s) ranking id
     */
    public void setRankingId(Long rankingId) {
        this.rankingId = rankingId;
    }

    /* (non-Javadoc)
     * @see org.springframework.hateoas.ResourceSupport#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
