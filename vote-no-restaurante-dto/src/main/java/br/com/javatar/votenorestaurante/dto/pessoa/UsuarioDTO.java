package br.com.javatar.votenorestaurante.dto.pessoa;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

public class UsuarioDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonIdentityReference
    private String usuarioId;

    private PessoaDTO pessoa;

    /**
     * @return the usuarioId
     */
    public String getUsuarioId() {
        return usuarioId;
    }

    /**
     * @param usuarioId
     *            the usuarioId to set
     */
    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    /**
     * @return the pessoa
     */
    public PessoaDTO getPessoa() {
        return pessoa;
    }

    /**
     * @param pessoa
     *            the pessoa to set
     */
    public void setPessoa(PessoaDTO pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
