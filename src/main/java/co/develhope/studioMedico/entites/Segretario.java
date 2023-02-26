package co.develhope.studioMedico.entites;

import co.develhope.studioMedico.enums.GiorniLavorativiEnum;

import javax.persistence.*;

@Entity
@Table(name = "segretario")
public class Segretario extends Persona {

    @Column(name = "sede_di_lavoro" , nullable = false)
    private String sedeDiLavoro;


    public Segretario(){}

    public Segretario(long id, String nome, String cognome, String email, String numeroTelefonico, String sedeDiLavoro) {
        super(id, nome, cognome, email, numeroTelefonico);
        this.sedeDiLavoro = sedeDiLavoro;
    }

    public String getSedeDiLavoro() {
        return sedeDiLavoro;
    }

    public void setSedeDiLavoro(String sedeDiLavoro) {
        this.sedeDiLavoro = sedeDiLavoro;
    }

}
