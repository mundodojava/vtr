package br.com.javatar.votenorestaurante.api.assembler.ranking;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.javatar.votenorestaurante.api.assembler.restaurante.RestauranteAssembler;
import br.com.javatar.votenorestaurante.dto.ranking.TipoVotoType;
import br.com.javatar.votenorestaurante.dto.ranking.VotoDTO;
import br.com.javatar.votenorestaurante.model.ranking.TipoVoto;
import br.com.javatar.votenorestaurante.model.ranking.Voto;

/**
 * The Class VotoAssembler.
 * 
 * @author ismael
 */
@Component
public class VotoAssembler implements Serializable {

    /** A Constante serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** O(a)(s) restaurante assembler. */
    @Autowired
    private RestauranteAssembler restauranteAssembler;

    /**
     * To resource.
     *
     * @param entity O(a)(s) entity
     * @return O(a)(s) voto dto
     */
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

    /**
     * To entity.
     *
     * @param dto O(a)(s) dto
     * @return O(a)(s) voto
     */
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
