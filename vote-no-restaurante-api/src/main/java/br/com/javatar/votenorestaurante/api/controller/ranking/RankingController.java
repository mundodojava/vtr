package br.com.javatar.votenorestaurante.api.controller.ranking;

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
import br.com.javatar.votenorestaurante.model.ranking.RankingAtendimento;
import br.com.javatar.votenorestaurante.model.ranking.RankingCustoBeneficio;
import br.com.javatar.votenorestaurante.model.ranking.RankingCustoBeneficioUsuario;
import br.com.javatar.votenorestaurante.model.ranking.RankingDemora;
import br.com.javatar.votenorestaurante.model.ranking.RankingLocalizacao;
import br.com.javatar.votenorestaurante.model.ranking.RankingPreco;
import br.com.javatar.votenorestaurante.model.ranking.RankingSabor;
import br.com.javatar.votenorestaurante.model.ranking.RankingUsuario;
import br.com.javatar.votenorestaurante.model.ranking.TipoVoto;
import br.com.javatar.votenorestaurante.service.ranking.RankingService;
import br.com.javatar.votenorestaurante.service.ranking.ViewRankingService;

import com.google.common.collect.Lists;

/**
 * The Class RankingController.
 * 
 * @author ismael
 */
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
    @RequestMapping(value = "/sabor", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public ResponseEntity<List<ViewRankingDTO>> viewRankingSabor() {
        List<RankingSabor> view = viewRankingService.viewRankingSabor();
        return new ResponseEntity<List<ViewRankingDTO>>(Lists.transform(view, viewRankingToViewRankingDTOFunction), HttpStatus.OK);
    }

    /**
     * View ranking localizacao.
     *
     * @return O(a)(s) response entity
     */
    @RequestMapping(value = "/localizacao", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public ResponseEntity<List<ViewRankingDTO>> viewRankingLocalizacao() {
        List<RankingLocalizacao> view = viewRankingService.viewRankingLocalizacao();
        return new ResponseEntity<List<ViewRankingDTO>>(Lists.transform(view, viewRankingToViewRankingDTOFunction), HttpStatus.OK);
    }

    /**
     * View ranking demora.
     *
     * @return O(a)(s) response entity
     */
    @RequestMapping(value = "/demora", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public ResponseEntity<List<ViewRankingDTO>> viewRankingDemora() {
        List<RankingDemora> view = viewRankingService.viewRankingDemora();
        return new ResponseEntity<List<ViewRankingDTO>>(Lists.transform(view, viewRankingToViewRankingDTOFunction), HttpStatus.OK);
    }

    /**
     * View ranking preco.
     *
     * @return O(a)(s) response entity
     */
    @RequestMapping(value = "/preco", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public ResponseEntity<List<ViewRankingDTO>> viewRankingPreco() {
        List<RankingPreco> view = viewRankingService.viewRankingPreco();
        return new ResponseEntity<List<ViewRankingDTO>>(Lists.transform(view, viewRankingToViewRankingDTOFunction), HttpStatus.OK);
    }

    /**
     * View ranking ranking atendimento.
     *
     * @return O(a)(s) response entity
     */
    @RequestMapping(value = "/atendimento", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public ResponseEntity<List<ViewRankingDTO>> viewRankingRankingAtendimento() {
        List<RankingAtendimento> view = viewRankingService.viewRankingRankingAtendimento();
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
        List<RankingCustoBeneficio> view = viewRankingService.viewRankingCustoBeneficio();
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
        List<RankingCustoBeneficioUsuario> view = viewRankingService.viewRankingCustoBeneficioUsuario(email);
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
