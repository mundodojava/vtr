package br.com.javatar.votenorestaurante.api.assembler.ranking;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.javatar.votenorestaurante.api.assembler.restaurante.RestauranteAssembler;
import br.com.javatar.votenorestaurante.dto.ranking.TipoVotoType;
import br.com.javatar.votenorestaurante.dto.ranking.ViewRankingDTO;
import br.com.javatar.votenorestaurante.model.ranking.TipoVoto;
import br.com.javatar.votenorestaurante.model.ranking.ViewRanking;
import br.com.javatar.votenorestaurante.service.exception.BusinessException;

@Component
public class ViewRankingAssembler implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private RestauranteAssembler restauranteAssembler;

    public <T> ViewRankingDTO toResource(ViewRanking entity) {
        if (entity == null) {
            return null;
        }
        ViewRankingDTO dto = new ViewRankingDTO();
        dto.setMedia(entity.getMedia());
        if (entity.getTipoVoto() != null) {
            dto.setTipoVoto(TipoVotoType.valueOf(entity.getTipoVoto().name()));
        }
        dto.setRestaurante(restauranteAssembler.toResource(entity.getRestaurante()));
        return dto;
    }

    public <T extends ViewRanking> ViewRanking toEntity(Class<T> clazz, ViewRankingDTO dto) {
        if (dto == null) {
            return null;
        }
        ViewRanking entity;
        try {
            entity = clazz.newInstance();
            entity.setMedia(dto.getMedia());
            if (dto.getTipoVoto() != null) {
                entity.setTipoVoto(TipoVoto.valueOf(dto.getTipoVoto().name()));
            }
            entity.setRestaurante(restauranteAssembler.toEntity(dto.getRestaurante()));
            return entity;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BusinessException("Problema ao converter dados");
        }
    }
}
