package co.develhope.studioMedico.services;

import co.develhope.studioMedico.entites.SegretarioEntity;
import co.develhope.studioMedico.enums.StatusEnumeration;
import co.develhope.studioMedico.repositories.SegretarioRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class SegretarioService {
    private final SegretarioRepository segretarioRepository;

    public SegretarioService(SegretarioRepository segretarioRepository) {
        this.segretarioRepository = segretarioRepository;
    }


    public SegretarioEntity creaSegretario(SegretarioEntity segretarioEntity) {
        return segretarioRepository.save(segretarioEntity);
    }

    public SegretarioEntity visualizzaSegretario(Long id) throws Exception {
        if (segretarioRepository.findById(id) == null) {
            throw new Exception("Questo segretario non esiste nel database");
        }
        SegretarioEntity segretarioEntity = segretarioRepository.findById(id).get();
        if (segretarioEntity.getStato() == StatusEnumeration.D)
            throw new Exception("Errore: l'utente segretario è disattivo!");
        return segretarioEntity;
    }

    public List<SegretarioEntity> visualizzaListaSegretari() {
        return segretarioRepository.findByStato(StatusEnumeration.A);
    }

    public SegretarioEntity modificaSegretario(SegretarioEntity segretarioEntity, Long id) {
        if (!segretarioRepository.existsById(id)) {
            throw new EntityNotFoundException("Il Medico non esiste");
        }
        SegretarioEntity segretario = segretarioRepository.findById(id).get();

        if (segretarioEntity.getNome() != null) {
            segretario.setNome(segretarioEntity.getNome());
        }
        if (segretarioEntity.getCognome() != null) {
            segretario.setCognome(segretarioEntity.getCognome());
        }
        if (segretarioEntity.getEmail() != null) {
            segretario.setEmail(segretarioEntity.getEmail());
        }
        if (segretarioEntity.getContattoTelefonico() != null) {
            segretario.setContattoTelefonico(segretarioEntity.getContattoTelefonico());
        }
        if (segretarioEntity.getSedeLavoro() != null) {
            segretario.setSedeLavoro(segretarioEntity.getSedeLavoro());
        }
        return segretarioRepository.save(segretario);
    }

    public String cancellaSegretario(Long id, HttpServletResponse response) {
        if (segretarioRepository.existsById(id)) {
            SegretarioEntity segretarioEntity = segretarioRepository.findById(id).get();
            segretarioEntity.setStato(StatusEnumeration.D);
            segretarioRepository.save(segretarioEntity);
        } else {
            response.setStatus(409);
            return "Errore: l'id selezionato non esiste";
        }
        return "L'utente segretario è stato disattivato";
    }

    public String riattivaSegretario(Long id, HttpServletResponse response) {
        if (segretarioRepository.existsById(id)) {
            SegretarioEntity segretarioEntity = segretarioRepository.findById(id).get();
            segretarioEntity.setStato(StatusEnumeration.A);
            segretarioRepository.save(segretarioEntity);
        } else {
            response.setStatus(409);
            return "Errore: l'id selezionato non esiste";
        }
        return "L'utente segretario è stato attivato";
    }


}
