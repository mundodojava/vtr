package br.com.javatar.votenorestaurante.api.assembler.ranking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.javatar.votenorestaurante.dto.ranking.ViewRankingDTO;
import br.com.javatar.votenorestaurante.model.ranking.ViewRanking;

import com.google.common.base.Function;

@Component
public class ViewRankingToViewRankingDTOFunction implements Function<ViewRanking, ViewRankingDTO> {

    @Autowired
    private ViewRankingAssembler viewRankingAssembler;

    @Override
    public ViewRankingDTO apply(ViewRanking viewRanking) {
        return viewRankingAssembler.toResource(viewRanking);
    }
}
