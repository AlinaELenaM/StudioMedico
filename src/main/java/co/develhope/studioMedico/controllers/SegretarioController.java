package co.develhope.studioMedico.controllers;


import co.develhope.studioMedico.entites.AppuntamentoEntity;
import co.develhope.studioMedico.entites.MedicoEntity;
import co.develhope.studioMedico.entites.PazienteEntity;
import co.develhope.studioMedico.entites.SegretarioEntity;

import co.develhope.studioMedico.repositories.SegretarioRepository;
import co.develhope.studioMedico.services.AppuntamentoService;
import co.develhope.studioMedico.services.MedicoService;
import co.develhope.studioMedico.services.PazienteService;
import co.develhope.studioMedico.services.SegretarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/segretario")
public class SegretarioController {

    @Autowired
    private SegretarioService segretarioService;
    @Autowired
    private MedicoService medicoService;
    @Autowired
    private PazienteService pazienteService;
    @Autowired
    private AppuntamentoService appuntamentoService;

    //METODI PER IL MEDICO

    @PostMapping("/crea_medico")
    public ResponseEntity<String> creaNuovoMedico(@RequestBody MedicoEntity medicoEntity){
        medicoService.creaMedico(medicoEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body("Medico creato correttamente");
    }

    @GetMapping("leggi_medico/{id}")
    public MedicoEntity singoloMedico(@PathVariable Long id) throws Exception {
        return medicoService.readOne(id);
    }

    @GetMapping("/lista_medici")
    public List<MedicoEntity> listaMedici(){
        return medicoService.readAll();
    }

    @PutMapping("/modifica_medico/{id}")
    public ResponseEntity<String> modificaMedico(@RequestBody MedicoEntity medico, @PathVariable Long id) {
        medicoService.modficaMedico(medico, id);
        return ResponseEntity.status(200).body("Medico modificato correttamente");
    }

    @DeleteMapping("/elimina_medico/{id}")
    public String cancellaMedico(@PathVariable Long id , HttpServletResponse response){
        return medicoService.cancellaMedico(id , response);
    }

    @PutMapping("/riattiva_medico/{id}")
    public String riattivaMedico(@PathVariable Long id , HttpServletResponse response){
        return medicoService.riattivaMedico(id , response);
    }

    //METODI PER IL PAZIENTE

    @PostMapping("/crea_paziente")
    public ResponseEntity<String> creaPazente(@RequestBody PazienteEntity paziente){
        pazienteService.createPaziente(paziente);
        return ResponseEntity.status(HttpStatus.CREATED).body("Paziente creato correttamente");
    }

    /**
     * Restituisce il paziente tramite id.
     *
     * @param id  id
     * @return il paziente tramite id
     */
    @GetMapping("/leggi_paziente/{id}")
    public PazienteEntity leggiPaziente(@PathVariable Long id) throws Exception {
        return pazienteService.getPazienteById(id);
    }

    /**
     * Restituisce la lista dei pazienti.
     *
     * @return la list
     */
    @GetMapping({"/lista_pazienti"})
    public List<PazienteEntity> listaPazienti(){
        return pazienteService.tuttiPazienti();
    }

    /**
     * Update del paziente tramite id, restituisce una response entity di status 200.
     *
     * @param pazienteEdit la modifica al paziente
     * @param id            id
     * @return la response entity di status 200 la richiesta del client al server è stata completata con successo.
     */
    @PutMapping("/modifica_paziente/{id}")
    public ResponseEntity<String> modificaPazienteConId(@RequestBody PazienteEntity pazienteEdit, @PathVariable Long id) {
        pazienteService.modificaPaziente(pazienteEdit, id);
        return ResponseEntity.status(200).body("Paziente modificato correttamente");
    }

    @DeleteMapping("/elimina_paziente/{id}")
    public String cancellaPaziente(@PathVariable Long id , HttpServletResponse response){
        return pazienteService.cancellaPaziente(id , response);
    }

    @PutMapping("/riattiva_paziente/{id}")
    public String riattivaPaziente(@PathVariable Long id , HttpServletResponse response){
        return pazienteService.riattivaPaziente(id , response);
    }

    //METODI PER IL SEGRETARIO

    @PostMapping("/crea_segretario")
    public ResponseEntity<String> creaSegretario(@RequestBody SegretarioEntity segretarioEntity){
        segretarioService.creaSegretario(segretarioEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body("Segretario creato correttamente");
    }

    @GetMapping("leggi_segretario/{id}")
    public SegretarioEntity singoloSegretario(@PathVariable Long id) throws Exception {
        return segretarioService.readOne(id);
    }

    @GetMapping("/lista_segretari")
    public List<SegretarioEntity> listaSegretario(){
        return segretarioService.readAll();
    }

    @PutMapping("/modifica_segretario/{id}")
    public ResponseEntity<String> modificaMedico(@RequestBody SegretarioEntity segretario, @PathVariable Long id) {
        segretarioService.modificaSegretario(segretario, id);
        return ResponseEntity.status(200).body("Segretario modificato correttamente");
    }

    @DeleteMapping("/elimina_segretario/{id}")
    public String cancellaSegretarioById(@PathVariable Long id , HttpServletResponse response){
        return segretarioService.cancellaSegretario(id , response);
    }

    @PutMapping("/riattiva_segretario/{id}")
    public String riattivaSegretarioById(@PathVariable Long id , HttpServletResponse response){
        return segretarioService.riattivaSegretario(id , response);
    }

    //METODI APPUNTAMENTO

    @PostMapping("/crea_appuntamento")
    public ResponseEntity<String> creaAppuntamento(@RequestBody AppuntamentoEntity appuntamentoEntity){
        appuntamentoService.creaAppuntamento(appuntamentoEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body("Appuntamento creato correttamente");
    }

    @GetMapping("leggi_appuntamento/{id}")
    public AppuntamentoEntity singoloApppuntamento(@PathVariable Long id) throws Exception {
        return appuntamentoService.readOne(id);
    }

    @GetMapping("/lista_appuntamento")
    public List<AppuntamentoEntity> listaAppuntamento(){
        return appuntamentoService.readAll();
    }

    @PutMapping("/modifica_appuntamento/{id}")
    public ResponseEntity<String> modificaMedico(@RequestBody AppuntamentoEntity appuntamentoEntity, @PathVariable Long id) {
        appuntamentoService.modificaAppuntamento(appuntamentoEntity, id);
        return ResponseEntity.status(200).body("Appuntamento modificato correttamente");
    }

    @DeleteMapping("/elimina_appuntamento/{id}")
    public String cancellaAppuntamentoById(@PathVariable Long id , HttpServletResponse response){
        return appuntamentoService.cancellaAppuntaemnto(id , response);
    }

    @PutMapping("/riattiva_appuntamento/{id}")
    public String riattivaAppuntamentooById(@PathVariable Long id , HttpServletResponse response){
        return appuntamentoService.riattivaAppuntamento(id , response);
    }
}
