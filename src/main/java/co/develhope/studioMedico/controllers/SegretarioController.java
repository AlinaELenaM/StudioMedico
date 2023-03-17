package co.develhope.studioMedico.controllers;


import co.develhope.studioMedico.dto.request.AppuntamentoRequestDto;
import co.develhope.studioMedico.dto.request.MedicoRequestDto;
import co.develhope.studioMedico.dto.request.PazienteRequestDto;
import co.develhope.studioMedico.dto.request.SegretarioRequestDto;
import co.develhope.studioMedico.dto.response.appuntamento.AppuntamentoMinimalResponseDto;
import co.develhope.studioMedico.dto.response.appuntamento.AppuntamentoResponseDto;
import co.develhope.studioMedico.dto.response.medico.MedicoMinimalResponseDto;
import co.develhope.studioMedico.dto.response.medico.MedicoResponseDto;
import co.develhope.studioMedico.dto.response.paziente.PazienteMinimalResponseDto;
import co.develhope.studioMedico.dto.response.paziente.PazienteResponseDto;
import co.develhope.studioMedico.dto.response.segretario.SegretarioMinimalResponseDto;
import co.develhope.studioMedico.dto.response.segretario.SegretarioResponseDto;
import co.develhope.studioMedico.enums.StatoAppuntamentoEnum;
import co.develhope.studioMedico.services.AppuntamentoService;
import co.develhope.studioMedico.services.MedicoService;
import co.develhope.studioMedico.services.PazienteService;
import co.develhope.studioMedico.services.SegretarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/segretario")
public class SegretarioController {

    private final SegretarioService segretarioService;
    private final MedicoService medicoService;
    private final PazienteService pazienteService;
    private final AppuntamentoService appuntamentoService;

    public SegretarioController(SegretarioService segretarioService, MedicoService medicoService, PazienteService pazienteService, AppuntamentoService appuntamentoService) {
        this.segretarioService = segretarioService;
        this.medicoService = medicoService;
        this.pazienteService = pazienteService;
        this.appuntamentoService = appuntamentoService;
    }

    //METODI PER IL MEDICO

    @PostMapping("/medico_crea")
    public ResponseEntity<String> creaNuovoMedico(@RequestBody MedicoRequestDto medicoRequestDto) {
        medicoService.creaMedico(medicoRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Medico creato correttamente");
    }


    @GetMapping("/medico_ricerca/{id}")
    public ResponseEntity<MedicoResponseDto> ricercaMedicoPerId(@PathVariable Long id) {
        return medicoService.ricercaMedico(id);
    }

    @GetMapping("/medico_ricerca_tutti")
    public List<MedicoMinimalResponseDto> ricercaTuttiMedici() {
        return medicoService.ricercaTuttiMedici();
    }


    @PutMapping("/medico_modifica/{id}")
    public ResponseEntity<String> modificaMedico(@RequestBody MedicoRequestDto medicoRequestDto, @PathVariable Long id) {
        medicoService.modificaMedico(medicoRequestDto, id);
        return ResponseEntity.status(200).body("Medico modificato correttamente");
    }


    @DeleteMapping("/medico_disattiva/{id}")
    public ResponseEntity<String> disattivaMedico(@PathVariable Long id) {
        return medicoService.disattivaMedico(id);
    }


    @PutMapping("/medico_riattiva/{id}")
    public ResponseEntity<String> riattivaMedico(@PathVariable Long id) {
        return medicoService.riattivaMedico(id);
    }

    //METODI PER IL PAZIENTE

    @PostMapping("/paziente_crea")
    public ResponseEntity<String> creaPazente(@RequestBody PazienteRequestDto pazienteRequestDto) {
        pazienteService.creaPaziente(pazienteRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Paziente creato correttamente");
    }


    @GetMapping("/paziente_ricerca/{id}")
    public ResponseEntity<PazienteResponseDto> ricercaPazientePerId(@PathVariable Long id) {
        return pazienteService.ricercaPaziente(id);
    }


    @GetMapping({"/paziente_ricerca_tutti"})
    public List<PazienteMinimalResponseDto> ricercaTuttiPazienti() {
        return pazienteService.ricercaTuttiPazienti();
    }


    @PutMapping("/paziente_modifica/{id}")
    public ResponseEntity<String> modificaPaziente(@RequestBody PazienteRequestDto pazienteRequestDto, @PathVariable Long id) {
        pazienteService.modificaPaziente(pazienteRequestDto, id);
        return ResponseEntity.status(200).body("Paziente modificato correttamente");
    }

    @DeleteMapping("/paziente_disattiva/{id}")
    public ResponseEntity<String> disattivaPaziente(@PathVariable Long id) {
        return pazienteService.disattivaPaziente(id);
    }

    @PutMapping("/paziente_riattiva/{id}")
    public ResponseEntity<String> riattivaPaziente(@PathVariable Long id) {
        return pazienteService.riattivaPaziente(id);
    }

    //METODI PER IL SEGRETARIO

    @PostMapping("/segretario_crea")
    public ResponseEntity<String> creaSegretario(@RequestBody SegretarioRequestDto segretarioRequestDto) {
        segretarioService.creaSegretario(segretarioRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Segretario creato correttamente");
    }

    @GetMapping("/segretario_ricerca/{id}")
    public ResponseEntity<SegretarioResponseDto> ricercaSegretario(@PathVariable Long id) {
        return segretarioService.ricercaSegretario(id);
    }

    @GetMapping("/segretario_ricerca_tutti")
    public List<SegretarioMinimalResponseDto> ricercaTuttiSegretari() {
        return segretarioService.ricercaTuttiSegretari();
    }

    @PutMapping("/segretario_modifica/{id}")
    public ResponseEntity<String> modificaSegretario(@RequestBody SegretarioRequestDto segretarioRequestDto, @PathVariable Long id) {
        segretarioService.modificaSegretario(segretarioRequestDto, id);
        return ResponseEntity.status(200).body("Segretario modificato correttamente");
    }

    @DeleteMapping("/segretario_disattiva/{id}")
    public ResponseEntity<String> disattivaSegretario(@PathVariable Long id) {
        return segretarioService.disattivaSegretario(id);
    }

    @PutMapping("/segretario_riattiva/{id}")
    public ResponseEntity<String> riattivaSegretario(@PathVariable Long id) {
        return segretarioService.riattivaSegretario(id);
    }

    //METODI APPUNTAMENTO

    @PostMapping("/appuntamento_crea")
    public ResponseEntity<String> creaAppuntamento(@RequestBody AppuntamentoRequestDto appuntamentoRequestDto) {
        appuntamentoService.creaAppuntamento(appuntamentoRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Appuntamento creato correttamente!");
    }

    @GetMapping("/appuntamento_ricerca/{id}")
    public ResponseEntity<AppuntamentoResponseDto> ricercaAppuntamento(@PathVariable Long id) throws Exception {
        return appuntamentoService.ricercaAppuntamento(id);
    }


    @GetMapping("/appuntamento_ricerca_tutti")
    public List<AppuntamentoMinimalResponseDto> ricercaTuttiAppuntamenti() {
        return appuntamentoService.ricercaTuttiAppuntamenti();
    }

    @GetMapping("/appuntamento_ricerca_per_stato")
    public List<AppuntamentoMinimalResponseDto> ricercaTuttiAppuntamentiPerStato(@RequestParam StatoAppuntamentoEnum statoAppuntamento) {
        return appuntamentoService.ricercaTuttiAppuntamentiPerStato(statoAppuntamento);
    }

    @PutMapping("/appuntamento_modifica/{id}")
    public ResponseEntity<String> modificaAppuntamento(@RequestBody AppuntamentoRequestDto appuntamentoRequestDto, @PathVariable Long id) {
        appuntamentoService.modificaAppuntamento(appuntamentoRequestDto, id);
        return ResponseEntity.status(200).body("Appuntamento modificato correttamente!");
    }

    @DeleteMapping("/appuntamento_disattiva/{id}")
    public ResponseEntity<String> disattivaAppuntamento(@PathVariable Long id) {
        return appuntamentoService.disattivaAppuntamento(id);
    }

    @PutMapping("/appuntamento_riattiva/{id}")
    public ResponseEntity<String> riattivaAppuntamento(@PathVariable Long id) {
        return appuntamentoService.riattivaAppuntamento(id);
    }

    @DeleteMapping("/appuntamento_cancella/{id}")
    public ResponseEntity<String> cancellaAppuntamento(@PathVariable Long id) {
        return appuntamentoService.cancellaAppuntamento(id);
    }
}
