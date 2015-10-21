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

@Entity
public class Voto extends AbstractPersistable<Long> {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "nota_obrigatoria")
    private Integer nota;

    @OneToOne(cascade = { CascadeType.REFRESH })
    @JoinColumn(name = "restaurante_id")
    @NotNull(message = "{restaurante_obrigatorio}")
    private Restaurante restaurante;

    @NotNull(message = "tipo_voto_obrigatorio")
    @Enumerated(EnumType.STRING)
    private TipoVoto tipoVoto;

    /**
     * @return the restaurante
     */
    public Restaurante getRestaurante() {
        return restaurante;
    }

    /**
     * @param restaurante
     *            the restaurante to set
     */
    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

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
     * @return the tipo
     */
    public TipoVoto getTipoVoto() {
        return tipoVoto;
    }

    /**
     * @param tipo
     *            the tipo to set
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
