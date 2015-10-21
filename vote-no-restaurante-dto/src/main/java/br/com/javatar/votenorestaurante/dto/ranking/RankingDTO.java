package br.com.javatar.votenorestaurante.dto.ranking;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.hateoas.ResourceSupport;

import br.com.javatar.votenorestaurante.dto.pessoa.UsuarioDTO;

public class RankingDTO extends ResourceSupport implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long rankingId;

    private UsuarioDTO usuario;

    private List<VotoDTO> votos;

    /**
     * @return the usuario
     */
    public UsuarioDTO getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    /**
     * @param votos the votos to set
     */
    public void setVotos(List<VotoDTO> votos) {
        this.votos = votos;
    }

    public List<VotoDTO> getVotos() {
        if (votos == null) {
            this.votos = new ArrayList<>();
        }
        return votos;
    }

    /**
     * @return the rankingId
     */
    public Long getRankingId() {
        return rankingId;
    }

    /**
     * @param rankingId the rankingId to set
     */
    public void setRankingId(Long rankingId) {
        this.rankingId = rankingId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
