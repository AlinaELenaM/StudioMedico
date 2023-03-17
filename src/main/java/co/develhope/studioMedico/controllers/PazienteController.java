package co.develhope.studioMedico.controllers;

import co.develhope.studioMedico.dto.response.appuntamento.AppuntamentoNoPazienteResponseDto;
import co.develhope.studioMedico.dto.response.paziente.PazienteResponseDto;
import co.develhope.studioMedico.services.AppuntamentoService;
import co.develhope.studioMedico.services.PazienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paziente")
public class PazienteController {

    private final PazienteService pazienteService;
    private final AppuntamentoService appuntamentoService;

    public PazienteController(PazienteService pazienteService, AppuntamentoService appuntamentoService) {
        this.pazienteService = pazienteService;
        this.appuntamentoService = appuntamentoService;
    }

    /**
     * Restituisce il paziente tramite id.
     *
     * @param id id
     * @return il paziente tramite id
     */
    @GetMapping("/paziente_ricerca/{id}")
    public ResponseEntity<PazienteResponseDto> ricercaPaziente(@PathVariable Long id) {
        return pazienteService.ricercaPaziente(id);
    }

    @GetMapping("/{idPaziente}/appuntamento_ricerca/{idAppuntamento}")
    public ResponseEntity<AppuntamentoNoPazienteResponseDto> ricercaAppuntamentoPerPaziente(@PathVariable Long idAppuntamento, @PathVariable Long idPaziente) {
        return appuntamentoService.ricercaAppuntamentoPerPaziente(idAppuntamento, idPaziente);
    }

}