package br.com.javatar.votenorestaurante.api.assembler.restaurante;

import java.io.Serializable;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.javatar.votenorestaurante.api.controller.restaurante.RestauranteController;
import br.com.javatar.votenorestaurante.dto.restaurante.RestauranteDTO;
import br.com.javatar.votenorestaurante.model.restaurante.Restaurante;

/**
 * The Class RestauranteAssembler.
 * 
 * @author ismael
 */
@Component
public class RestauranteAssembler extends ResourceAssemblerSupport<Restaurante, RestauranteDTO> implements Serializable {

    /** A Constante serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Instancia um novo(a) restaurante assembler.
     */
    public RestauranteAssembler() {
        super(RestauranteController.class, RestauranteDTO.class);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.hateoas.ResourceAssembler#toResource(java.lang.Object)
     */
    @Override
    public RestauranteDTO toResource(Restaurante entity) {
        if (entity == null) {
            return null;
        }
        RestauranteDTO dto = new RestauranteDTO();
        dto.setRestauranteId(entity.getId());
        dto.setBanner(entity.getBanner());
        dto.setNome(entity.getNome());
        dto.setLogo(entity.getLogo());
        return dto;
    }

    /**
     * To entity.
     *
     * @param dto O(a)(s) dto
     * @return O(a)(s) restaurante
     */
    public Restaurante toEntity(RestauranteDTO dto) {
        if (dto == null) {
            return null;
        }
        Restaurante entity = new Restaurante();
        entity.setId(dto.getRestauranteId());
        entity.setBanner(dto.getBanner());
        entity.setNome(dto.getNome());
        entity.setLogo(dto.getLogo());
        return entity;
    }

}
