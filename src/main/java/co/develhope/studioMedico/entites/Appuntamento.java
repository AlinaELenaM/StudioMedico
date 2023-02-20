package co.develhope.studioMedico.entites;

import co.develhope.studioMedico.enums.StatoAppuntamento;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table
@Entity
public class Appuntamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAppuntamento;
    private LocalDateTime orarioAppuntamento;
    private StatoAppuntamento statoAppuntamento;
    private String noteAppuntamento;

    //TODO da inserire le relazioni con il Paziente e con il Medico

    public Appuntamento(){}
    public Appuntamento(Long appuntamentoId, LocalDateTime orarioAppuntamento,
                        StatoAppuntamento statoAppuntamento, String noteAppuntamento) {
        this.idAppuntamento = appuntamentoId;
        this.orarioAppuntamento = orarioAppuntamento;
        this.statoAppuntamento = statoAppuntamento;
        this.noteAppuntamento = noteAppuntamento;
    }

    public Long getIdAppuntamento() {
        return idAppuntamento;
    }
    public void setIdAppuntamento(Long appuntamentoId) {
        this.idAppuntamento = appuntamentoId;
    }
    public LocalDateTime getOrarioAppuntamento() {
        return orarioAppuntamento;
    }
    public void setOrarioAppuntamento(LocalDateTime orarioAppuntamento) {
        this.orarioAppuntamento = orarioAppuntamento;
    }
    public StatoAppuntamento getStatoAppuntamento() {
        return statoAppuntamento;
    }
    public void setStatoAppuntamento(StatoAppuntamento statoAppuntamento) {
        this.statoAppuntamento = statoAppuntamento;
    }
    public String getNoteAppuntamento() {
        return noteAppuntamento;
    }
    public void setNoteAppuntamento(String noteAppuntamento) {
        this.noteAppuntamento = noteAppuntamento;
    }

    @Override
    public String toString() {
        return "Appuntamento: " +
                "appuntamentoId " + idAppuntamento +
                ", orarioAppuntamento " + orarioAppuntamento +
                ", statoAppuntamento " + statoAppuntamento +
                ", noteAppuntamento " + noteAppuntamento;
    }
}
