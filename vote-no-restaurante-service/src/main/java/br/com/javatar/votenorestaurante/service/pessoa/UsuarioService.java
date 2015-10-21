package br.com.javatar.votenorestaurante.service.pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.javatar.votenorestaurante.persist.repository.pessoa.UsuarioRepository;

/**
 * The Class UsuarioService.
 * 
 * @author ismael
 */
@Service
public class UsuarioService {

    /** O(a)(s) usuario repository. */
    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Exists.
     *
     * @param id O(a)(s) id
     * @return true, if successful
     */
    public boolean exists(String id) {
        return usuarioRepository.exists(id);
    }

}
