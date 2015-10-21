package br.com.javatar.votenorestaurante.dto.ranking;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.com.javatar.votenorestaurante.dto.restaurante.RestauranteDTO;

public class VotoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer nota;

    private TipoVotoType tipoVoto;

    private RestauranteDTO restaurante;

    /**
     * @return the nota
     */
    public Integer getNota() {
        return nota;
    }

    /**
     * @param nota
     *            the nota to set
     */
    public void setNota(Integer nota) {
        this.nota = nota;
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
