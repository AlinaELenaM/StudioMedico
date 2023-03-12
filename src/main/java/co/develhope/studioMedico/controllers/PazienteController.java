package co.develhope.studioMedico.controllers;

import co.develhope.studioMedico.entites.AppuntamentoEntity;
import co.develhope.studioMedico.entites.PazienteEntity;
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
    @GetMapping("/leggi_paziente/{id}")
    public PazienteEntity leggiPaziente(@PathVariable Long id) throws Exception {
        return pazienteService.visualizzaPaziente(id);
    }

    @GetMapping("leggi_appuntamento/{id}")
    public ResponseEntity<AppuntamentoEntity> cercaAppuntamentoPerId(@PathVariable Long id) {
        return appuntamentoService.cercaAppuntamentoPerId(id);
    }

}