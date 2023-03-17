package co.develhope.studioMedico.controllers;

import co.develhope.studioMedico.dto.response.appuntamento.AppuntamentoNoMedicoResponseDto;
import co.develhope.studioMedico.dto.response.medico.MedicoResponseDto;
import co.develhope.studioMedico.dto.response.paziente.PazienteNoMedicoResponseDto;
import co.develhope.studioMedico.services.AppuntamentoService;
import co.develhope.studioMedico.services.MedicoService;
import co.develhope.studioMedico.services.PazienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medico")
public class MedicoController {
    private final MedicoService medicoService;
    private final PazienteService pazienteService;
    private final AppuntamentoService appuntamentoService;

    public MedicoController(MedicoService medicoService, PazienteService pazienteService, AppuntamentoService appuntamentoService) {
        this.medicoService = medicoService;
        this.pazienteService = pazienteService;
        this.appuntamentoService = appuntamentoService;
    }


    @GetMapping("/{idMedico}/paziente_ricerca/{idPaziente}")
    public ResponseEntity<PazienteNoMedicoResponseDto> ricercaPazientePerMedico(@PathVariable Long idPaziente, @PathVariable Long idMedico) {
        return pazienteService.ricercaPazientePerMedico(idPaziente, idMedico);
    }

    @GetMapping("/medico_ricerca/{id}")
    public ResponseEntity<MedicoResponseDto> ricercaMedico(@PathVariable Long id) {
        return medicoService.ricercaMedico(id);
    }

    @GetMapping("/{idMedico}/appuntamento_ricerca/{idAppuntamento}")
    public ResponseEntity<AppuntamentoNoMedicoResponseDto> ricercaAppuntamentoPerMedico(@PathVariable Long idAppuntamento, @PathVariable Long idMedico) {
        return appuntamentoService.ricercaAppuntamentoPerMedico(idAppuntamento, idMedico);
    }

    @DeleteMapping("/appuntamento_disattiva/{id}")
    public ResponseEntity<String> disattivaAppuntamento(@PathVariable Long id) {
        return appuntamentoService.disattivaAppuntamento(id);
    }

}
