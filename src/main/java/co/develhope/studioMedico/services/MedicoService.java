package co.develhope.studioMedico.services;

import co.develhope.studioMedico.dto.request.MedicoRequestDto;
import co.develhope.studioMedico.dto.response.appuntamento.AppuntamentoMinimalNoMedicoResponseDto;
import co.develhope.studioMedico.dto.response.medico.MedicoMinimalResponseDto;
import co.develhope.studioMedico.dto.response.medico.MedicoResponseDto;
import co.develhope.studioMedico.dto.response.paziente.PazienteMinimalResponseDto;
import co.develhope.studioMedico.dto.response.segretario.SegretarioMinimalResponseDto;
import co.develhope.studioMedico.entites.MedicoEntity;
import co.develhope.studioMedico.enums.StatusEnumeration;
import co.develhope.studioMedico.repositories.MedicoRepository;
import co.develhope.studioMedico.repositories.PazienteRepository;
import co.develhope.studioMedico.repositories.SegretarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicoService {
    private final MedicoRepository medicoRepository;
    private final PazienteRepository pazienteRepository;
    private final SegretarioRepository segretarioRepository;

    public MedicoService(MedicoRepository medicoRepository, PazienteRepository pazienteRepository, SegretarioRepository segretarioRepository) {
        this.medicoRepository = medicoRepository;
        this.pazienteRepository = pazienteRepository;
        this.segretarioRepository = segretarioRepository;
    }


    public MedicoEntity creaMedico(MedicoRequestDto medicoRequestDto) throws RuntimeException {
        MedicoEntity medicoEntity = new MedicoEntity(
                medicoRequestDto.getNome(),
                medicoRequestDto.getCognome(),
                medicoRequestDto.getEmail(),
                medicoRequestDto.getContattoTelefonico(),
                medicoRequestDto.getSpecializzazione(),
                medicoRequestDto.getSedeLavoro(),
                medicoRequestDto.getGiorniLavorativi(),
                "Gruppo 5"
        );

        medicoEntity.setListaPazienti(medicoRequestDto
                                              .getListaIdPazienti().stream()
                                              .map(pazienteId -> pazienteRepository.findByIdAndStato(pazienteId,
                                                                                                     StatusEnumeration.A)
                                                                                   .orElseThrow(() -> new RuntimeException(
                                                                                           "Paziente con id " + pazienteId + " non presente nel DB")))
                                              .collect(Collectors.toList()));
        medicoEntity.setListaSegretari(medicoRequestDto
                                               .getListaIdSegretari().stream()
                                               .map(segretarioId -> segretarioRepository.findByIdAndStato(segretarioId,
                                                                                                          StatusEnumeration.A)
                                                                                        .orElseThrow(() -> new RuntimeException(
                                                                                                "Segretario con id " + segretarioId + " non presente nel DB")))
                                               .collect(Collectors.toList()));

        return medicoRepository.save(medicoEntity);
    }

    public ResponseEntity<MedicoResponseDto> ricercaMedico(Long id) {
        Optional<MedicoEntity> optionalMedico = medicoRepository.findByIdAndStato(id, StatusEnumeration.A);
        return optionalMedico.map(medico -> new ResponseEntity<>(
                                     new MedicoResponseDto(
                                             medico.getId(),
                                             medico.getNome(),
                                             medico.getCognome(),
                                             medico.getEmail(),
                                             medico.getContattoTelefonico(),
                                             medico.getSpecializzazione(),
                                             medico.getSedeLavoro(),
                                             medico.getGiorniLavorativi(),
                                             medico.getListaPazienti().stream().map(paziente -> new PazienteMinimalResponseDto(
                                                     paziente.getId(), paziente.getNome(), paziente.getCognome()
                                             )).collect(Collectors.toList()),
                                             medico.getListaSegretari().stream().map(segretario -> new SegretarioMinimalResponseDto(
                                                     segretario.getId(), segretario.getNome(), segretario.getCognome()
                                             )).collect(Collectors.toList()),
                                             medico.getListaAppuntamenti().stream()
                                                   .map(appuntamento -> new AppuntamentoMinimalNoMedicoResponseDto(
                                                           appuntamento.getId(),
                                                           appuntamento.getOrarioAppuntamento(),
                                                           new PazienteMinimalResponseDto(
                                                                   appuntamento.getPaziente().getId(),
                                                                   appuntamento.getPaziente().getNome(),
                                                                   appuntamento.getPaziente().getCognome()
                                                           )
                                                   ))
                                                   .collect(Collectors.toList())

                                     ), HttpStatus.OK))
                             .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    public List<MedicoMinimalResponseDto> ricercaTuttiMedici() {
        return medicoRepository.findByStato(StatusEnumeration.A)
                               .stream()
                               .map(medico -> new MedicoMinimalResponseDto(medico.getId(),
                                                                           medico.getNome(),
                                                                           medico.getCognome()))
                               .collect(Collectors.toList());

    }

    public ResponseEntity<MedicoEntity> modificaMedico(MedicoRequestDto medicoRequestDto, Long id) {
        Optional<MedicoEntity> optionalMedico = medicoRepository.findByIdAndStato(id, StatusEnumeration.A);

        return optionalMedico.map(medico -> {
            medico.setNome(medicoRequestDto.getNome());
            medico.setCognome(medicoRequestDto.getCognome());
            medico.setEmail(medicoRequestDto.getEmail());
            medico.setContattoTelefonico(medicoRequestDto.getContattoTelefonico());
            medico.setGiorniLavorativi(medicoRequestDto.getGiorniLavorativi());
            medico.setSedeLavoro(medicoRequestDto.getSedeLavoro());
            medico.setSpecializzazione(medicoRequestDto.getSpecializzazione());

            medico.setDataUltimaModifica(new Date(System.currentTimeMillis()));
            medico.setUltimaModificaDa("Gruppo 5");

            medicoRepository.save(medico);
            return new ResponseEntity<>(medico, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));


    }

    public ResponseEntity<String> disattivaMedico(Long id) {
        Optional<MedicoEntity> optionalMedico = medicoRepository.findByIdAndStato(id, StatusEnumeration.A);

        return optionalMedico.map(medico -> {
            medico.setStato(StatusEnumeration.D);
            medicoRepository.save(medico);
            return new ResponseEntity<>("Il medico è stato disattivato", HttpStatus.OK);
        }).orElse(new ResponseEntity<>("Errore: l'id selezionato non esiste", HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<String> riattivaMedico(Long id) {
        Optional<MedicoEntity> optionalMedico = medicoRepository.findByIdAndStato(id, StatusEnumeration.D);

        return optionalMedico.map(medico -> {
                                 medico.setStato(StatusEnumeration.A);
                                 medicoRepository.save(medico);
                                 return new ResponseEntity<>("Il medico è stato riattivato", HttpStatus.OK);
                             })
                             .orElse(new ResponseEntity<>("Errore: l'id selezionato non esiste o non e' disattivato",
                                                          HttpStatus.NOT_FOUND));
    }


}
