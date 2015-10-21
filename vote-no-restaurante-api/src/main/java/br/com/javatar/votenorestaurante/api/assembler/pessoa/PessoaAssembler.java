package br.com.javatar.votenorestaurante.api.assembler.pessoa;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import br.com.javatar.votenorestaurante.dto.pessoa.PessoaDTO;
import br.com.javatar.votenorestaurante.model.pessoa.Pessoa;

/**
 * The Class PessoaAssembler.
 * 
 * @author ismael
 */
@Component
public class PessoaAssembler implements Serializable {

    /** A Constante serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * To resource.
     *
     * @param entity O(a)(s) entity
     * @return O(a)(s) pessoa dto
     */
    public PessoaDTO toResource(Pessoa entity) {
        if (entity == null) {
            return null;
        }
        PessoaDTO dto = new PessoaDTO();
        dto.setPessoaId(entity.getId());
        dto.setNome(entity.getNome());
        return dto;
    }

    /**
     * To entity.
     *
     * @param dto O(a)(s) dto
     * @return O(a)(s) pessoa
     */
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
