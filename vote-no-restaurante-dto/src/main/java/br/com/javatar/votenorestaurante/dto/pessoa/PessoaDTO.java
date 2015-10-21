package br.com.javatar.votenorestaurante.dto.pessoa;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

/**
 * The Class PessoaDTO.
 * 
 * @author ismael
 */
public class PessoaDTO implements Serializable {

    /** A Constante serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** O(a)(s) pessoa id. */
    @JsonIdentityReference
    private Long pessoaId;

    /** O(a)(s) nome. */
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

    /**
     * Obtém o valor do(a)(s) pessoa id.
     *
     * @return O(a)(s) pessoa id
     */
    public Long getPessoaId() {
        return pessoaId;
    }

    /**
     * Define o valor do(a)(s) pessoa id.
     *
     * @param pessoaId o novo valor do(a)(s) pessoa id
     */
    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
