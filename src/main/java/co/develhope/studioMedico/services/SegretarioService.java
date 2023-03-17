package co.develhope.studioMedico.services;

import co.develhope.studioMedico.dto.request.SegretarioRequestDto;
import co.develhope.studioMedico.dto.response.segretario.SegretarioMinimalResponseDto;
import co.develhope.studioMedico.dto.response.segretario.SegretarioResponseDto;
import co.develhope.studioMedico.entites.SegretarioEntity;
import co.develhope.studioMedico.enums.StatusEnumeration;
import co.develhope.studioMedico.repositories.MedicoRepository;
import co.develhope.studioMedico.repositories.SegretarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SegretarioService {
    private final SegretarioRepository segretarioRepository;
    private final MedicoRepository medicoRepository;

    public SegretarioService(SegretarioRepository segretarioRepository, MedicoRepository medicoRepository) {
        this.segretarioRepository = segretarioRepository;
        this.medicoRepository = medicoRepository;
    }


    public SegretarioEntity creaSegretario(SegretarioRequestDto segretarioRequestDto) throws RuntimeException {
        SegretarioEntity segretarioEntity = new SegretarioEntity(
                segretarioRequestDto.getNome(),
                segretarioRequestDto.getCognome(),
                segretarioRequestDto.getEmail(),
                segretarioRequestDto.getContattoTelefonico(),
                segretarioRequestDto.getSedeLavoro(),
                "Gruppo 5"
        );
        segretarioEntity.setListaMedici(segretarioRequestDto
                                                .getListaIdMedici().stream()
                                                .map(medicoId -> medicoRepository.findByIdAndStato(medicoId,
                                                                                                   StatusEnumeration.A)
                                                                                 .orElseThrow(() -> new RuntimeException(
                                                                                         "Medico con id " + medicoId + " non presente nel DB")))
                                                .collect(Collectors.toList()));

        return segretarioRepository.save(segretarioEntity);
    }

    public ResponseEntity<SegretarioResponseDto> ricercaSegretario(Long id) {
        Optional<SegretarioEntity> optionalSegretario = segretarioRepository.findByIdAndStato(id, StatusEnumeration.A);
        return optionalSegretario.map(segretario -> new ResponseEntity<>(new SegretarioResponseDto(
                                         segretario.getId(),
                                         segretario.getNome(),
                                         segretario.getCognome(),
                                         segretario.getEmail(),
                                         segretario.getContattoTelefonico(),
                                         segretario.getSedeLavoro(),
                                         new ArrayList<>()//TODO da modificare con MedicoMinimalDTO
                                 ), HttpStatus.OK))
                                 .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public List<SegretarioMinimalResponseDto> ricercaTuttiSegretari() {

        return segretarioRepository.findByStato(StatusEnumeration.A)
                                   .stream()
                                   .map(segretario -> new SegretarioMinimalResponseDto(segretario.getId(),
                                                                                       segretario.getNome(),
                                                                                       segretario.getCognome()))
                                   .collect(Collectors.toList());
    }

    public ResponseEntity<SegretarioEntity> modificaSegretario(SegretarioRequestDto segretarioRequestDto, Long id) {
        Optional<SegretarioEntity> optionalSegretario = segretarioRepository.findByIdAndStato(id, StatusEnumeration.A);
        return optionalSegretario.map(segretario -> {
            segretario.setNome(segretarioRequestDto.getNome());
            segretario.setCognome(segretarioRequestDto.getCognome());
            segretario.setEmail(segretarioRequestDto.getEmail());
            segretario.setContattoTelefonico(segretarioRequestDto.getContattoTelefonico());
            segretario.setSedeLavoro(segretarioRequestDto.getSedeLavoro());

            segretario.setDataUltimaModifica(new Date(System.currentTimeMillis()));
            segretario.setUltimaModificaDa("Gruppo 5");

            segretarioRepository.save(segretario);
            return new ResponseEntity<>(segretario, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    public ResponseEntity<String> disattivaSegretario(Long id) {
        Optional<SegretarioEntity> optionalSegretario = segretarioRepository.findByIdAndStato(id, StatusEnumeration.A);
        return optionalSegretario.map(segretario -> {
            segretario.setStato(StatusEnumeration.D);
            segretarioRepository.save(segretario);
            return new ResponseEntity<>("Il segretario è stato disattivato", HttpStatus.OK);
        }).orElse(new ResponseEntity<>("Errore: l'id selezionato non esiste", HttpStatus.NOT_FOUND));

    }

    public ResponseEntity<String> riattivaSegretario(Long id) {
        Optional<SegretarioEntity> optionalSegretario = segretarioRepository.findByIdAndStato(id, StatusEnumeration.D);
        return optionalSegretario.map(segretario -> {
                                     segretario.setStato(StatusEnumeration.A);
                                     segretarioRepository.save(segretario);
                                     return new ResponseEntity<>("Il segretario è stato riattivato", HttpStatus.OK);
                                 })
                                 .orElse(new ResponseEntity<>("Errore: l'id selezionato non esiste o non e' disattivato",
                                                              HttpStatus.NOT_FOUND));

    }


}
