package co.develhope.studioMedico.entites;

import co.develhope.studioMedico.enums.StatoAppuntamentoEnum;
import co.develhope.studioMedico.enums.StatusEnumeration;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table(name = "appuntamento")
public class AppuntamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "id_appuntamento", nullable = false)
    private Long idAppuntamento;
    @NotNull
    @Column(name = "orario_appuntamento", nullable = false)
    private LocalDateTime orarioAppuntamento;
    @Enumerated(EnumType.STRING)
    private StatoAppuntamentoEnum statoAppuntamento;
    @Column(name = "note")
    private String noteAppuntamento;

    @Column(name = "creato_Da", updatable = false)
    private String creatoDa;
    @Column(name = "data_creazione", updatable = false)
    private Date dataCreazione = new Date(System.currentTimeMillis());
    @Column(name = "ultima_modifica_da")
    private String ultimaModificaDa;
    @Column(name = "data_ultima_modifica")
    private Date dataUltimaModifica;
    @NotNull
    @Column(name = "stato", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusEnumeration stato = StatusEnumeration.A;

    @ManyToOne
    @JoinColumn(name = "id_paziente", nullable = false)
    @NotNull
    private PazienteEntity paziente;

    @ManyToOne
    @JoinColumn(name = "id_medico", nullable = false)
    @NotNull
    private MedicoEntity medico;

    public AppuntamentoEntity() {
    }

    public AppuntamentoEntity(Long idAppuntamento, LocalDateTime orarioAppuntamento,
                              StatoAppuntamentoEnum statoAppuntamento, String noteAppuntamento, String creatoDa,
                              Date dataCreazione, String ultimaModificaDa, Date dataUltimaModifica,
                              StatusEnumeration stato, PazienteEntity paziente, MedicoEntity medico) {
        this.idAppuntamento = idAppuntamento;
        this.orarioAppuntamento = orarioAppuntamento;
        this.statoAppuntamento = statoAppuntamento;
        this.noteAppuntamento = noteAppuntamento;
        this.creatoDa = creatoDa;
        this.dataCreazione = dataCreazione;
        this.ultimaModificaDa = ultimaModificaDa;
        this.dataUltimaModifica = dataUltimaModifica;
        this.stato = stato;
        this.paziente = paziente;
        this.medico = medico;
    }

    public Long getIdAppuntamento() {
        return idAppuntamento;
    }

    public void setIdAppuntamento(Long idAppuntamento) {
        this.idAppuntamento = idAppuntamento;
    }

    public LocalDateTime getOrarioAppuntamento() {
        return orarioAppuntamento;
    }

    public void setOrarioAppuntamento(LocalDateTime orarioAppuntamento) {
        this.orarioAppuntamento = orarioAppuntamento;
    }

    public StatoAppuntamentoEnum getStatoAppuntamento() {
        return statoAppuntamento;
    }

    public void setStatoAppuntamento(StatoAppuntamentoEnum statoAppuntamento) {
        this.statoAppuntamento = statoAppuntamento;
    }

    public String getNoteAppuntamento() {
        return noteAppuntamento;
    }

    public void setNoteAppuntamento(String noteAppuntamento) {
        this.noteAppuntamento = noteAppuntamento;
    }

    public String getCreatoDa() {
        return creatoDa;
    }

    public void setCreatoDa(String creatoDa) {
        this.creatoDa = creatoDa;
    }

    public Date getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(Date dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    public String getUltimaModificaDa() {
        return ultimaModificaDa;
    }

    public void setUltimaModificaDa(String ultimaModificaDa) {
        this.ultimaModificaDa = ultimaModificaDa;
    }

    public Date getDataUltimaModifica() {
        return dataUltimaModifica;
    }

    public void setDataUltimaModifica(Date dataUltimaModifica) {
        this.dataUltimaModifica = dataUltimaModifica;
    }

    public StatusEnumeration getStato() {
        return stato;
    }

    public void setStato(StatusEnumeration stato) {
        this.stato = stato;
    }

    public PazienteEntity getPaziente() {
        return paziente;
    }

    public void setPaziente(PazienteEntity paziente) {
        this.paziente = paziente;
    }

    public MedicoEntity getMedico() {
        return medico;
    }

    public void setMedico(MedicoEntity medico) {
        this.medico = medico;
    }
}
