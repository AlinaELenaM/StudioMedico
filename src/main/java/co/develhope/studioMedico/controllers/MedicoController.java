package co.develhope.studioMedico.controllers;

import co.develhope.studioMedico.entites.Medico;
import co.develhope.studioMedico.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping("/create")
    public Medico createMedico(@RequestBody Medico medico){
        return medicoRepository.saveAndFlush(medico);
    }

    @GetMapping("/readAll")
    public List<Medico> getAll(){
        return medicoRepository.findAll();
    }

    @GetMapping("/readOne/{id}")
    public Medico getOne(@PathVariable long id){
        return medicoRepository.existsById(id) ? medicoRepository.getById(id) : new Medico();
    }

    @PutMapping("/update/{id}")
    public Medico medicoUpdate(@PathVariable long id , @RequestBody Medico medico){
        medico.setIdMedico(id);
        return medicoRepository.saveAndFlush(medico);
    }


    @DeleteMapping("/deleteOne/{id}")
    public void deleteOne(@PathVariable long id , HttpServletResponse response){
        if(medicoRepository.existsById(id)){
            medicoRepository.deleteById(id);
        }
        else
            response.setStatus(409);
    }


    @DeleteMapping("/deleteAll")
    public void deleteAll(){
        medicoRepository.deleteAll();
    }


}
