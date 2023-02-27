package co.develhope.studioMedico.entites;


import co.develhope.studioMedico.enums.AttivoEnum;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Date;

@MappedSuperclass
public abstract class Persona {
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "cognome", nullable = false)
    private String cognome;
    @Column(name = "email", nullable = false , unique = true)
    private String email;
    @Column(name = "contatto_telefonico", nullable = false, unique = true)
    private String numeroTelefonico;
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
    @Column(name = "attivo" , nullable = false)
    private AttivoEnum attivo;

    public Persona() {
    }

    public Persona(String nome, String cognome, String email, String numeroTelefonico, String createdBy, Date creationDate, String lastModifiedBy, Date lastModifiedDate, AttivoEnum attivo) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.numeroTelefonico = numeroTelefonico;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = lastModifiedDate;
        this.attivo = attivo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
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
