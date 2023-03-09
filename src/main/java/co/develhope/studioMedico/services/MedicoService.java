package co.develhope.studioMedico.services;

import co.develhope.studioMedico.entites.MedicoEntity;
import co.develhope.studioMedico.entites.PazienteEntity;
import co.develhope.studioMedico.enums.StatusEnumeration;
import co.develhope.studioMedico.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
        if (medicoRepository.getReferenceById(id) == null){
            throw new Exception("Questo medico non esiste nel database");}
        MedicoEntity medicoEntity = medicoRepository.getById(id);
        if(medicoEntity.getStatus() == StatusEnumeration.D) throw new Exception("Errore: l'utente medico è disattivo!");
        if(!medicoRepository.existsById(id)) throw new EntityNotFoundException("Medico non trovato");
        return medicoEntity;
    }

    public List<MedicoEntity> readAll(){
       return medicoRepository.findByStatus(StatusEnumeration.A);
    }

    public MedicoEntity modficaMedico(MedicoEntity medicoEntity, Long id) {
        if(!medicoRepository.existsById(id)) {
            throw new EntityNotFoundException("Il Medico non esiste");
        }
        MedicoEntity medico = medicoRepository.findById(id).get();

        if(medicoEntity.getNome() != null) {
            medico.setNome(medicoEntity.getNome());
        }
        if(medicoEntity.getCognome() != null) {
            medico.setCognome(medicoEntity.getCognome());
        }
        if(medicoEntity.getEmail() != null) {
            medico.setEmail(medicoEntity.getEmail());
        }
        if(medicoEntity.getNumeroTelefonico() != null) {
            medico.setNumeroTelefonico(medicoEntity.getNumeroTelefonico());
        }
        if(medicoEntity.getGiorniLavorativi() != null) {
            medico.setGiorniLavorativi(medicoEntity.getGiorniLavorativi());
        }
        if(medicoEntity.getSedeDiLavoro() != null) {
            medico.setSedeDiLavoro(medicoEntity.getSedeDiLavoro());
        }
        if(medicoEntity.getSpecializzazione() != null) {
            medico.setSpecializzazione(medicoEntity.getSpecializzazione());
        }
        return medicoRepository.saveAndFlush(medico);
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
