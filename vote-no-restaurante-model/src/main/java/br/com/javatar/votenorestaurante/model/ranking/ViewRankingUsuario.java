package br.com.javatar.votenorestaurante.model.ranking;

import br.com.javatar.votenorestaurante.model.pessoa.Usuario;
import br.com.javatar.votenorestaurante.model.restaurante.Restaurante;

public interface ViewRankingUsuario {

    Usuario getUsuario();

    Integer getMedia();

    Restaurante getRestaurante();

    void setMedia(Integer media);

    void setUsuario(Usuario usuario);

    void setRestaurante(Restaurante entity);
    
}
