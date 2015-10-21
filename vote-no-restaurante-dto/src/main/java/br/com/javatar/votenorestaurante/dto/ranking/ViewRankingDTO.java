package br.com.javatar.votenorestaurante.dto.ranking;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.com.javatar.votenorestaurante.dto.restaurante.RestauranteDTO;

/**
 * The Class ViewRankingDTO.
 * 
 * @author ismael
 */
public class ViewRankingDTO implements Serializable {

    /** A Constante serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** O(a)(s) media. */
    private Integer media;

    /** O(a)(s) tipo voto. */
    private TipoVotoType tipoVoto;

    /** O(a)(s) restaurante. */
    private RestauranteDTO restaurante;

    /**
     * Obtém o valor do(a)(s) media.
     *
     * @return O(a)(s) media
     */
    public Integer getMedia() {
        return media;
    }

    /**
     * Define o valor do(a)(s) media.
     *
     * @param media o novo valor do(a)(s) media
     */
    public void setMedia(Integer media) {
        this.media = media;
    }

    /**
     * Obtém o valor do(a)(s) tipo voto.
     *
     * @return O(a)(s) tipo voto
     */
    public TipoVotoType getTipoVoto() {
        return tipoVoto;
    }

    /**
     * Define o valor do(a)(s) tipo voto.
     *
     * @param tipoVoto o novo valor do(a)(s) tipo voto
     */
    public void setTipoVoto(TipoVotoType tipoVoto) {
        this.tipoVoto = tipoVoto;
    }

    /**
     * Obtém o valor do(a)(s) restaurante.
     *
     * @return O(a)(s) restaurante
     */
    public RestauranteDTO getRestaurante() {
        return restaurante;
    }

    /**
     * Define o valor do(a)(s) restaurante.
     *
     * @param restaurante o novo valor do(a)(s) restaurante
     */
    public void setRestaurante(RestauranteDTO restaurante) {
        this.restaurante = restaurante;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
