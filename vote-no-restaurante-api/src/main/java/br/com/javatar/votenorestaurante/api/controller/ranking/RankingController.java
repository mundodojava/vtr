package br.com.javatar.votenorestaurante.api.controller.ranking;

import io.swagger.annotations.Api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.javatar.votenorestaurante.api.assembler.ranking.RankingAssembler;
import br.com.javatar.votenorestaurante.api.assembler.ranking.ViewRankingToViewRankingDTOFunction;
import br.com.javatar.votenorestaurante.api.exception.BadRequestException;
import br.com.javatar.votenorestaurante.dto.ranking.RankingDTO;
import br.com.javatar.votenorestaurante.dto.ranking.ViewRankingDTO;
import br.com.javatar.votenorestaurante.model.ranking.RankingGeral;
import br.com.javatar.votenorestaurante.model.ranking.RankingGeralCustoBeneficio;
import br.com.javatar.votenorestaurante.model.ranking.RankingUsuario;
import br.com.javatar.votenorestaurante.model.ranking.RankingUsuarioCustoBeneficio;
import br.com.javatar.votenorestaurante.model.ranking.TipoVoto;
import br.com.javatar.votenorestaurante.service.ranking.RankingService;
import br.com.javatar.votenorestaurante.service.ranking.ViewRankingService;

import com.google.common.collect.Lists;

/**
 * The Class RankingController.
 * 
 * @author ismael
 */
@Api(value="Ranking")
@RestController
@RequestMapping(value = "/rankings")
public class RankingController {

    /** O(a)(s) ranking service. */
    @Autowired
    private RankingService rankingService;

    /** O(a)(s) view ranking service. */
    @Autowired
    private ViewRankingService viewRankingService;

    /** O(a)(s) ranking assembler. */
    @Autowired
    private RankingAssembler rankingAssembler;

    /** O(a)(s) view ranking to view ranking dto function. */
    @Autowired
    private ViewRankingToViewRankingDTOFunction viewRankingToViewRankingDTOFunction;

    /**
     * Salvar.
     *
     * @param rankingDTO O(a)(s) ranking dto
     * @return O(a)(s) response entity
     */
    @RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public ResponseEntity<Void> salvar(@RequestBody RankingDTO rankingDTO) {
        rankingService.salvar(rankingAssembler.toEntity(rankingDTO));
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    /**
     * View ranking sabor.
     *
     * @return O(a)(s) response entity
     */
    @RequestMapping(value = "/{tipoVoto}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public ResponseEntity<List<ViewRankingDTO>> viewRankingGeralPorTipo(@PathVariable("tipoVoto") String tipoVoto) {
        TipoVoto tipo = obterTipoVoto(tipoVoto);
        List<RankingGeral> view = viewRankingService.viewRankingGeralPorTipo(tipo);
        return new ResponseEntity<List<ViewRankingDTO>>(Lists.transform(view, viewRankingToViewRankingDTOFunction), HttpStatus.OK);
    }

    /**
     * View ranking custo beneficio.
     *
     * @return O(a)(s) response entity
     */
    @RequestMapping(value = "/custobeneficio", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public ResponseEntity<List<ViewRankingDTO>> viewRankingCustoBeneficio() {
        List<RankingGeralCustoBeneficio> view = viewRankingService.viewRankingCustoBeneficio();
        return new ResponseEntity<List<ViewRankingDTO>>(Lists.transform(view, viewRankingToViewRankingDTOFunction), HttpStatus.OK);
    }

    /**
     * View ranking por tipo voto.
     *
     * @param tipoVoto O(a)(s) tipo voto
     * @param email O(a)(s) email
     * @return O(a)(s) response entity
     */
    @RequestMapping(value = "/{tipoVoto}/usuarios", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public ResponseEntity<List<ViewRankingDTO>> viewRankingPorTipoVoto(@PathVariable("tipoVoto") String tipoVoto, @RequestParam("email") String email) {
        validarEmail(email);
        TipoVoto tipo = obterTipoVoto(tipoVoto);
        List<RankingUsuario> view = viewRankingService.viewRankingPorUsuarioETipoVoto(email, tipo);
        return new ResponseEntity<List<ViewRankingDTO>>(Lists.transform(view, viewRankingToViewRankingDTOFunction), HttpStatus.OK);
    }

    /**
     * View ranking custo beneficio usuario.
     *
     * @param email O(a)(s) email
     * @return O(a)(s) response entity
     */
    @RequestMapping(value = "/custobeneficio/usuarios", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public ResponseEntity<List<ViewRankingDTO>> viewRankingCustoBeneficioUsuario(@RequestParam("email") String email) {
        validarEmail(email);
        List<RankingUsuarioCustoBeneficio> view = viewRankingService.viewRankingCustoBeneficioUsuario(email);
        return new ResponseEntity<List<ViewRankingDTO>>(Lists.transform(view, viewRankingToViewRankingDTOFunction), HttpStatus.OK);
    }

    /**
     * Validar email.
     *
     * @param email O(a)(s) email
     */
    public void validarEmail(String email) {
        if (email == null) {
            throw new BadRequestException("invalid email");
        }
    }

    /**
     * Obter tipo voto.
     *
     * @param tipoVoto O(a)(s) tipo voto
     * @return O(a)(s) tipo voto
     */
    public TipoVoto obterTipoVoto(String tipoVoto) {
        TipoVoto[] values = TipoVoto.values();
        TipoVoto tipo = null;
        for(TipoVoto voto : values) {
            if (voto.name().equals(tipoVoto.toUpperCase())) {
                tipo = TipoVoto.valueOf(tipoVoto.toUpperCase());
                break;
            }
        }
        if (tipo == null) {
            throw new BadRequestException("invalid tipo voto");
        }
        return tipo;
    }
}
