package co.develhope.studioMedico.controllers;
import co.develhope.studioMedico.entites.AppuntamentoEntity;
import co.develhope.studioMedico.entites.PazienteEntity;
import co.develhope.studioMedico.enums.StatusEnumeration;
import co.develhope.studioMedico.services.AppuntamentoService;
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
    @Autowired
    private AppuntamentoService appuntamentoService;

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

}