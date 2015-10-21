package br.com.javatar.votenorestaurante.dto.restaurante;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.hateoas.ResourceSupport;

/**
 * The Class RestauranteDTO.
 * 
 * @author ismael
 */
public class RestauranteDTO extends ResourceSupport implements Serializable {

    /** A Constante serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** O(a)(s) restaurante id. */
    private Long restauranteId;

    /** O(a)(s) logo. */
    private String logo;

    /** O(a)(s) banner. */
    private String banner;

    /** O(a)(s) nome. */
    private String nome;
    
    /**
     * Obtém o valor do(a)(s) restaurante id.
     *
     * @return O(a)(s) restaurante id
     */
    public Long getRestauranteId() {
        return restauranteId;
    }

    /**
     * Define o valor do(a)(s) restaurante id.
     *
     * @param restauranteId o novo valor do(a)(s) restaurante id
     */
    public void setRestauranteId(Long restauranteId) {
        this.restauranteId = restauranteId;
    }

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

    /* (non-Javadoc)
     * @see org.springframework.hateoas.ResourceSupport#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
