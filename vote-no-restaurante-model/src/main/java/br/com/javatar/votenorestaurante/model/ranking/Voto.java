package br.com.javatar.votenorestaurante.model.ranking;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.com.javatar.votenorestaurante.model.base.AbstractPersistable;
import br.com.javatar.votenorestaurante.model.restaurante.Restaurante;

/**
 * The Class Voto.
 * 
 * @author ismael
 */
@Entity
public class Voto extends AbstractPersistable<Long> {

    /** A Constante serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** O(a)(s) nota. */
    @NotNull(message = "nota_obrigatoria")
    private Integer nota;

    /** O(a)(s) restaurante. */
    @OneToOne(cascade = { CascadeType.REFRESH })
    @JoinColumn(name = "restaurante_id")
    @NotNull(message = "{restaurante_obrigatorio}")
    private Restaurante restaurante;

    /** O(a)(s) tipo voto. */
    @NotNull(message = "tipo_voto_obrigatorio")
    @Enumerated(EnumType.STRING)
    private TipoVoto tipoVoto;

    /**
     * Obtém o valor do(a)(s) restaurante.
     *
     * @return O(a)(s) restaurante
     */
    public Restaurante getRestaurante() {
        return restaurante;
    }

    /**
     * Define o valor do(a)(s) restaurante.
     *
     * @param restaurante o novo valor do(a)(s) restaurante
     */
    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    /**
     * Obtém o valor do(a)(s) nota.
     *
     * @return O(a)(s) nota
     */
    public Integer getNota() {
        return nota;
    }

    /**
     * Define o valor do(a)(s) nota.
     *
     * @param nota o novo valor do(a)(s) nota
     */
    public void setNota(Integer nota) {
        this.nota = nota;
    }

    /**
     * Obtém o valor do(a)(s) tipo voto.
     *
     * @return O(a)(s) tipo voto
     */
    public TipoVoto getTipoVoto() {
        return tipoVoto;
    }

    /**
     * Define o valor do(a)(s) tipo voto.
     *
     * @param tipoVoto o novo valor do(a)(s) tipo voto
     */
    public void setTipoVoto(TipoVoto tipoVoto) {
        this.tipoVoto = tipoVoto;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((tipoVoto == null) ? 0 : tipoVoto.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (!(obj instanceof Voto)) {
            return false;
        }
        Voto other = (Voto) obj;
        if (tipoVoto != other.tipoVoto) {
            return false;
        }
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.javatar.votenorestaurante.model.base.AbstractPersistable#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
