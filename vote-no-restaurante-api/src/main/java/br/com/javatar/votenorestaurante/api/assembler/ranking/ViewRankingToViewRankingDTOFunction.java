package br.com.javatar.votenorestaurante.api.assembler.ranking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.javatar.votenorestaurante.dto.ranking.ViewRankingDTO;
import br.com.javatar.votenorestaurante.model.ranking.ViewRanking;

import com.google.common.base.Function;

/**
 * The Class ViewRankingToViewRankingDTOFunction.
 * 
 * @author ismael
 */
@Component
public class ViewRankingToViewRankingDTOFunction implements Function<ViewRanking, ViewRankingDTO> {

    /** O(a)(s) view ranking assembler. */
    @Autowired
    private ViewRankingAssembler viewRankingAssembler;

    /*
     * (non-Javadoc)
     * 
     * @see com.google.common.base.Function#apply(java.lang.Object)
     */
    @Override
    public ViewRankingDTO apply(ViewRanking viewRanking) {
        return viewRankingAssembler.toResource(viewRanking);
    }
}
