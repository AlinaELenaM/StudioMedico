package co.develhope.studioMedico.services;

import co.develhope.studioMedico.entites.MedicoEntity;
import co.develhope.studioMedico.entites.SegretarioEntity;
import co.develhope.studioMedico.enums.StatusEnumeration;
import co.develhope.studioMedico.repositories.SegretarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
        if (segretarioRepository.getReferenceById(id) == null){
            throw new Exception("Questo segretario non esiste nel database");}
        SegretarioEntity segretarioEntity = segretarioRepository.getById(id);
        if (segretarioEntity.getStatus() == StatusEnumeration.D) throw new Exception("Errore: l'utente segretario è disattivo!");
        return segretarioEntity;
    }

    public List<SegretarioEntity> readAll(){
        return segretarioRepository.findByStatus(StatusEnumeration.A);
    }

    public SegretarioEntity modificaSegretario(SegretarioEntity segretarioEntity, Long id) {
        if(!segretarioRepository.existsById(id)) {
            throw new EntityNotFoundException("Il Medico non esiste");
        }
        SegretarioEntity segretario = segretarioRepository.findById(id).get();

        if(segretarioEntity.getNome() != null) {
            segretario.setNome(segretarioEntity.getNome());
        }
        if(segretarioEntity.getCognome() != null) {
            segretario.setCognome(segretarioEntity.getCognome());
        }
        if(segretarioEntity.getEmail() != null) {
            segretario.setEmail(segretarioEntity.getEmail());
        }
        if(segretarioEntity.getNumeroTelefonico() != null) {
            segretario.setNumeroTelefonico(segretarioEntity.getNumeroTelefonico());
        }
        if(segretarioEntity.getSedeDiLavoro() != null) {
            segretario.setSedeDiLavoro(segretarioEntity.getSedeDiLavoro());
        }
        return segretarioRepository.saveAndFlush(segretario);
    }

    public String cancellaSegretario(Long id , HttpServletResponse response){
        if(segretarioRepository.existsById(id)){
            SegretarioEntity segretarioEntity = segretarioRepository.getById(id);
            segretarioEntity.setStatus(StatusEnumeration.D);
            segretarioRepository.save(segretarioEntity);
        } else {
            response.setStatus(409);
            return "Errore: l'id selezionato non esiste";
        }
        return "L'utente segretario è stato disattivato";
    }

    public String riattivaSegretario(Long id , HttpServletResponse response){
        if(segretarioRepository.existsById(id)){
            SegretarioEntity segretarioEntity = segretarioRepository.getById(id);
            segretarioEntity.setStatus(StatusEnumeration.A);
            segretarioRepository.save(segretarioEntity);
        } else {
            response.setStatus(409);
            return "Errore: l'id selezionato non esiste";
        }
        return "L'utente segretario è stato attivato";
    }


}
