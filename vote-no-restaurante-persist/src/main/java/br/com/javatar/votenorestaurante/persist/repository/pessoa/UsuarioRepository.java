package br.com.javatar.votenorestaurante.persist.repository.pessoa;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.javatar.votenorestaurante.model.pessoa.Usuario;

/**
 * The Interface UsuarioRepository.
 * 
 * @author ismael
 */
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

}
