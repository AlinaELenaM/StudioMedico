package co.develhope.studioMedico.dto.response.appuntamento;

import co.develhope.studioMedico.dto.response.medico.MedicoMinimalResponseDto;

import java.time.LocalDateTime;

public class AppuntamentoMinimalNoPazienteResponseDto {
    private Long id;
    private LocalDateTime orarioAppuntamento;
    private MedicoMinimalResponseDto medicoMinimal;

    public AppuntamentoMinimalNoPazienteResponseDto(Long id, LocalDateTime orarioAppuntamento, MedicoMinimalResponseDto medicoMinimal) {
        this.id = id;
        this.orarioAppuntamento = orarioAppuntamento;
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

    public MedicoMinimalResponseDto getMedicoMinimal() {
        return medicoMinimal;
    }

    public void setMedicoMinimal(MedicoMinimalResponseDto medicoMinimal) {
        this.medicoMinimal = medicoMinimal;
    }
}
