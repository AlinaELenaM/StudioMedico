package co.develhope.studioMedico.controllers;


import co.develhope.studioMedico.entites.Segretario;

import co.develhope.studioMedico.repositories.SegretarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/segretario")
public class SegretarioController {

    @Autowired
    private SegretarioRepository segretarioRepository;

    @PostMapping("/create")
    public Segretario createSegretario(@RequestBody Segretario segretario){
        return segretarioRepository.saveAndFlush(segretario);
    }

    @GetMapping("/readAll")
    public List<Segretario> getAll(){
        return segretarioRepository.findAll();
    }

    @GetMapping("/readOne/{id}")
    public Segretario getOne(@PathVariable long id){
        return segretarioRepository.existsById(id) ? segretarioRepository.getById(id) : new Segretario();
    }

    @PutMapping("/update/{id}")
    public Segretario segretarioUpdate(@PathVariable long id , @RequestBody Segretario segretario){
        segretario.setId(id);
        return segretarioRepository.saveAndFlush(segretario);
    }


    @DeleteMapping("/deleteOne/{id}")
    public void deleteOne(@PathVariable long id , HttpServletResponse response){
        if(segretarioRepository.existsById(id)){
            segretarioRepository.deleteById(id);
        }
        else
            response.setStatus(409);
    }


    @DeleteMapping("/deleteAll")
    public void deleteAll(){
        segretarioRepository.deleteAll();
    }


}
