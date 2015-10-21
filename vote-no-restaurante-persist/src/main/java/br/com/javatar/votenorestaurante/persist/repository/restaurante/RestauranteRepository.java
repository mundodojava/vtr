package br.com.javatar.votenorestaurante.persist.repository.restaurante;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.javatar.votenorestaurante.model.restaurante.Restaurante;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
}
