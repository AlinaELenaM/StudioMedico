package co.develhope.studioMedico.dto.request;

import co.develhope.studioMedico.enums.StatoAppuntamentoEnum;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class AppuntamentoRequestDto {
    @NotNull
    private LocalDateTime orarioAppuntamento;
    private String noteAppuntamento;
    @NotNull
    private Long idPaziente;
    @NotNull
    private Long idMedico;
    private StatoAppuntamentoEnum statoAppuntamento;

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

    public Long getIdPaziente() {
        return idPaziente;
    }

    public void setIdPaziente(Long idPaziente) {
        this.idPaziente = idPaziente;
    }

    public Long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Long idMedico) {
        this.idMedico = idMedico;
    }

    public StatoAppuntamentoEnum getStatoAppuntamento() {
        return statoAppuntamento;
    }

    public void setStatoAppuntamento(StatoAppuntamentoEnum statoAppuntamento) {
        this.statoAppuntamento = statoAppuntamento;
    }
}
