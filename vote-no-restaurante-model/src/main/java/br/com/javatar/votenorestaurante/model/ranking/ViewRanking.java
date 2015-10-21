package br.com.javatar.votenorestaurante.model.ranking;

import br.com.javatar.votenorestaurante.model.restaurante.Restaurante;

public interface ViewRanking {

    TipoVoto getTipoVoto();

    Integer getMedia();

    Restaurante getRestaurante();

    void setMedia(Integer media);

    void setTipoVoto(TipoVoto valueOf);

    void setRestaurante(Restaurante entity);
    
}
