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

    @GetMapping("/read_all")
    public List<Medico> getAll(){
        return medicoRepository.findAll();
    }

    @GetMapping("/read_one/{id}")
    public Medico getOne(@PathVariable long id){
        return medicoRepository.existsById(id) ? medicoRepository.getById(id) : new Medico();
    }

    @PutMapping("/update/{id}")
    public Medico medicoUpdate(@PathVariable long id , @RequestBody Medico medico){
        medico.setId(id);
        return medicoRepository.saveAndFlush(medico);
    }


    @DeleteMapping("/delete_one/{id}")
    public Medico deleteOne(@PathVariable long id , @RequestBody boolean attivo ,  HttpServletResponse response){
        if(medicoRepository.existsById(id)){
            medicoRepository.getById(id).setAttivo(attivo);
            return medicoRepository.saveAndFlush(medicoRepository.getById(id));
        }
        else
            response.setStatus(409);
        return null;
    }


    @DeleteMapping("/delete_all")
    public void deleteAll(){
        medicoRepository.deleteAll();
    }


}
