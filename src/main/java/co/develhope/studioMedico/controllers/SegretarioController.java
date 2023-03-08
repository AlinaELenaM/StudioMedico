package co.develhope.studioMedico.controllers;


import co.develhope.studioMedico.entites.SegretarioEntity;

import co.develhope.studioMedico.repositories.SegretarioRepository;
import co.develhope.studioMedico.services.SegretarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/segretario")
public class SegretarioController {
    /**
     *

    @Autowired
    private SegretarioRepository segretarioRepository;
    @Autowired
    private SegretarioService segretarioService;
    @PostMapping("/create")
    public SegretarioEntity createSegretario(@RequestBody SegretarioEntity segretarioEntity){
        return segretarioService.createSegretario(segretarioEntity);
    }

    @GetMapping("/read_all")
    public List<SegretarioEntity> getAll(){
        return segretarioService.getAll();
    }

    @GetMapping("/read_one/{id}")
    public SegretarioEntity getOne(@PathVariable long id){
        return segretarioService.getOne(id);
    }

    @PutMapping("/update/{id}")
    public SegretarioEntity segretarioUpdate(@PathVariable long id , @RequestBody SegretarioEntity segretarioEntity){
        return segretarioService.segretarioUpdate(id, segretarioEntity);
    }


    @DeleteMapping("/delete_one/{id}")
    public void deleteOne(@PathVariable long id ){
        segretarioService.deleteOne(id);
    }


    @DeleteMapping("/delete_all")
    public void deleteAll(){
        segretarioService.deleteAll();
    }

     */
}
