package co.develhope.studioMedico.services;

import co.develhope.studioMedico.dto.request.PazienteRequestDto;
import co.develhope.studioMedico.dto.response.appuntamento.AppuntamentoMinimalNoPazienteResponseDto;
import co.develhope.studioMedico.dto.response.medico.MedicoMinimalResponseDto;
import co.develhope.studioMedico.dto.response.paziente.PazienteMinimalResponseDto;
import co.develhope.studioMedico.dto.response.paziente.PazienteNoMedicoResponseDto;
import co.develhope.studioMedico.dto.response.paziente.PazienteResponseDto;
import co.develhope.studioMedico.entites.MedicoEntity;
import co.develhope.studioMedico.entites.PazienteEntity;
import co.develhope.studioMedico.enums.StatusEnumeration;
import co.develhope.studioMedico.repositories.MedicoRepository;
import co.develhope.studioMedico.repositories.PazienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * La classe PazienteService realizza la logica di business relativamente le operazioni di CRUD dei dati di PazienteEntity.
 * Utilizza PazienteRepository (mediante dependency injection), i metodi del service verranno richiamati
 * nel relativo controller PazienteController
 */
@Service
public class PazienteService {
    private final PazienteRepository pazienteRepository;
    private final MedicoRepository medicoRepository;

    public PazienteService(PazienteRepository pazienteRepository, MedicoRepository medicoRepository) {
        this.pazienteRepository = pazienteRepository;
        this.medicoRepository = medicoRepository;
    }


    public PazienteEntity creaPaziente(PazienteRequestDto pazienteRequestDto) throws RuntimeException {
        PazienteEntity pazienteEntity = new PazienteEntity(
                pazienteRequestDto.getNome(),
                pazienteRequestDto.getCognome(),
                pazienteRequestDto.getEmail(),
                pazienteRequestDto.getContattoTelefonico(),
                pazienteRequestDto.getCodiceFiscale(),
                pazienteRequestDto.getIndirizzo(),
                pazienteRequestDto.getAllergie(),
                pazienteRequestDto.getStoricoMalattie(),
                "Gruppo 5"
        );
        pazienteEntity.setListaMedici(pazienteRequestDto
                                              .getListaIdMedici().stream()
                                              .map(medicoId -> medicoRepository.findByIdAndStato(medicoId,
                                                                                                 StatusEnumeration.A)
                                                                               .orElseThrow(() -> new RuntimeException(
                                                                                       "Medico con id " + medicoId + " non presente nel DB")))
                                              .collect(Collectors.toList()));

        return pazienteRepository.save(pazienteEntity);
    }


    public ResponseEntity<PazienteResponseDto> ricercaPaziente(Long id) {
        Optional<PazienteEntity> optionalPaziente = pazienteRepository.findByIdAndStato(id, StatusEnumeration.A);
        return optionalPaziente.map(paziente -> new ResponseEntity<>(
                                       new PazienteResponseDto(
                                               paziente.getId(),
                                               paziente.getNome(),
                                               paziente.getCognome(),
                                               paziente.getEmail(),
                                               paziente.getContattoTelefonico(),
                                               paziente.getCodiceFiscale(),
                                               paziente.getIndirizzo(),
                                               paziente.getAllergie(),
                                               paziente.getStoricoMalattie(),
                                               paziente.getListaAppuntamenti().stream().map(
                                                       appuntamento -> new AppuntamentoMinimalNoPazienteResponseDto(
                                                               appuntamento.getId(),
                                                               appuntamento.getOrarioAppuntamento(),
                                                               new MedicoMinimalResponseDto(
                                                                       appuntamento.getMedico().getId(),
                                                                       appuntamento.getMedico().getNome(),
                                                                       appuntamento.getMedico().getCognome()
                                                               )
                                                       )
                                                                                           ).collect(Collectors.toList()),
                                               paziente.getListaMedici().stream().map(
                                                       medico -> new MedicoMinimalResponseDto(
                                                               medico.getId(),
                                                               medico.getNome(),
                                                               medico.getCognome()
                                                       )
                                                                                     ).collect(Collectors.toList())

                                       )
                                       , HttpStatus.OK))
                               .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<PazienteNoMedicoResponseDto> ricercaPazientePerMedico(Long idPaziente, Long idMedico) {
        Optional<MedicoEntity> optionalMedico = medicoRepository.findByIdAndStato(idMedico, StatusEnumeration.A);
        return optionalMedico.map(medico -> medico.getListaPazienti().stream()
                                                  .filter(pazienteEntities -> Objects.equals(pazienteEntities.getId(),
                                                                                             idPaziente))
                                                  .findFirst()
                                                  .map(paziente -> new ResponseEntity<>(
                                                          new PazienteNoMedicoResponseDto(
                                                                  paziente.getId(),
                                                                  paziente.getNome(),
                                                                  paziente.getCognome(),
                                                                  paziente.getEmail(),
                                                                  paziente.getContattoTelefonico(),
                                                                  paziente.getCodiceFiscale(),
                                                                  paziente.getIndirizzo(),
                                                                  paziente.getAllergie(),
                                                                  paziente.getStoricoMalattie(),
                                                                  paziente.getListaAppuntamenti().stream().map(
                                                                          appuntamento -> new AppuntamentoMinimalNoPazienteResponseDto(
                                                                                  appuntamento.getId(),
                                                                                  appuntamento.getOrarioAppuntamento(),
                                                                                  new MedicoMinimalResponseDto(
                                                                                          appuntamento.getMedico()
                                                                                                      .getId(),
                                                                                          appuntamento.getMedico()
                                                                                                      .getNome(),
                                                                                          appuntamento.getMedico()
                                                                                                      .getCognome()
                                                                                  )
                                                                          )).collect(Collectors.toList())
                                                          ), HttpStatus.OK))
                                                  .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND))
                                 ).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    public List<PazienteMinimalResponseDto> ricercaTuttiPazienti() {
        return pazienteRepository.findByStato(StatusEnumeration.A)
                                 .stream()
                                 .map(paziente -> new PazienteMinimalResponseDto(paziente.getId(),
                                                                                 paziente.getNome(),
                                                                                 paziente.getCognome()))
                                 .collect(Collectors.toList());

    }


    public ResponseEntity<PazienteEntity> modificaPaziente(PazienteRequestDto pazienteRequestDto, Long id) {
        Optional<PazienteEntity> optionalPaziente = pazienteRepository.findByIdAndStato(id, StatusEnumeration.A);
        return optionalPaziente.map(paziente -> {
            paziente.setNome(pazienteRequestDto.getNome());
            paziente.setCognome(pazienteRequestDto.getCognome());
            paziente.setEmail(pazienteRequestDto.getEmail());
            paziente.setContattoTelefonico(pazienteRequestDto.getContattoTelefonico());
            paziente.setCodiceFiscale(pazienteRequestDto.getCodiceFiscale());
            paziente.setIndirizzo(pazienteRequestDto.getIndirizzo());
            paziente.setAllergie(pazienteRequestDto.getAllergie());
            paziente.setStoricoMalattie(pazienteRequestDto.getStoricoMalattie());

            paziente.setDataUltimaModifica(new Date(System.currentTimeMillis()));
            paziente.setUltimaModificaDa("Gruppo 5");

            pazienteRepository.save(paziente);
            return new ResponseEntity<>(paziente, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    public ResponseEntity<String> disattivaPaziente(Long id) {
        Optional<PazienteEntity> optionalPaziente = pazienteRepository.findByIdAndStato(id, StatusEnumeration.A);
        return optionalPaziente.map(paziente -> {
            paziente.setStato(StatusEnumeration.D);
            pazienteRepository.save(paziente);
            return new ResponseEntity<>("Il paziente è stato disattivato", HttpStatus.OK);
        }).orElse(new ResponseEntity<>("Errore: l'id selezionato non esiste", HttpStatus.NOT_FOUND));

    }

    public ResponseEntity<String> riattivaPaziente(Long id) {
        Optional<PazienteEntity> optionalPaziente = pazienteRepository.findByIdAndStato(id, StatusEnumeration.D);
        return optionalPaziente.map(paziente -> {
                                   paziente.setStato(StatusEnumeration.A);
                                   pazienteRepository.save(paziente);
                                   return new ResponseEntity<>("Il paziente è stato riattivato", HttpStatus.OK);
                               })
                               .orElse(new ResponseEntity<>("Errore: l'id selezionato non esiste o non e' disattivato",
                                                            HttpStatus.NOT_FOUND));

    }

}
