package br.com.javatar.votenorestaurante.api.controller.restaurante;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.javatar.votenorestaurante.api.assembler.restaurante.RestauranteToRestauranteDTOFunction;
import br.com.javatar.votenorestaurante.dto.restaurante.RestauranteDTO;
import br.com.javatar.votenorestaurante.model.restaurante.Restaurante;
import br.com.javatar.votenorestaurante.service.restaurante.RestauranteService;

import com.google.common.collect.Lists;

/**
 * The Class RestauranteController.
 * 
 * @author ismael
 */
@RestController
@RequestMapping(value = "restaurantes", produces = { MediaType.APPLICATION_JSON_VALUE })
public class RestauranteController {

    /** O(a)(s) restaurante service. */
    @Autowired
    private RestauranteService restauranteService;

    /** O(a)(s) to restaurante dto function. */
    @Autowired
    private RestauranteToRestauranteDTOFunction toRestauranteDTOFunction;

    /**
     * Listar.
     *
     * @return O(a)(s) response entity
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<RestauranteDTO>> listar() {
        List<Restaurante> restaurantes = restauranteService.buscarTodos();
        return new ResponseEntity<List<RestauranteDTO>>(Lists.transform(restaurantes, toRestauranteDTOFunction), HttpStatus.OK);
    }

}
