package br.com.javatar.votenorestaurante.persist.repository.pessoa;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.javatar.votenorestaurante.model.pessoa.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

}
