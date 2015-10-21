package br.com.javatar.votenorestaurante.model.restaurante;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotBlank;

import br.com.javatar.votenorestaurante.model.base.AbstractPersistable;

/**
 * The Class Restaurante.
 * 
 * @author ismael
 */
@Entity
public class Restaurante extends AbstractPersistable<Long> {

    /** A Constante serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** O(a)(s) logo. */
    @NotBlank(message = "{logo_obrigatorio}")
    @Column(length = 500000)
    private String logo;

    /** O(a)(s) banner. */
    @NotBlank(message = "{banner_obrigatorio}")
    @Column(length = 500000)
    private String banner;

    /** O(a)(s) nome. */
    @NotBlank(message = "{nome_obrigatorio}")
    private String nome;

    /**
     * Obtém o valor do(a)(s) logo.
     *
     * @return O(a)(s) logo
     */
    public String getLogo() {
        return logo;
    }

    /**
     * Define o valor do(a)(s) logo.
     *
     * @param logo o novo valor do(a)(s) logo
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * Obtém o valor do(a)(s) banner.
     *
     * @return O(a)(s) banner
     */
    public String getBanner() {
        return banner;
    }

    /**
     * Define o valor do(a)(s) banner.
     *
     * @param banner o novo valor do(a)(s) banner
     */
    public void setBanner(String banner) {
        this.banner = banner;
    }

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
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
