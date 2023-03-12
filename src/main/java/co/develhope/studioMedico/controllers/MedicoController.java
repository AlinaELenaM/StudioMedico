package co.develhope.studioMedico.controllers;

import co.develhope.studioMedico.entites.AppuntamentoEntity;
import co.develhope.studioMedico.entites.MedicoEntity;
import co.develhope.studioMedico.entites.PazienteEntity;
import co.develhope.studioMedico.services.AppuntamentoService;
import co.develhope.studioMedico.services.MedicoService;
import co.develhope.studioMedico.services.PazienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medico")
public class MedicoController {
    @Autowired
    private MedicoService medicoService;
    @Autowired
    private PazienteService pazienteService;
    @Autowired
    private AppuntamentoService appuntamentoService;


    /**
     * Restituisce il paziente tramite id.
     *
     * @param id id
     * @return il paziente tramite id
     */
    @GetMapping("/paziente/visualizza/{id}")
    public PazienteEntity leggiPaziente(@PathVariable Long id) throws Exception {
        return pazienteService.visualizzaPaziente(id);
    }

    @GetMapping("/medico/visualizza/{id}")
    public MedicoEntity singoloMedico(@PathVariable Long id) throws Exception {
        return medicoService.visualizzaMedico(id);
    }

    @GetMapping("/appuntamento/visualizza/{id}")
    public ResponseEntity<AppuntamentoEntity> cercaAppuntamentoPerId(@PathVariable Long id) throws Exception {
        return appuntamentoService.cercaAppuntamentoPerId(id);
    }

    @DeleteMapping("/appuntamento/cancella/{id}")
    public ResponseEntity<String> cancellaAppuntamentoById(@PathVariable Long id) {
        return appuntamentoService.cancellaAppuntamento(id);
    }

}
