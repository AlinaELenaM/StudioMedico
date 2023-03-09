package co.develhope.studioMedico.controllers;

import co.develhope.studioMedico.entites.AppuntamentoEntity;
import co.develhope.studioMedico.entites.MedicoEntity;
import co.develhope.studioMedico.entites.PazienteEntity;
import co.develhope.studioMedico.repositories.MedicoRepository;
import co.develhope.studioMedico.services.AppuntamentoService;
import co.develhope.studioMedico.services.MedicoService;
import co.develhope.studioMedico.services.PazienteService;
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
    private PazienteService pazienteService;
    @Autowired
    private AppuntamentoService appuntamentoService;

    @GetMapping("/lista_medici")
    public List<MedicoEntity> listaMedici(){
        return medicoService.readAll();
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

    @GetMapping("leggi_appuntamento/{id}")
    public AppuntamentoEntity singoloApppuntamento(@PathVariable Long id) throws Exception {
        return appuntamentoService.readOne(id);
    }

    @DeleteMapping("/elimina_appuntamento/{id}")
    public String cancellaAppuntamentoById(@PathVariable Long id , HttpServletResponse response){
        return appuntamentoService.cancellaAppuntaemnto(id , response);
    }

}
