package co.develhope.studioMedico.controllers;


import co.develhope.studioMedico.entites.Segretario;

import co.develhope.studioMedico.repositories.SegretarioRepository;
import co.develhope.studioMedico.services.SegretarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/segretario")
public class SegretarioController {

    @Autowired
    private SegretarioRepository segretarioRepository;
    @Autowired
    private SegretarioService segretarioService;
    @PostMapping("/create")
    public Segretario createSegretario(@RequestBody Segretario segretario){
        return segretarioService.createSegretario(segretario);
    }

    @GetMapping("/read_all")
    public List<Segretario> getAll(){
        return segretarioService.getAll();
    }

    @GetMapping("/read_one/{id}")
    public Segretario getOne(@PathVariable long id){
        return segretarioService.getOne(id);
    }

    @PutMapping("/update/{id}")
    public Segretario segretarioUpdate(@PathVariable long id , @RequestBody Segretario segretario){
        return segretarioService.segretarioUpdate(id,segretario);
    }


    @DeleteMapping("/delete_one/{id}")
    public void deleteOne(@PathVariable long id ){
        segretarioService.deleteOne(id);
    }


    @DeleteMapping("/delete_all")
    public void deleteAll(){
        segretarioService.deleteAll();
    }


}
