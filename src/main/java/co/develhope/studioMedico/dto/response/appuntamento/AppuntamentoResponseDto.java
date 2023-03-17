package co.develhope.studioMedico.dto.response.appuntamento;

import co.develhope.studioMedico.dto.response.medico.MedicoMinimalResponseDto;
import co.develhope.studioMedico.dto.response.paziente.PazienteMinimalResponseDto;

import java.time.LocalDateTime;

public class AppuntamentoResponseDto {
    private Long id;
    private LocalDateTime orarioAppuntamento;
    private String noteAppuntamento;
    private PazienteMinimalResponseDto pazienteMinimal;
    private MedicoMinimalResponseDto medicoMinimal;

    public AppuntamentoResponseDto(Long id, LocalDateTime orarioAppuntamento, String noteAppuntamento, PazienteMinimalResponseDto pazienteMinimal, MedicoMinimalResponseDto medicoMinimal) {
        this.id = id;
        this.orarioAppuntamento = orarioAppuntamento;
        this.noteAppuntamento = noteAppuntamento;
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

    public String getNoteAppuntamento() {
        return noteAppuntamento;
    }

    public void setNoteAppuntamento(String noteAppuntamento) {
        this.noteAppuntamento = noteAppuntamento;
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
