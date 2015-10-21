package br.com.javatar.votenorestaurante.api.assembler.ranking;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import br.com.javatar.votenorestaurante.api.assembler.pessoa.UsuarioAssembler;
import br.com.javatar.votenorestaurante.api.controller.ranking.RankingController;
import br.com.javatar.votenorestaurante.dto.ranking.RankingDTO;
import br.com.javatar.votenorestaurante.dto.ranking.VotoDTO;
import br.com.javatar.votenorestaurante.model.ranking.Ranking;
import br.com.javatar.votenorestaurante.model.ranking.Voto;

/**
 * The Class RankingAssembler.
 * 
 * @author ismael
 */
@Component
public class RankingAssembler extends ResourceAssemblerSupport<Ranking, RankingDTO> implements Serializable {

    /** A Constante serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** O(a)(s) usuario assembler. */
    @Autowired
    private UsuarioAssembler usuarioAssembler;

    /** O(a)(s) voto assembler. */
    @Autowired
    private VotoAssembler votoAssembler;

    /**
     * Instancia um novo(a) ranking assembler.
     */
    public RankingAssembler() {
        super(RankingController.class, RankingDTO.class);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.hateoas.ResourceAssembler#toResource(java.lang.Object)
     */
    @Override
    public RankingDTO toResource(Ranking entity) {
        if (entity == null) {
            return null;
        }
        RankingDTO dto = new RankingDTO();
        dto.setRankingId(entity.getId());
        for(Voto voto : entity.getVotos()) {
            dto.getVotos().add(votoAssembler.toResource(voto));
        }
        dto.setUsuario(usuarioAssembler.toResource(entity.getUsuario()));
        return dto;
    }

    /**
     * To entity.
     *
     * @param dto O(a)(s) dto
     * @return O(a)(s) ranking
     */
    public Ranking toEntity(RankingDTO dto) {
        if (dto == null) {
            return null;
        }
        Ranking entity = new Ranking();
        entity.setId(dto.getRankingId());
        for(VotoDTO votoDTO : dto.getVotos()) {
            entity.getVotos().add(votoAssembler.toEntity(votoDTO));
        }
        entity.setUsuario(usuarioAssembler.toEntity(dto.getUsuario()));
        return entity;
    }

}
