package br.com.javatar.votenorestaurante.model.pessoa;

import javax.persistence.Entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotBlank;

import br.com.javatar.votenorestaurante.model.base.AbstractPersistable;

@Entity
public class Pessoa extends AbstractPersistable<Long> {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "{nome_obrigatorio}")
    private String nome;

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome
     *            the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
