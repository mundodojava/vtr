package br.com.javatar.votenorestaurante.api.assembler.ranking;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.javatar.votenorestaurante.api.assembler.restaurante.RestauranteAssembler;
import br.com.javatar.votenorestaurante.dto.ranking.TipoVotoType;
import br.com.javatar.votenorestaurante.dto.ranking.VotoDTO;
import br.com.javatar.votenorestaurante.model.ranking.TipoVoto;
import br.com.javatar.votenorestaurante.model.ranking.Voto;

@Component
public class VotoAssembler implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private RestauranteAssembler restauranteAssembler;

    public VotoDTO toResource(Voto entity) {
        if (entity == null) {
            return null;
        }
        VotoDTO dto = new VotoDTO();
        dto.setNota(entity.getNota());
        dto.setTipoVoto(TipoVotoType.valueOf(entity.getTipoVoto().name()));
        dto.setRestaurante(restauranteAssembler.toResource(entity.getRestaurante()));
        return dto;
    }

    public Voto toEntity(VotoDTO dto) {
        if (dto == null) {
            return null;
        }
        Voto entity = new Voto();
        entity.setNota(dto.getNota());
        entity.setTipoVoto(TipoVoto.valueOf(dto.getTipoVoto().name()));
        entity.setRestaurante(restauranteAssembler.toEntity(dto.getRestaurante()));
        return entity;
    }
}
