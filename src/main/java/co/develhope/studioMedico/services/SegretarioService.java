package co.develhope.studioMedico.services;

import co.develhope.studioMedico.entites.Segretario;
import co.develhope.studioMedico.repositories.SegretarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SegretarioService {
    @Autowired
    private SegretarioRepository segretarioRepository;

    public Segretario createSegretario(Segretario segretario){
        return segretarioRepository.saveAndFlush(segretario);
    }
    public List<Segretario> getAll(){
        return segretarioRepository.findAll();
    }


    public Segretario getOne(long id){
        return segretarioRepository.existsById(id) ? segretarioRepository.getById(id) : new Segretario();
    }
    public Segretario segretarioUpdate(long id ,Segretario segretario){
        segretario.setId(id);
        return segretarioRepository.saveAndFlush(segretario);
    }
    public void deleteOne(long id ){
        if(segretarioRepository.existsById(id)){
            segretarioRepository.getReferenceById(id);
        }
    }
    public void deleteAll(){

        for (Segretario segretario: segretarioRepository.findAll()){
        };
    }

}
