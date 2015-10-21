package br.com.javatar.votenorestaurante.model.restaurante;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotBlank;

import br.com.javatar.votenorestaurante.model.base.AbstractPersistable;

@Entity
public class Restaurante extends AbstractPersistable<Long> {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "{logo_obrigatorio}")
    @Column(length = 500000)
    private String logo;

    @NotBlank(message = "{banner_obrigatorio}")
    @Column(length = 500000)
    private String banner;

    @NotBlank(message = "{nome_obrigatorio}")
    private String nome;

    /**
     * @return the logo
     */
    public String getLogo() {
        return logo;
    }

    /**
     * @param logo
     *            the logo to set
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * @return the banner
     */
    public String getBanner() {
        return banner;
    }

    /**
     * @param banner
     *            the banner to set
     */
    public void setBanner(String banner) {
        this.banner = banner;
    }

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
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
