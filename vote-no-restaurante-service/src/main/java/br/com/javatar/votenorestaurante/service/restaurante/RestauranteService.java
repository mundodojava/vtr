package br.com.javatar.votenorestaurante.service.restaurante;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.javatar.votenorestaurante.model.restaurante.Restaurante;
import br.com.javatar.votenorestaurante.persist.repository.restaurante.RestauranteRepository;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    public List<Restaurante> buscarTodos() {
        return restauranteRepository.findAll();
    }

    public Restaurante buscar(Long restauranteId) {
        //TODO colocar tratamento pra not found
        return restauranteRepository.findOne(restauranteId);
    }

}
