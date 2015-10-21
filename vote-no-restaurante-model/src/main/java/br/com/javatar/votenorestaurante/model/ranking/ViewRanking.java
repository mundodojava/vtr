package br.com.javatar.votenorestaurante.model.ranking;

import br.com.javatar.votenorestaurante.model.restaurante.Restaurante;

/**
 * The Interface ViewRanking.
 * 
 * @author ismael
 */
public interface ViewRanking {

    /**
     * Obtém o valor do(a)(s) tipo voto.
     *
     * @return O(a)(s) tipo voto
     */
    TipoVoto getTipoVoto();

    /**
     * Obtém o valor do(a)(s) media.
     *
     * @return O(a)(s) media
     */
    Integer getMedia();

    /**
     * Obtém o valor do(a)(s) restaurante.
     *
     * @return O(a)(s) restaurante
     */
    Restaurante getRestaurante();

    /**
     * Define o valor do(a)(s) media.
     *
     * @param media o novo valor do(a)(s) media
     */
    void setMedia(Integer media);

    /**
     * Define o valor do(a)(s) tipo voto.
     *
     * @param valueOf o novo valor do(a)(s) tipo voto
     */
    void setTipoVoto(TipoVoto valueOf);

    /**
     * Define o valor do(a)(s) restaurante.
     *
     * @param entity o novo valor do(a)(s) restaurante
     */
    void setRestaurante(Restaurante entity);
    
}
