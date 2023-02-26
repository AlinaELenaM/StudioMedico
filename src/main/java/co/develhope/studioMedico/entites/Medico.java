package co.develhope.studioMedico.entites;

import co.develhope.studioMedico.enums.GiorniLavorativiEnum;

import javax.persistence.*;

@Table
@Entity
public class Medico extends Persona {

    @Column(name = "specializzazione" , nullable = false)
    private String specializzazione;
    @Column(name = "sede_di_lavoro" , nullable = false)
    private String sedeDiLavoro;
    @Column(name = "giorni_lavorativi" , nullable = false)
    private GiorniLavorativiEnum giorniLavorativi;


    public Medico(){}

    public Medico(long id, String nome, String cognome, String email, String numeroTelefonico, String specializzazione, String sedeDiLavoro, GiorniLavorativiEnum giorniLavorativi) {
        super(id, nome, cognome, email, numeroTelefonico);
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

}
