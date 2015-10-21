package br.com.javatar.votenorestaurante.service.restaurante;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.javatar.votenorestaurante.model.restaurante.Restaurante;
import br.com.javatar.votenorestaurante.persist.repository.restaurante.RestauranteRepository;

/**
 * The Class RestauranteService.
 * 
 * @author ismael
 */
@Service
public class RestauranteService {

    /** O(a)(s) restaurante repository. */
    @Autowired
    private RestauranteRepository restauranteRepository;

    /**
     * Buscar todos.
     *
     * @return O(a)(s) list
     */
    public List<Restaurante> buscarTodos() {
        return restauranteRepository.findAll();
    }

    /**
     * Buscar.
     *
     * @param restauranteId O(a)(s) restaurante id
     * @return O(a)(s) restaurante
     */
    public Restaurante buscar(Long restauranteId) {
        return restauranteRepository.findOne(restauranteId);
    }

}
