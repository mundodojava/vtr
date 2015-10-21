package br.com.javatar.votenorestaurante.model.ranking;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.javatar.votenorestaurante.model.base.AbstractPersistableNoGenerator;
import br.com.javatar.votenorestaurante.model.restaurante.Restaurante;

/**
 * The Class RankingDemora.
 * 
 * @author ismael
 */
@Entity
public class RankingDemora extends AbstractPersistableNoGenerator<String> implements ViewRanking {

    /** A Constante serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** O(a)(s) tipo voto. */
    @Enumerated(EnumType.STRING)
    private TipoVoto tipoVoto;

    /** O(a)(s) media. */
    private Integer media;

    /** O(a)(s) restaurante. */
    @ManyToOne
    @JoinColumn(columnDefinition = "restaurante_id", name = "restaurante_id")
    private Restaurante restaurante;

    /*
     * (non-Javadoc)
     * 
     * @see br.com.javatar.votenorestaurante.model.ranking.ViewRanking#getTipoVoto()
     */
    @Override
    public TipoVoto getTipoVoto() {
        return tipoVoto;
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.javatar.votenorestaurante.model.ranking.ViewRanking#setTipoVoto(br.com.javatar.votenorestaurante.model.ranking.TipoVoto)
     */
    @Override
    public void setTipoVoto(TipoVoto tipoVoto) {
        this.tipoVoto = tipoVoto;
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.javatar.votenorestaurante.model.ranking.ViewRanking#getMedia()
     */
    @Override
    public Integer getMedia() {
        return media;
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.javatar.votenorestaurante.model.ranking.ViewRanking#setMedia(java.lang.Integer)
     */
    @Override
    public void setMedia(Integer media) {
        this.media = media;
    }

    /*
     * (non-Javadoc)
     * 
     * @see br.com.javatar.votenorestaurante.model.ranking.ViewRanking#getRestaurante()
     */
    @Override
    public Restaurante getRestaurante() {
        return restaurante;
    }

    /**
     * Define o valor do(a)(s) restaurante.
     *
     * @param restaurante the restaurante to set
     */
    @Override
    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

}
