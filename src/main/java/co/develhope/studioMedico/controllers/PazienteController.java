package co.develhope.studioMedico.controllers;
import co.develhope.studioMedico.entites.Paziente;
import co.develhope.studioMedico.repositories.PazienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/paziente")
public class PazienteController {

    @Autowired
    private PazienteRepository pazienteRepository;

    @PostMapping("/create")
    public Paziente createPaziente(@RequestBody Paziente paziente){
        return pazienteRepository.saveAndFlush(paziente);
    }

    @GetMapping("/read_all")
    public List<Paziente> getAll(){
        return (List<Paziente>) pazienteRepository.findAll();
    }

    @GetMapping("/read_one/{id}")
    public Paziente getOne(@PathVariable long id){
        return pazienteRepository.existsById(id) ? pazienteRepository.getById(id) : new Paziente();
    }

    @PutMapping("/update/{id}")
    public Paziente pazienteUpdate(@PathVariable long id , @RequestBody Paziente paziente){
        paziente.setId(id);
        return pazienteRepository.saveAndFlush(paziente);
    }


    @DeleteMapping("/delete_one/{id}")
    public void deleteOne(@PathVariable long id , HttpServletResponse response){
        if(pazienteRepository.existsById(id)){
            pazienteRepository.deleteById(id);
        }
        else
            response.setStatus(409);
    }


    @DeleteMapping("/delete_all")
    public void deleteAll(){
        pazienteRepository.deleteAll();
    }


}