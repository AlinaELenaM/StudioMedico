package co.develhope.studioMedico.entites;

import co.develhope.studioMedico.enums.StatusEnumeration;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "segretario")
public class Segretario extends Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_segretario", nullable = false)
    private Long id;
    @Column(name = "sede_di_lavoro" , nullable = false)
    private String sedeDiLavoro;

    public Segretario(){}

    public Segretario(String nome, String cognome, String email, String numeroTelefonico, String createdBy, Date creationDate, String lastModifiedBy, Date lastModifiedDate, Long id, String sedeDiLavoro) {
        super(nome, cognome, email, numeroTelefonico, createdBy, creationDate, lastModifiedBy, lastModifiedDate);
        this.id = id;
        this.sedeDiLavoro = sedeDiLavoro;
    }

    public String getSedeDiLavoro() {
        return sedeDiLavoro;
    }

    public void setSedeDiLavoro(String sedeDiLavoro) {
        this.sedeDiLavoro = sedeDiLavoro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
