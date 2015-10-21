package br.com.javatar.votenorestaurante.api.assembler.restaurante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.javatar.votenorestaurante.dto.restaurante.RestauranteDTO;
import br.com.javatar.votenorestaurante.model.restaurante.Restaurante;

import com.google.common.base.Function;

/**
 * The Class RestauranteToRestauranteDTOFunction.
 * 
 * @author ismael
 */
@Component
public class RestauranteToRestauranteDTOFunction implements Function<Restaurante, RestauranteDTO> {

    /** O(a)(s) restaurante assembler. */
    @Autowired
    private RestauranteAssembler restauranteAssembler;

    /*
     * (non-Javadoc)
     * 
     * @see com.google.common.base.Function#apply(java.lang.Object)
     */
    @Override
    public RestauranteDTO apply(Restaurante restaurante) {
        return restauranteAssembler.toResource(restaurante);
    }
}
