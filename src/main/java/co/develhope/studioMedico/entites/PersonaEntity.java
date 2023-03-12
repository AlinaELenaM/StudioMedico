package co.develhope.studioMedico.entites;


import co.develhope.studioMedico.enums.StatusEnumeration;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import java.sql.Date;

@MappedSuperclass
public abstract class PersonaEntity {
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "cognome", nullable = false)
    private String cognome;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "contatto_telefonico", nullable = false, unique = true)
    private String contattoTelefonico;

    @Column(name = "creato_Da", updatable = false)
    private String creatoDa;
    @Column(name = "data_creazione", updatable = false)
    private Date dataCreazione = new Date(System.currentTimeMillis());
    @Column(name = "ultima_modifica_da")
    private String ultimaModificaDa;
    @Column(name = "data_ultima_modifica")
    private Date dataUltimaModifica;
    @Column(name = "stato", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusEnumeration stato = StatusEnumeration.A;

    public PersonaEntity() {
    }

    public PersonaEntity(String nome, String cognome, String email, String contattoTelefonico, String creatoDa, Date dataCreazione, String ultimaModificaDa, Date dataUltimaModifica, StatusEnumeration stato) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.contattoTelefonico = contattoTelefonico;
        this.creatoDa = creatoDa;
        this.dataCreazione = dataCreazione;
        this.ultimaModificaDa = ultimaModificaDa;
        this.dataUltimaModifica = dataUltimaModifica;
        this.stato = stato;
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

    public String getContattoTelefonico() {
        return contattoTelefonico;
    }

    public void setContattoTelefonico(String contattoTelefonico) {
        this.contattoTelefonico = contattoTelefonico;
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
}
