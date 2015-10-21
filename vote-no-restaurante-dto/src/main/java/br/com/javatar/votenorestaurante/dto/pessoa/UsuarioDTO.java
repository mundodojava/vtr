package br.com.javatar.votenorestaurante.dto.pessoa;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

/**
 * The Class UsuarioDTO.
 * 
 * @author ismael
 */
public class UsuarioDTO implements Serializable {

    /** A Constante serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** O(a)(s) usuario id. */
    @JsonIdentityReference
    private String usuarioId;

    /** O(a)(s) pessoa. */
    private PessoaDTO pessoa;

    /**
     * Obtém o valor do(a)(s) usuario id.
     *
     * @return O(a)(s) usuario id
     */
    public String getUsuarioId() {
        return usuarioId;
    }

    /**
     * Define o valor do(a)(s) usuario id.
     *
     * @param usuarioId o novo valor do(a)(s) usuario id
     */
    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    /**
     * Obtém o valor do(a)(s) pessoa.
     *
     * @return O(a)(s) pessoa
     */
    public PessoaDTO getPessoa() {
        return pessoa;
    }

    /**
     * Define o valor do(a)(s) pessoa.
     *
     * @param pessoa o novo valor do(a)(s) pessoa
     */
    public void setPessoa(PessoaDTO pessoa) {
        this.pessoa = pessoa;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
