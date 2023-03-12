package co.develhope.studioMedico.services;

import co.develhope.studioMedico.entites.AppuntamentoEntity;
import co.develhope.studioMedico.enums.StatusEnumeration;
import co.develhope.studioMedico.repositories.AppuntamentoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppuntamentoService {
    private final AppuntamentoRepository appuntamentoRepository;

    public AppuntamentoService(AppuntamentoRepository appuntamentoRepository) {
        this.appuntamentoRepository = appuntamentoRepository;
    }


    public AppuntamentoEntity creaAppuntamento(AppuntamentoEntity appuntamentoEntity) {
        return appuntamentoRepository.save(appuntamentoEntity);
    }

    public ResponseEntity<AppuntamentoEntity> cercaAppuntamentoPerId(Long id) throws RuntimeException {
        Optional<AppuntamentoEntity> appuntamentoOptional = appuntamentoRepository.findByIdAppuntamentoAndStato(id, StatusEnumeration.A);
        return appuntamentoOptional.map(appuntamentoEntity -> new ResponseEntity<>(appuntamentoEntity, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public List<AppuntamentoEntity> cercaTuttiAppuntamenti() {
        return appuntamentoRepository.findByStato(StatusEnumeration.A);
    }

    public ResponseEntity<AppuntamentoEntity> modificaAppuntamento(AppuntamentoEntity appuntamentoEntity, Long id) {
        Optional<AppuntamentoEntity> optionalAppuntamento = appuntamentoRepository.findByIdAppuntamentoAndStato(id, StatusEnumeration.A);

        return optionalAppuntamento.map(appuntamento -> {
            appuntamento.setOrarioAppuntamento(appuntamentoEntity.getOrarioAppuntamento());
            appuntamento.setNoteAppuntamento(appuntamentoEntity.getNoteAppuntamento());
            appuntamento.setStato(appuntamentoEntity.getStato());
            appuntamento.setStatoAppuntamento(appuntamentoEntity.getStatoAppuntamento());
            appuntamentoRepository.save(appuntamento);
            return new ResponseEntity<>(appuntamento, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<String> cancellaAppuntamento(Long id) {
        Optional<AppuntamentoEntity> optionalAppuntamento = appuntamentoRepository.findByIdAppuntamentoAndStato(id, StatusEnumeration.A);
        return optionalAppuntamento.map(appuntamento -> {
            appuntamento.setStato(StatusEnumeration.D);
            appuntamentoRepository.save(appuntamento);
            return new ResponseEntity<>("L'appuntamento è stato disattivato", HttpStatus.OK);
        }).orElse(new ResponseEntity<>("Errore: l'id selezionato non esiste", HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<String> riattivaAppuntamento(Long id) {
        Optional<AppuntamentoEntity> optionalAppuntamento = appuntamentoRepository.findByIdAppuntamentoAndStato(id, StatusEnumeration.D);
        return optionalAppuntamento.map(appuntamento -> {
            appuntamento.setStato(StatusEnumeration.A);
            appuntamentoRepository.save(appuntamento);
            return new ResponseEntity<>("L'appuntamento è stato attivato", HttpStatus.OK);
        }).orElse(new ResponseEntity<>("Errore: l'id selezionato non esiste", HttpStatus.NOT_FOUND));
    }
}
