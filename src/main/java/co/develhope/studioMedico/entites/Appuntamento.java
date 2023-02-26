package co.develhope.studioMedico.entites;

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
@EntityListeners(AuditingEntityListener.class)
public class Appuntamento <U> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAppuntamento;
    private LocalDateTime orarioAppuntamento;
    private StatoAppuntamento statoAppuntamento;
    private String noteAppuntamento;
    //updatable flag helps to avoid the override of
    //column's value during the update operation
    @CreatedBy
    @Column(name = "created_by", updatable = false)
    private U createdBy;
    //updatable flag helps to avoid the override of
    //column's value during the update operation
    @CreatedDate
    @Column(name = "created_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @LastModifiedBy
    @Column(name = "last_modified_by")
    private U lastModifiedBy;
    @LastModifiedDate
    @Column(name = "last_modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Column(name = "attivo" , nullable = false)
    private boolean attivo;
    public Appuntamento(){}

    public Appuntamento(Long idAppuntamento, LocalDateTime orarioAppuntamento, StatoAppuntamento statoAppuntamento, String noteAppuntamento, U createdBy, Date creationDate, U lastModifiedBy, Date lastModifiedDate, boolean attivo) {
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

    public U getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(U createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public U getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(U lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public boolean isAttivo() {
        return attivo;
    }

    public void setAttivo(boolean attivo) {
        this.attivo = attivo;
    }
}
