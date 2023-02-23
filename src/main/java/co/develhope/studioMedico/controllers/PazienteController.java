package co.develhope.studioMedico.controllers;
import co.develhope.studioMedico.repositories.PazienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/segretario")
public class PazienteController<Paziente> {

    @Autowired
    private PazienteRepository pazienteRepository;

    @PostMapping("/create")
    public Paziente createPaziente(@RequestBody Paziente paziente){
        return PazienteRepository.saveAndFlush(paziente);
    }

    @GetMapping("/readAll")
    public List<Paziente> getAll(){
        return (List<Paziente>) pazienteRepository.findAll();
    }

    @GetMapping("/readOne/{id}")
    public Paziente getOne(@PathVariable long id){
        return pazienteRepository.existsById(id) ? pazienteRepository.getById(id) : new Paziente();
    }

    @PutMapping("/update/{id}")
    public Paziente pazienteUpdate(@PathVariable long id , @RequestBody Paziente paziente){
        paziente.setId(id);
        return PazienteRepository.saveAndFlush(paziente);
    }


    @DeleteMapping("/deleteOne/{id}")
    public void deleteOne(@PathVariable long id , HttpServletResponse response){
        if(pazienteRepository.existsById(id)){
            pazienteRepository.deleteById(id);
        }
        else
            response.setStatus(409);
    }


    @DeleteMapping("/deleteAll")
    public void deleteAll(){
        pazienteRepository.deleteAll();
    }


}