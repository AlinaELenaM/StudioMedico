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
    @Column(name = "id_appuntamento", nullable = false)
    private Long id;
    @NotNull
    @Column(name = "orario_appuntamento", nullable = false)
    private LocalDateTime orarioAppuntamento;
    @Enumerated(EnumType.STRING)
    private StatoAppuntamentoEnum statoAppuntamento = StatoAppuntamentoEnum.PRENOTATO;
    @Column(name = "note")
    private String noteAppuntamento;

    @Column(name = "creato_da", updatable = false)
    private final String creatoDa;
    @Column(name = "data_creazione", updatable = false)
    private final Date dataCreazione = new Date(System.currentTimeMillis());
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


    public AppuntamentoEntity(LocalDateTime orarioAppuntamento, String noteAppuntamento, PazienteEntity paziente, MedicoEntity medico, String creatoDa) {
        this.orarioAppuntamento = orarioAppuntamento;
        this.noteAppuntamento = noteAppuntamento;
        this.creatoDa = creatoDa;
        this.paziente = paziente;
        this.medico = medico;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long idAppuntamento) {
        this.id = idAppuntamento;
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


    public Date getDataCreazione() {
        return dataCreazione;
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
