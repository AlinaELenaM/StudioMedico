package co.develhope.studioMedico.entites;
import co.develhope.studioMedico.enums.GiorniLavorativiEnum;

import javax.persistence.*;

@Table
@Entity
public class Paziente extends Persona {

    @Column(name = "codice_fiscale", nullable = false)
    private String codiceFiscale;
    @Column(name = "indirizzo", nullable = false)
    private String indirizzo;
    @Column(name = "contatto_telefonico", nullable = false)
    private String contattoTelefonico;
    @Column(name = "allergie", nullable = false)
    private String allergie;
    @Column(name = "storico_malattie", nullable = false)
    private String storicoMalattie;

    public Paziente(long id, String nome, String cognome, String email, String codiceFiscale, String indirizzo, String contattoTelefonico, String allergie, String storicoMalattie) {
        super(id, nome, cognome, email);
        this.codiceFiscale = codiceFiscale;
        this.indirizzo = indirizzo;
        this.contattoTelefonico = contattoTelefonico;
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

    public String getContattoTelefonico() {
        return contattoTelefonico;
    }

    public void setContattoTelefonico(String contattoTelefonico) {
        this.contattoTelefonico = contattoTelefonico;
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
}
