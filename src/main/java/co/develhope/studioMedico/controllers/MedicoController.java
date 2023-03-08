package co.develhope.studioMedico.controllers;

import co.develhope.studioMedico.entites.MedicoEntity;
import co.develhope.studioMedico.entites.PazienteEntity;
import co.develhope.studioMedico.repositories.MedicoRepository;
import co.develhope.studioMedico.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medico")
public class MedicoController {
    @Autowired
    private MedicoService medicoService;
    @Autowired
    private MedicoRepository medicoRepository;

    //TODO : manca visualizzaSchedaPaziente, visualizzaAppuntamenti, cancellaAppuntamento


    @PostMapping("/crea")
    public ResponseEntity<String> crea(@RequestBody MedicoEntity medicoEntity){
        medicoService.creaMedico(medicoEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body("Medico creato correttamente");
    }

    @GetMapping("/{id}")
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
    public String cancella(@PathVariable Long id , HttpServletResponse response){
        return medicoService.cancellaMedico(id , response);
    }

    @PutMapping("/riattiva_medico/{id}")
    public String riattiva(@PathVariable Long id , HttpServletResponse response){
        return medicoService.riattivaMedico(id , response);
    }

}
