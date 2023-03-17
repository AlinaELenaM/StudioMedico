package co.develhope.studioMedico.services;

import co.develhope.studioMedico.dto.request.AppuntamentoRequestDto;
import co.develhope.studioMedico.dto.response.appuntamento.AppuntamentoMinimalResponseDto;
import co.develhope.studioMedico.dto.response.appuntamento.AppuntamentoNoMedicoResponseDto;
import co.develhope.studioMedico.dto.response.appuntamento.AppuntamentoNoPazienteResponseDto;
import co.develhope.studioMedico.dto.response.appuntamento.AppuntamentoResponseDto;
import co.develhope.studioMedico.dto.response.medico.MedicoMinimalResponseDto;
import co.develhope.studioMedico.dto.response.paziente.PazienteMinimalResponseDto;
import co.develhope.studioMedico.entites.AppuntamentoEntity;
import co.develhope.studioMedico.enums.StatoAppuntamentoEnum;
import co.develhope.studioMedico.enums.StatusEnumeration;
import co.develhope.studioMedico.repositories.AppuntamentoRepository;
import co.develhope.studioMedico.repositories.MedicoRepository;
import co.develhope.studioMedico.repositories.PazienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppuntamentoService {
    private final AppuntamentoRepository appuntamentoRepository;
    private final PazienteRepository pazienteRepository;
    private final MedicoRepository medicoRepository;

    public AppuntamentoService(AppuntamentoRepository appuntamentoRepository, PazienteRepository pazienteRepository, MedicoRepository medicoRepository) {
        this.appuntamentoRepository = appuntamentoRepository;
        this.pazienteRepository = pazienteRepository;
        this.medicoRepository = medicoRepository;
    }


    public AppuntamentoEntity creaAppuntamento(AppuntamentoRequestDto appuntamentoRequestDto) throws RuntimeException {

        AppuntamentoEntity appuntamentoEntity = new AppuntamentoEntity(
                appuntamentoRequestDto.getOrarioAppuntamento(),
                appuntamentoRequestDto.getNoteAppuntamento(),
                pazienteRepository.findByIdAndStato(appuntamentoRequestDto.getIdPaziente(), StatusEnumeration.A)
                                  .orElseThrow(() -> new RuntimeException("Paziente non trovato!")),
                medicoRepository.findByIdAndStato(appuntamentoRequestDto.getIdMedico(), StatusEnumeration.A)
                                .orElseThrow(() -> new RuntimeException("Medico non trovato!")),
                "Gruppo 5"
        );
        return appuntamentoRepository.save(appuntamentoEntity);
    }

    public ResponseEntity<AppuntamentoResponseDto> ricercaAppuntamento(Long id) {
        Optional<AppuntamentoEntity> appuntamentoOptional = appuntamentoRepository.findByIdAndStato(id,
                                                                                                    StatusEnumeration.A);
        return appuntamentoOptional.map(appuntamento -> new ResponseEntity<>(new AppuntamentoResponseDto(
                                           appuntamento.getId(),
                                           appuntamento.getOrarioAppuntamento(),
                                           appuntamento.getNoteAppuntamento(),
                                           new PazienteMinimalResponseDto(
                                                   appuntamento.getPaziente()
                                                               .getId(),
                                                   appuntamento.getPaziente()
                                                               .getNome(),
                                                   appuntamento.getPaziente()
                                                               .getCognome()
                                           ),
                                           new MedicoMinimalResponseDto(
                                                   appuntamento.getMedico()
                                                               .getId(),
                                                   appuntamento.getMedico()
                                                               .getNome(),
                                                   appuntamento.getMedico()
                                                               .getCognome()

                                           )), HttpStatus.OK))
                                   .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<AppuntamentoNoPazienteResponseDto> ricercaAppuntamentoPerPaziente(Long idAppuntamento, Long idPaziente) {
        Optional<AppuntamentoEntity> appuntamentoOptional = appuntamentoRepository.findByIdAndStatoAndPaziente_Id(
                idAppuntamento,
                StatusEnumeration.A,
                idPaziente);
        return appuntamentoOptional.map(appuntamento -> new ResponseEntity<>(new AppuntamentoNoPazienteResponseDto(
                                           appuntamento.getId(),
                                           appuntamento.getOrarioAppuntamento(),
                                           appuntamento.getNoteAppuntamento(),
                                           new MedicoMinimalResponseDto(
                                                   appuntamento.getMedico()
                                                               .getId(),
                                                   appuntamento.getMedico()
                                                               .getNome(),
                                                   appuntamento.getMedico()
                                                               .getCognome()
                                           )), HttpStatus.OK))
                                   .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<AppuntamentoNoMedicoResponseDto> ricercaAppuntamentoPerMedico(Long idAppuntamento, Long idMedico) {
        Optional<AppuntamentoEntity> appuntamentoOptional = appuntamentoRepository.findByIdAndStatoAndMedico_Id(
                idAppuntamento,
                StatusEnumeration.A,
                idMedico);
        return appuntamentoOptional.map(appuntamento -> new ResponseEntity<>(new AppuntamentoNoMedicoResponseDto(
                                           appuntamento.getId(),
                                           appuntamento.getOrarioAppuntamento(),
                                           appuntamento.getNoteAppuntamento(),
                                           new PazienteMinimalResponseDto(
                                                   appuntamento.getPaziente()
                                                               .getId(),
                                                   appuntamento.getPaziente()
                                                               .getNome(),
                                                   appuntamento.getPaziente()
                                                               .getCognome()
                                           )), HttpStatus.OK))
                                   .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public List<AppuntamentoMinimalResponseDto> ricercaTuttiAppuntamentiPerStato(StatoAppuntamentoEnum statoAppuntamentoEnum) {
        return appuntamentoRepository.findByStatoAndStatoAppuntamento(StatusEnumeration.A, statoAppuntamentoEnum)
                                     .stream()
                                     .map(appuntamento -> new AppuntamentoMinimalResponseDto(
                                             appuntamento.getId(),
                                             appuntamento.getOrarioAppuntamento(),
                                             new PazienteMinimalResponseDto(
                                                     appuntamento.getPaziente()
                                                                 .getId(),
                                                     appuntamento.getPaziente()
                                                                 .getNome(),
                                                     appuntamento.getPaziente()
                                                                 .getCognome()
                                             ),
                                             new MedicoMinimalResponseDto(
                                                     appuntamento.getMedico()
                                                                 .getId(),
                                                     appuntamento.getMedico()
                                                                 .getNome(),
                                                     appuntamento.getMedico()
                                                                 .getCognome()
                                             )))
                                     .collect(Collectors.toList());

    }

    public List<AppuntamentoMinimalResponseDto> ricercaTuttiAppuntamenti() {
        return appuntamentoRepository.findByStato(StatusEnumeration.A).stream()
                                     .map(appuntamento -> new AppuntamentoMinimalResponseDto(
                                             appuntamento.getId(),
                                             appuntamento.getOrarioAppuntamento(),
                                             new PazienteMinimalResponseDto(
                                                     appuntamento.getPaziente()
                                                                 .getId(),
                                                     appuntamento.getPaziente()
                                                                 .getNome(),
                                                     appuntamento.getPaziente()
                                                                 .getCognome()
                                             ),
                                             new MedicoMinimalResponseDto(
                                                     appuntamento.getMedico()
                                                                 .getId(),
                                                     appuntamento.getMedico()
                                                                 .getNome(),
                                                     appuntamento.getMedico()
                                                                 .getCognome()
                                             )))
                                     .collect(Collectors.toList());

    }

    public ResponseEntity<AppuntamentoEntity> modificaAppuntamento(AppuntamentoRequestDto appuntamentoRequestDto, Long id) {
        Optional<AppuntamentoEntity> optionalAppuntamento = appuntamentoRepository.findByIdAndStato(id,
                                                                                                    StatusEnumeration.A);

        return optionalAppuntamento.map(appuntamento -> {
            appuntamento.setOrarioAppuntamento(appuntamentoRequestDto.getOrarioAppuntamento());
            appuntamento.setNoteAppuntamento(appuntamentoRequestDto.getNoteAppuntamento());
            appuntamento.setStatoAppuntamento(appuntamentoRequestDto.getStatoAppuntamento());

            appuntamento.setDataUltimaModifica(new Date(System.currentTimeMillis()));
            appuntamento.setUltimaModificaDa("Gruppo 5");

            appuntamentoRepository.save(appuntamento);
            return new ResponseEntity<>(appuntamento, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<String> disattivaAppuntamento(Long id) {
        Optional<AppuntamentoEntity> optionalAppuntamento = appuntamentoRepository.findByIdAndStato(id,
                                                                                                    StatusEnumeration.A);
        return optionalAppuntamento.map(appuntamento -> {
            appuntamento.setStato(StatusEnumeration.D);
            appuntamentoRepository.save(appuntamento);
            return new ResponseEntity<>("L'appuntamento è stato disattivato", HttpStatus.OK);
        }).orElse(new ResponseEntity<>("Errore: l'id selezionato non esiste", HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<String> riattivaAppuntamento(Long id) {
        Optional<AppuntamentoEntity> optionalAppuntamento = appuntamentoRepository.findByIdAndStato(id,
                                                                                                    StatusEnumeration.D);
        return optionalAppuntamento.map(appuntamento -> {
                                       appuntamento.setStato(StatusEnumeration.A);
                                       appuntamentoRepository.save(appuntamento);
                                       return new ResponseEntity<>("L'appuntamento è stato riattivato", HttpStatus.OK);
                                   })
                                   .orElse(new ResponseEntity<>(
                                           "Errore: l'id selezionato non esiste o non e' disattivato",
                                           HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<String> cancellaAppuntamento(Long id) {
        Optional<AppuntamentoEntity> optionalAppuntamento = appuntamentoRepository.findByIdAndStatoAndStatoAppuntamento(
                id,
                StatusEnumeration.A,
                StatoAppuntamentoEnum.PRENOTATO);
        return optionalAppuntamento.map(appuntamento -> {
            appuntamento.setStatoAppuntamento(StatoAppuntamentoEnum.CANCELLATO);
            appuntamentoRepository.save(appuntamento);
            return new ResponseEntity<>("L'appuntamento è stato cancellato", HttpStatus.OK);
        }).orElse(new ResponseEntity<>("Errore: l'id selezionato non esiste", HttpStatus.NOT_FOUND));

    }
}
