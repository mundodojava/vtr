package br.com.javatar.votenorestaurante.model.pessoa;

import javax.persistence.Entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotBlank;

import br.com.javatar.votenorestaurante.model.base.AbstractPersistable;

/**
 * The Class Pessoa.
 * 
 * @author ismael
 */
@Entity
public class Pessoa extends AbstractPersistable<Long> {

    /** A Constante serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** O(a)(s) nome. */
    @NotBlank(message = "{nome_obrigatorio}")
    private String nome;

    /**
     * Obtém o valor do(a)(s) nome.
     *
     * @return O(a)(s) nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o valor do(a)(s) nome.
     *
     * @param nome o novo valor do(a)(s) nome
     */
    public void setNome(String nome) {
        this.nome = nome;
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
