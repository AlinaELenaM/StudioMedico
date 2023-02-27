package co.develhope.studioMedico.entites;

import co.develhope.studioMedico.enums.AttivoEnum;
import co.develhope.studioMedico.enums.GiorniLavorativiEnum;

import javax.persistence.*;
import java.sql.Date;

@Table
@Entity
public class Medico extends Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_medico", nullable = false)
    private Long id;
    @Column(name = "specializzazione" , nullable = false)
    private String specializzazione;
    @Column(name = "sede_di_lavoro" , nullable = false)
    private String sedeDiLavoro;
    @Column(name = "giorni_lavorativi" , nullable = false)
    private GiorniLavorativiEnum giorniLavorativi;


    public Medico(){}

    public Medico(String nome, String cognome, String email, String numeroTelefonico, String createdBy, Date creationDate, String lastModifiedBy, Date lastModifiedDate, AttivoEnum attivo, Long id, String specializzazione, String sedeDiLavoro, GiorniLavorativiEnum giorniLavorativi) {
        super(nome, cognome, email, numeroTelefonico, createdBy, creationDate, lastModifiedBy, lastModifiedDate, attivo);
        this.id = id;
        this.specializzazione = specializzazione;
        this.sedeDiLavoro = sedeDiLavoro;
        this.giorniLavorativi = giorniLavorativi;
    }

    public String getSpecializzazione() {
        return specializzazione;
    }

    public void setSpecializzazione(String specializzazione) {
        this.specializzazione = specializzazione;
    }

    public String getSedeDiLavoro() {
        return sedeDiLavoro;
    }

    public void setSedeDiLavoro(String sedeDiLavoro) {
        this.sedeDiLavoro = sedeDiLavoro;
    }

    public GiorniLavorativiEnum getGiorniLavorativi() {
        return giorniLavorativi;
    }

    public void setGiorniLavorativi(GiorniLavorativiEnum giorniLavorativi) {
        this.giorniLavorativi = giorniLavorativi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
