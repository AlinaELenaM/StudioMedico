package co.develhope.studioMedico.controllers;


import co.develhope.studioMedico.entites.AppuntamentoEntity;
import co.develhope.studioMedico.entites.MedicoEntity;
import co.develhope.studioMedico.entites.PazienteEntity;
import co.develhope.studioMedico.entites.SegretarioEntity;
import co.develhope.studioMedico.services.AppuntamentoService;
import co.develhope.studioMedico.services.MedicoService;
import co.develhope.studioMedico.services.PazienteService;
import co.develhope.studioMedico.services.SegretarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/segretario")
public class SegretarioController {

    private final SegretarioService segretarioService;
    private final MedicoService medicoService;
    private final PazienteService pazienteService;
    private final AppuntamentoService appuntamentoService;

    public SegretarioController(SegretarioService segretarioService, MedicoService medicoService, PazienteService pazienteService, AppuntamentoService appuntamentoService) {
        this.segretarioService = segretarioService;
        this.medicoService = medicoService;
        this.pazienteService = pazienteService;
        this.appuntamentoService = appuntamentoService;
    }
//TODO refactoring dei nomi metodi piu' parlanti
    //METODI PER IL MEDICO

    @PostMapping("/crea_medico")
    public ResponseEntity<String> creaNuovoMedico(@RequestBody MedicoEntity medicoEntity) {
        // medicoService.creaMedico(medicoEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body("Medico creato correttamente");
    }

    @GetMapping("leggi_medico/{id}")
    public MedicoEntity singoloMedico(@PathVariable Long id) throws RuntimeException {
        return medicoService.visualizzaMedico(id);
    }

    @GetMapping("/lista_medici")
    public List<MedicoEntity> listaMedici() {
        return medicoService.visualizzaListaMedici();
    }

    @PutMapping("/modifica_medico/{id}")
    public ResponseEntity<String> modificaMedico(@RequestBody MedicoEntity medico, @PathVariable Long id) {
        // medicoService.modficaMedico(medico, id);
        return ResponseEntity.status(200).body("Medico modificato correttamente");
    }

    @DeleteMapping("/elimina_medico/{id}")
    public String cancellaMedico(@PathVariable Long id, HttpServletResponse response) {
        return medicoService.cancellaMedico(id, response);
    }

    @PutMapping("/riattiva_medico/{id}")
    public String riattivaMedico(@PathVariable Long id, HttpServletResponse response) {
        return medicoService.riattivaMedico(id, response);
    }

    //METODI PER IL PAZIENTE

    @PostMapping("/crea_paziente")
    public ResponseEntity<String> creaPazente(@RequestBody PazienteEntity paziente) {
        pazienteService.creaPaziente(paziente);
        return ResponseEntity.status(HttpStatus.CREATED).body("Paziente creato correttamente");
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

    /**
     * Restituisce la lista dei pazienti.
     *
     * @return la list
     */
    @GetMapping({"/lista_pazienti"})
    public List<PazienteEntity> listaPazienti() {
        return pazienteService.visualizzaListaPazienti();
    }

    /**
     * Update del paziente tramite id, restituisce una response entity di status 200.
     *
     * @param pazienteEdit la modifica al paziente
     * @param id           id
     * @return la response entity di status 200 la richiesta del client al server è stata completata con successo.
     */
    @PutMapping("/modifica_paziente/{id}")
    public ResponseEntity<String> modificaPazienteConId(@RequestBody PazienteEntity pazienteEdit, @PathVariable Long id) {
        pazienteService.modificaPaziente(pazienteEdit, id);
        return ResponseEntity.status(200).body("Paziente modificato correttamente");
    }

    @DeleteMapping("/elimina_paziente/{id}")
    public String cancellaPaziente(@PathVariable Long id, HttpServletResponse response) {
        return pazienteService.cancellaPaziente(id, response);
    }

    @PutMapping("/riattiva_paziente/{id}")
    public String riattivaPaziente(@PathVariable Long id, HttpServletResponse response) {
        return pazienteService.riattivaPaziente(id, response);
    }

    //METODI PER IL SEGRETARIO

    @PostMapping("/crea_segretario")
    public ResponseEntity<String> creaSegretario(@RequestBody SegretarioEntity segretarioEntity) {
        segretarioService.creaSegretario(segretarioEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body("Segretario creato correttamente");
    }

    @GetMapping("leggi_segretario/{id}")
    public SegretarioEntity singoloSegretario(@PathVariable Long id) throws Exception {
        return segretarioService.visualizzaSegretario(id);
    }

    @GetMapping("/lista_segretari")
    public List<SegretarioEntity> listaSegretario() {
        return segretarioService.visualizzaListaSegretari();
    }

    @PutMapping("/modifica_segretario/{id}")
    public ResponseEntity<String> modificaMedico(@RequestBody SegretarioEntity segretario, @PathVariable Long id) {
        segretarioService.modificaSegretario(segretario, id);
        return ResponseEntity.status(200).body("Segretario modificato correttamente");
    }

    @DeleteMapping("/elimina_segretario/{id}")
    public String cancellaSegretarioById(@PathVariable Long id, HttpServletResponse response) {
        return segretarioService.cancellaSegretario(id, response);
    }

    @PutMapping("/riattiva_segretario/{id}")
    public String riattivaSegretarioById(@PathVariable Long id, HttpServletResponse response) {
        return segretarioService.riattivaSegretario(id, response);
    }

    //METODI APPUNTAMENTO

    @PostMapping("/appuntamento/crea")
    public ResponseEntity<String> creaAppuntamento(@RequestBody AppuntamentoEntity appuntamentoEntity) {
        appuntamentoService.creaAppuntamento(appuntamentoEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body("Appuntamento creato correttamente!");
    }

    //TODO aggiungere validazione body richiesta in creazione e modifica appuntamento(vale per tutte le entity)
    @GetMapping("/appuntamento/cerca/{id}")
    public ResponseEntity<AppuntamentoEntity> cercaAppuntamentoPerId(@PathVariable Long id) throws Exception {
        return appuntamentoService.cercaAppuntamentoPerId(id);
    }

    @GetMapping("/appuntamento/cerca/tutti")
    public List<AppuntamentoEntity> cercaTuttiAppuntamenti() {
        return appuntamentoService.cercaTuttiAppuntamenti();
    }

    @PutMapping("/appuntamento/modifica/{id}")
    public ResponseEntity<String> modificaAppuntamento(@RequestBody AppuntamentoEntity appuntamentoEntity, @PathVariable Long id) {
        appuntamentoService.modificaAppuntamento(appuntamentoEntity, id);
        return ResponseEntity.status(200).body("Appuntamento modificato correttamente!");
    }

    @DeleteMapping("/appuntamento/cancella/{id}")
    public ResponseEntity<String> cancellaAppuntamentoById(@PathVariable Long id) {
        return appuntamentoService.cancellaAppuntamento(id);
    }

    @PutMapping("/appuntamento/riattiva/{id}")
    public ResponseEntity<String> riattivaAppuntamentoById(@PathVariable Long id) {
        return appuntamentoService.riattivaAppuntamento(id);
    }
}
