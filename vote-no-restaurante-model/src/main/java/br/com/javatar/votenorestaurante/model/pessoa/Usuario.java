package br.com.javatar.votenorestaurante.model.pessoa;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.com.javatar.votenorestaurante.model.base.AbstractPersistableNoGenerator;

/**
 * The Class Usuario.
 * 
 * @author ismael
 */
@Entity
public class Usuario extends AbstractPersistableNoGenerator<String> {

    /** A Constante serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** O(a)(s) pessoa. */
    @OneToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE })
    @JoinColumn(name = "pessoa_id")
    @NotNull(message = "{pessoa_obrigatoria}")
    @Valid
    private Pessoa pessoa;

    /**
     * Obtém o valor do(a)(s) pessoa.
     *
     * @return O(a)(s) pessoa
     */
    public Pessoa getPessoa() {
        return pessoa;
    }

    /**
     * Define o valor do(a)(s) pessoa.
     *
     * @param pessoa o novo valor do(a)(s) pessoa
     */
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.javatar.votenorestaurante.model.base.AbstractPersistableNoGenerator#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
