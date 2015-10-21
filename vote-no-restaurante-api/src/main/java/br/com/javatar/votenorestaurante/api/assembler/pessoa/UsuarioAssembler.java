package br.com.javatar.votenorestaurante.api.assembler.pessoa;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.javatar.votenorestaurante.dto.pessoa.UsuarioDTO;
import br.com.javatar.votenorestaurante.model.pessoa.Usuario;

@Component
public class UsuarioAssembler implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private PessoaAssembler pessoaAssembler;

    public UsuarioDTO toResource(Usuario entity) {
        if (entity == null) {
            return null;
        }
        UsuarioDTO dto = new UsuarioDTO();
        dto.setUsuarioId(entity.getId());
        dto.setPessoa(pessoaAssembler.toResource(entity.getPessoa()));
        return dto;
    }

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
