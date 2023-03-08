package co.develhope.studioMedico.services;

import co.develhope.studioMedico.entites.MedicoEntity;
import co.develhope.studioMedico.entites.SegretarioEntity;
import co.develhope.studioMedico.enums.StatusEnumeration;
import co.develhope.studioMedico.repositories.SegretarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class SegretarioService {
    @Autowired
    private SegretarioRepository segretarioRepository;

    public SegretarioEntity creaSegretario(SegretarioEntity segretarioEntity){
        segretarioEntity.setStatus(StatusEnumeration.A);
        return segretarioRepository.saveAndFlush(segretarioEntity);
    }

    public SegretarioEntity readOne(Long id) throws Exception {
        SegretarioEntity segretarioEntity = segretarioRepository.getById(id);
        if (segretarioEntity.getStatus() == StatusEnumeration.D) throw new Exception("Errore: l'utente segretario è disattivo!");
        return segretarioEntity;
    }

    public List<SegretarioEntity> readAll(){
        return segretarioRepository.findByStatus(StatusEnumeration.A);
    }

    public SegretarioEntity modificaSegretario(Long id , SegretarioEntity medicoEntity){
        medicoEntity.setId(id);
        return segretarioRepository.saveAndFlush(medicoEntity);
    }


}
