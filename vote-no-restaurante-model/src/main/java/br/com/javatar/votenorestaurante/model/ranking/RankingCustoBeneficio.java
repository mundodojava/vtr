package br.com.javatar.votenorestaurante.model.ranking;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.javatar.votenorestaurante.model.base.AbstractPersistableNoGenerator;
import br.com.javatar.votenorestaurante.model.restaurante.Restaurante;

@Entity
public class RankingCustoBeneficio extends AbstractPersistableNoGenerator<String> implements ViewRanking {

    private static final long serialVersionUID = 1L;

    private Integer media;

    @ManyToOne
    @JoinColumn(columnDefinition = "restaurante_id", name = "restaurante_id")
    private Restaurante restaurante;

    /**
     * @return the tipoVoto
     */
    @Override
    public TipoVoto getTipoVoto() {
        return null;
    }

    @Override
    public void setTipoVoto(TipoVoto tipoVoto) {
        // Não implementar
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
    @Override
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
    @Override
    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

}
