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

@Entity
public class Ranking extends AbstractPersistable<Long> {

    private static final long serialVersionUID = 1L;

    @OneToOne(cascade = { CascadeType.REFRESH, CascadeType.PERSIST })
    @JoinColumn(name = "usuario_id")
    @NotNull(message = "{usuario_obrigatorio}")
    @Valid
    private Usuario usuario;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Valid
    private Set<Voto> votos;
    
    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Set<Voto> getVotos() {
        if (votos == null) {
            this.votos = new HashSet<>();
        }
        return votos;
    }

    public void setVotos(Set<Voto> votos) {
        this.votos = votos;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
