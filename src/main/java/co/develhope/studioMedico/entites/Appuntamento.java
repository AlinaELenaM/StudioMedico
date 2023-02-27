package co.develhope.studioMedico.entites;

import co.develhope.studioMedico.enums.AttivoEnum;
import co.develhope.studioMedico.enums.StatoAppuntamento;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Date;
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
    //updatable flag helps to avoid the override of
    //column's value during the update operation
    @Column(name = "created_by", updatable = false)
    private String createdBy;
    //updatable flag helps to avoid the override of
    //column's value during the update operation
    @Column(name = "created_date", updatable = false)
    private Date creationDate;
    @Column(name = "last_modified_by")
    private String lastModifiedBy;
    @Column(name = "last_modified_date")
    private Date lastModifiedDate;
    //refactor con enumerato active e delete (var 1 - A / D)
    @Column(name = "attivo" , nullable = false)
    private AttivoEnum attivo;
    public Appuntamento(){}

    public Appuntamento(Long idAppuntamento, LocalDateTime orarioAppuntamento, StatoAppuntamento statoAppuntamento, String noteAppuntamento, String createdBy, Date creationDate, String lastModifiedBy, Date lastModifiedDate, AttivoEnum attivo) {
        this.idAppuntamento = idAppuntamento;
        this.orarioAppuntamento = orarioAppuntamento;
        this.statoAppuntamento = statoAppuntamento;
        this.noteAppuntamento = noteAppuntamento;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = lastModifiedDate;
        this.attivo = attivo;
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
    public String getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    public Date getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }
    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
    public AttivoEnum getAttivo() {
        return attivo;
    }
    public void setAttivo(AttivoEnum attivo) {
        this.attivo = attivo;
    }
}
