package br.com.javatar.votenorestaurante.api.assembler.restaurante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.javatar.votenorestaurante.dto.restaurante.RestauranteDTO;
import br.com.javatar.votenorestaurante.model.restaurante.Restaurante;

import com.google.common.base.Function;

@Component
public class RestauranteToRestauranteDTOFunction implements Function<Restaurante, RestauranteDTO> {

    @Autowired
    private RestauranteAssembler restauranteAssembler;

    @Override
    public RestauranteDTO apply(Restaurante restaurante) {
        return restauranteAssembler.toResource(restaurante);
    }
}
