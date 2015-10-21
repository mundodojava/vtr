package br.com.javatar.votenorestaurante.dto.pessoa;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

public class PessoaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonIdentityReference
    private Long pessoaId;

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

    /**
     * @return the pessoaId
     */
    public Long getPessoaId() {
        return pessoaId;
    }

    /**
     * @param pessoaId
     *            the pessoaId to set
     */
    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
