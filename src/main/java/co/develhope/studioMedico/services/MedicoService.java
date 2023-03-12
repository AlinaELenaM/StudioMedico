package co.develhope.studioMedico.services;

import co.develhope.studioMedico.entites.MedicoEntity;
import co.develhope.studioMedico.enums.StatusEnumeration;
import co.develhope.studioMedico.repositories.MedicoRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {
    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }


    public MedicoEntity creaMedico(MedicoEntity medicoEntity) {
        return medicoRepository.save(medicoEntity);
    }

    public MedicoEntity visualizzaMedico(Long id) throws RuntimeException {
        Optional<MedicoEntity> optionalMedicoEntity = medicoRepository.findById(id);
        if (optionalMedicoEntity.isEmpty()) {
            throw new RuntimeException("Questo medico non esiste nel database");
        }
        MedicoEntity medicoEntity = optionalMedicoEntity.get();
        if (medicoEntity.getStato() == StatusEnumeration.D)
            throw new RuntimeException("Errore: l'utente medico è disattivo!");
        if (!medicoRepository.existsById(id)) throw new EntityNotFoundException("Medico non trovato");
        return medicoEntity;
    }

    public List<MedicoEntity> visualizzaListaMedici() {
        return medicoRepository.findByStato(StatusEnumeration.A);
    }

    public MedicoEntity modficaMedico(MedicoEntity medicoEntity, Long id) {
        if (!medicoRepository.existsById(id)) {
            throw new EntityNotFoundException("Il Medico non esiste");
        }
        MedicoEntity medico = medicoRepository.findById(id).get();

        if (medicoEntity.getNome() != null) {
            medico.setNome(medicoEntity.getNome());
        }
        if (medicoEntity.getCognome() != null) {
            medico.setCognome(medicoEntity.getCognome());
        }
        if (medicoEntity.getEmail() != null) {
            medico.setEmail(medicoEntity.getEmail());
        }
        if (medicoEntity.getContattoTelefonico() != null) {
            medico.setContattoTelefonico(medicoEntity.getContattoTelefonico());
        }
        if (medicoEntity.getGiorniLavorativi() != null) {
            medico.setGiorniLavorativi(medicoEntity.getGiorniLavorativi());
        }
        if (medicoEntity.getSedeLavoro() != null) {
            medico.setSedeLavoro(medicoEntity.getSedeLavoro());
        }
        if (medicoEntity.getSpecializzazione() != null) {
            medico.setSpecializzazione(medicoEntity.getSpecializzazione());
        }
        return medicoRepository.save(medico);
    }

    public String cancellaMedico(Long id, HttpServletResponse response) {
        if (medicoRepository.existsById(id)) {
            MedicoEntity medicoEntity = medicoRepository.findById(id).get();
            medicoEntity.setStato(StatusEnumeration.D);
            medicoRepository.save(medicoEntity);
        } else {
            response.setStatus(409);
            return "Errore: l'id selezionato non esiste";
        }
        return "L'utente medico è stato disattivato";
    }

    public String riattivaMedico(Long id, HttpServletResponse response) {
        if (medicoRepository.existsById(id)) {
            MedicoEntity medicoEntity = medicoRepository.findById(id).get();
            medicoEntity.setStato(StatusEnumeration.A);
            medicoRepository.save(medicoEntity);
        } else {
            response.setStatus(409);
            return "Errore: l'id selezionato non esiste";
        }
        return "L'utente medico è stato attivato";
    }


}
