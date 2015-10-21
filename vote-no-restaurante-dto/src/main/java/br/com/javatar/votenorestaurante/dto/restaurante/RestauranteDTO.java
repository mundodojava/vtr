package br.com.javatar.votenorestaurante.dto.restaurante;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.hateoas.ResourceSupport;

public class RestauranteDTO extends ResourceSupport implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long restauranteId;

    private String logo;

    private String banner;

    private String nome;
    
    /**
     * @return the restauranteId
     */
    public Long getRestauranteId() {
        return restauranteId;
    }

    /**
     * @param restauranteId the restauranteId to set
     */
    public void setRestauranteId(Long restauranteId) {
        this.restauranteId = restauranteId;
    }

    /**
     * @return the logo
     */
    public String getLogo() {
        return logo;
    }

    /**
     * @param logo the logo to set
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
     * @param banner the banner to set
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
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
