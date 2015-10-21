package br.com.javatar.votenorestaurante.model.ranking;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.com.javatar.votenorestaurante.model.base.AbstractPersistable;
import br.com.javatar.votenorestaurante.model.pessoa.Usuario;

/**
 * The Class Ranking.
 * 
 * @author ismael
 */
@Entity
public class Ranking extends AbstractPersistable<Long> {

    /** A Constante serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** O(a)(s) usuario. */
    @OneToOne(cascade = { CascadeType.REFRESH, CascadeType.PERSIST })
    @JoinColumn(name = "usuario_id")
    @NotNull(message = "{usuario_obrigatorio}")
    @Valid
    private Usuario usuario;

    /** O(a)(s) votos. */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Valid
    private Set<Voto> votos;

    /**
     * Obtém o valor do(a)(s) usuario.
     *
     * @return O(a)(s) usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Define o valor do(a)(s) usuario.
     *
     * @param usuario o novo valor do(a)(s) usuario
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtém o valor do(a)(s) votos.
     *
     * @return O(a)(s) votos
     */
    public Set<Voto> getVotos() {
        if (votos == null) {
            this.votos = new HashSet<>();
        }
        return votos;
    }

    /**
     * Define o valor do(a)(s) votos.
     *
     * @param votos o novo valor do(a)(s) votos
     */
    public void setVotos(Set<Voto> votos) {
        this.votos = votos;
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
