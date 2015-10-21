package br.com.javatar.votenorestaurante.dto.ranking;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.com.javatar.votenorestaurante.dto.restaurante.RestauranteDTO;

public class ViewRankingDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer media;

    private TipoVotoType tipoVoto;

    private RestauranteDTO restaurante;

    /**
     * @return the media
     */
    public Integer getMedia() {
        return media;
    }

    /**
     * @param media
     *            the media to set
     */
    public void setMedia(Integer media) {
        this.media = media;
    }

    /**
     * @return the tipoVoto
     */
    public TipoVotoType getTipoVoto() {
        return tipoVoto;
    }

    /**
     * @param tipoVoto
     *            the tipoVoto to set
     */
    public void setTipoVoto(TipoVotoType tipoVoto) {
        this.tipoVoto = tipoVoto;
    }

    /**
     * @return the restaurante
     */
    public RestauranteDTO getRestaurante() {
        return restaurante;
    }

    /**
     * @param restaurante
     *            the restaurante to set
     */
    public void setRestaurante(RestauranteDTO restaurante) {
        this.restaurante = restaurante;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
