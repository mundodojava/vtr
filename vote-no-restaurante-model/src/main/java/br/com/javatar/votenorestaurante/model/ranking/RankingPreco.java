package br.com.javatar.votenorestaurante.model.ranking;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.javatar.votenorestaurante.model.base.AbstractPersistableNoGenerator;
import br.com.javatar.votenorestaurante.model.restaurante.Restaurante;

@Entity
public class RankingPreco extends AbstractPersistableNoGenerator<String> implements ViewRanking {

    private static final long serialVersionUID = 1L;

    @Enumerated(EnumType.STRING)
    private TipoVoto tipoVoto;

    private Integer media;

    @ManyToOne
    @JoinColumn(columnDefinition = "restaurante_id", name = "restaurante_id")
    private Restaurante restaurante;

    /**
     * @return the tipoVoto
     */
    @Override
    public TipoVoto getTipoVoto() {
        return tipoVoto;
    }

    /**
     * @param tipoVoto
     *            the tipoVoto to set
     */
    public void setTipoVoto(TipoVoto tipoVoto) {
        this.tipoVoto = tipoVoto;
    }

    /**
     * @return the media
     */
    @Override
    public Integer getMedia() {
        return media;
    }

    /**
     * @param media
     *            the media to set
     */
    public void setMedia(Integer media) {
        this.media = media;
    }

    /**
     * @return the restaurante
     */
    @Override
    public Restaurante getRestaurante() {
        return restaurante;
    }

    /**
     * @param restaurante
     *            the restaurante to set
     */
    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

}
