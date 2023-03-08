package co.develhope.studioMedico.services;

import co.develhope.studioMedico.entites.MedicoEntity;
import co.develhope.studioMedico.enums.StatusEnumeration;
import co.develhope.studioMedico.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public MedicoEntity creaMedico(MedicoEntity medicoEntity){
        medicoEntity.setStatus(StatusEnumeration.A);
        return medicoRepository.saveAndFlush(medicoEntity);
    }

    public MedicoEntity readOne(Long id) throws Exception {
        MedicoEntity medicoEntity = medicoRepository.getById(id);
        if (medicoEntity.getStatus() == StatusEnumeration.D) throw new Exception("Errore: l'utente medico è disattivo!");
        return medicoEntity;
    }

    public List<MedicoEntity> readAll(){
       return medicoRepository.findByStatus(StatusEnumeration.A);
    }

    public MedicoEntity modificaMedico(Long id , MedicoEntity medicoEntity){
        medicoEntity.setId(id);
        return medicoRepository.saveAndFlush(medicoEntity);
    }

    public String cancellaMedico(Long id , HttpServletResponse response){
        if(medicoRepository.existsById(id)){
                MedicoEntity medicoEntity = medicoRepository.getById(id);
                medicoEntity.setStatus(StatusEnumeration.D);
                medicoRepository.save(medicoEntity);
            } else {
            response.setStatus(409);
            return "Errore: l'id selezionato non esiste";
        }
        return "L'utente medico è stato disattivato";
    }

    public String riattivaMedico(Long id , HttpServletResponse response){
        if(medicoRepository.existsById(id)){
            MedicoEntity medicoEntity = medicoRepository.getById(id);
            medicoEntity.setStatus(StatusEnumeration.A);
            medicoRepository.save(medicoEntity);
        } else {
            response.setStatus(409);
            return "Errore: l'id selezionato non esiste";
        }
        return "L'utente medico è stato attivato";
    }


}
