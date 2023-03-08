package co.develhope.studioMedico.controllers;
import co.develhope.studioMedico.entites.PazienteEntity;
import co.develhope.studioMedico.enums.StatusEnumeration;
import co.develhope.studioMedico.services.PazienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@RequestMapping("/paziente")
public class PazienteController {

    @Autowired
    private PazienteService pazienteService;

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
    public String delete(@PathVariable Long id , HttpServletResponse response){
        return pazienteService.cancellaPaziente(id , response);
    }

    @PutMapping("/riattiva_paziente/{id}")
    public String riattiva(@PathVariable Long id , HttpServletResponse response){
        return pazienteService.riattivaPaziente(id , response);
    }




}