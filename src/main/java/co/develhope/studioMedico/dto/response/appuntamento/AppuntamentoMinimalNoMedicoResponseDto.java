package co.develhope.studioMedico.dto.response.appuntamento;

import co.develhope.studioMedico.dto.response.paziente.PazienteMinimalResponseDto;

import java.time.LocalDateTime;

public class AppuntamentoMinimalNoMedicoResponseDto {
    private Long id;
    private LocalDateTime orarioAppuntamento;
    private PazienteMinimalResponseDto pazienteMinimal;

    public AppuntamentoMinimalNoMedicoResponseDto(Long id, LocalDateTime orarioAppuntamento, PazienteMinimalResponseDto pazienteMinimal) {
        this.id = id;
        this.orarioAppuntamento = orarioAppuntamento;
        this.pazienteMinimal = pazienteMinimal;
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
}
