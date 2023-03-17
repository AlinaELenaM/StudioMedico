package co.develhope.studioMedico.dto.response.appuntamento;

import co.develhope.studioMedico.dto.response.medico.MedicoMinimalResponseDto;
import co.develhope.studioMedico.dto.response.paziente.PazienteMinimalResponseDto;

import java.time.LocalDateTime;

public class AppuntamentoMinimalResponseDto {
    private Long id;
    private LocalDateTime orarioAppuntamento;
    private PazienteMinimalResponseDto pazienteMinimal;
    private MedicoMinimalResponseDto medicoMinimal;

    public AppuntamentoMinimalResponseDto(Long id, LocalDateTime orarioAppuntamento, PazienteMinimalResponseDto pazienteMinimal, MedicoMinimalResponseDto medicoMinimal) {
        this.id = id;
        this.orarioAppuntamento = orarioAppuntamento;
        this.pazienteMinimal = pazienteMinimal;
        this.medicoMinimal = medicoMinimal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getOrarioAppuntamento() {
        return orarioAppuntamento;
    }

    public void setOrarioAppuntamento(LocalDateTime orarioAppuntamento) {
        this.orarioAppuntamento = orarioAppuntamento;
    }

    public PazienteMinimalResponseDto getPazienteMinimal() {
        return pazienteMinimal;
    }

    public void setPazienteMinimal(PazienteMinimalResponseDto pazienteMinimal) {
        this.pazienteMinimal = pazienteMinimal;
    }

    public MedicoMinimalResponseDto getMedicoMinimal() {
        return medicoMinimal;
    }

    public void setMedicoMinimal(MedicoMinimalResponseDto medicoMinimal) {
        this.medicoMinimal = medicoMinimal;
    }
}
