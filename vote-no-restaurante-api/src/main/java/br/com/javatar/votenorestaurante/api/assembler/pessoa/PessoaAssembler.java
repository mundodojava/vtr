package br.com.javatar.votenorestaurante.api.assembler.pessoa;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import br.com.javatar.votenorestaurante.dto.pessoa.PessoaDTO;
import br.com.javatar.votenorestaurante.model.pessoa.Pessoa;

@Component
public class PessoaAssembler implements Serializable {

    private static final long serialVersionUID = 1L;

    public PessoaDTO toResource(Pessoa entity) {
        if (entity == null) {
            return null;
        }
        PessoaDTO dto = new PessoaDTO();
        dto.setPessoaId(entity.getId());
        dto.setNome(entity.getNome());
        return dto;
    }

    public Pessoa toEntity(PessoaDTO dto) {
        if (dto == null) {
            return null;
        }
        Pessoa entity = new Pessoa();
        entity.setId(dto.getPessoaId());
        entity.setNome(dto.getNome());
        return entity;
    }

}
