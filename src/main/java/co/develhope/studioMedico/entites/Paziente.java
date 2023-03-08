package co.develhope.studioMedico.entites;
import co.develhope.studioMedico.enums.StatusEnumeration;

import javax.persistence.*;
import java.sql.Date;

@Table
@Entity
public class Paziente extends Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_paziente", nullable = false)
    private Long id;
    @Column(name = "codice_fiscale", nullable = false)
    private String codiceFiscale;
    @Column(name = "indirizzo", nullable = false)
    private String indirizzo;
    @Column(name = "allergie", nullable = false)
    private String allergie;
    @Column(name = "storico_malattie", nullable = false)
    private String storicoMalattie;

    public Paziente() {
    }

    public Paziente(String nome, String cognome, String email, String numeroTelefonico, String createdBy, Date creationDate, String lastModifiedBy, Date lastModifiedDate, Long id, String codiceFiscale, String indirizzo, String allergie, String storicoMalattie) {
        super(nome, cognome, email, numeroTelefonico, createdBy, creationDate, lastModifiedBy, lastModifiedDate);
        this.id = id;
        this.codiceFiscale = codiceFiscale;
        this.indirizzo = indirizzo;
        this.allergie = allergie;
        this.storicoMalattie = storicoMalattie;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }


    public String getAllergie() {
        return allergie;
    }

    public void setAllergie(String allergie) {
        this.allergie = allergie;
    }

    public String getStoricoMalattie() {
        return storicoMalattie;
    }

    public void setStoricoMalattie(String storicoMalattie) {
        this.storicoMalattie = storicoMalattie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
