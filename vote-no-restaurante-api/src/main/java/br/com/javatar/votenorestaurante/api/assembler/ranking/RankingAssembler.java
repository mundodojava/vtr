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

@Component
public class RankingAssembler extends ResourceAssemblerSupport<Ranking, RankingDTO> implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Autowired
    private UsuarioAssembler usuarioAssembler;
    
    @Autowired
    private VotoAssembler votoAssembler;
    
    public RankingAssembler() {
        super(RankingController.class, RankingDTO.class);
    }

    @Override
    public RankingDTO toResource(Ranking entity) {
        if (entity == null) {
            return null;
        }
        RankingDTO dto = new RankingDTO();
        dto.setRankingId(entity.getId());
        for (Voto voto : entity.getVotos()) {
            dto.getVotos().add(votoAssembler.toResource(voto));
        }
        dto.setUsuario(usuarioAssembler.toResource(entity.getUsuario()));
        return dto;
    }

    public Ranking toEntity(RankingDTO dto) {
        if (dto == null) {
            return null;
        }
        Ranking entity = new Ranking();
        entity.setId(dto.getRankingId());
        for (VotoDTO votoDTO : dto.getVotos()) {
            entity.getVotos().add(votoAssembler.toEntity(votoDTO));
        }
        entity.setUsuario(usuarioAssembler.toEntity(dto.getUsuario()));
        return entity;
    }

}
