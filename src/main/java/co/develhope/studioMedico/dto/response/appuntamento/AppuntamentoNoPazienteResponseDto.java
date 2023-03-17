package co.develhope.studioMedico.dto.response.appuntamento;

import co.develhope.studioMedico.dto.response.medico.MedicoMinimalResponseDto;

import java.time.LocalDateTime;

public class AppuntamentoNoPazienteResponseDto {
    private Long id;
    private LocalDateTime orarioAppuntamento;
    private String noteAppuntamento;
    private MedicoMinimalResponseDto medicoMinimal;

    public AppuntamentoNoPazienteResponseDto(Long id, LocalDateTime orarioAppuntamento, String noteAppuntamento, MedicoMinimalResponseDto medicoMinimal) {
        this.id = id;
        this.orarioAppuntamento = orarioAppuntamento;
        this.noteAppuntamento = noteAppuntamento;
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

    public MedicoMinimalResponseDto getMedicoMinimal() {
        return medicoMinimal;
    }

    public void setMedicoMinimal(MedicoMinimalResponseDto medicoMinimal) {
        this.medicoMinimal = medicoMinimal;
    }
}
