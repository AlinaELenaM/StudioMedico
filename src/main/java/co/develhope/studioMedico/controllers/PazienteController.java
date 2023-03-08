package co.develhope.studioMedico.controllers;
import co.develhope.studioMedico.entites.PazienteEntity;
import co.develhope.studioMedico.services.PazienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/paziente")
public class PazienteController {

    @Autowired
    private PazienteService pazienteService;

    @PostMapping("/create")
    public ResponseEntity<String> createPaziente(@RequestBody PazienteEntity paziente){
        pazienteService.createPaziente(paziente);
        return ResponseEntity.status(HttpStatus.CREATED).body("Paziente creato correttamente");
    }

    /**
     * Restituisce la lista dei pazienti.
     *
     * @return la list
     */
    @GetMapping({"/getAll"})
    public List<PazienteEntity> getPazienti(){

        return pazienteService.getPazienti();
    }

    /**
     * Restituisce il paziente tramite id.
     *
     * @param id  id
     * @return il paziente tramite id
     */
    @GetMapping("/{id}")
    public PazienteEntity getPazienteById(@PathVariable Long id) {
        return pazienteService.getPazienteById(id);
    }

    /**
     * Update del paziente tramite id, restituisce una response entity di status 200.
     *
     * @param pazienteEdit la modifica al paziente
     * @param id            id
     * @return la response entity di status 200 la richiesta del client al server è stata completata con successo.
     */
    @PutMapping("/edit/{id}")
    public ResponseEntity<String> updatePazienteById(@RequestBody PazienteEntity pazienteEdit, @PathVariable Long id) {
        pazienteService.updatePazienteById(pazienteEdit, id);
        return ResponseEntity.status(200).body("Paziente modificato correttamente");
    }
    //TODO soft delete (cancellazione logica)

}