package br.com.javatar.votenorestaurante.api.assembler.pessoa;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.javatar.votenorestaurante.dto.pessoa.UsuarioDTO;
import br.com.javatar.votenorestaurante.model.pessoa.Usuario;

/**
 * The Class UsuarioAssembler.
 * 
 * @author ismael
 */
@Component
public class UsuarioAssembler implements Serializable {

    /** A Constante serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** O(a)(s) pessoa assembler. */
    @Autowired
    private PessoaAssembler pessoaAssembler;

    /**
     * To resource.
     *
     * @param entity O(a)(s) entity
     * @return O(a)(s) usuario dto
     */
    public UsuarioDTO toResource(Usuario entity) {
        if (entity == null) {
            return null;
        }
        UsuarioDTO dto = new UsuarioDTO();
        dto.setUsuarioId(entity.getId());
        dto.setPessoa(pessoaAssembler.toResource(entity.getPessoa()));
        return dto;
    }

    /**
     * To entity.
     *
     * @param dto O(a)(s) dto
     * @return O(a)(s) usuario
     */
    public Usuario toEntity(UsuarioDTO dto) {
        if (dto == null) {
            return null;
        }
        Usuario entity = new Usuario();
        entity.setId(dto.getUsuarioId());
        entity.setPessoa(pessoaAssembler.toEntity(dto.getPessoa()));
        return entity;
    }

}
