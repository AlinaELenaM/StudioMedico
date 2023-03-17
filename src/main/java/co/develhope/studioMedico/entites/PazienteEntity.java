package co.develhope.studioMedico.entites;

import javax.persistence.*;
import java.util.List;

@Table(name = "paziente")
@Entity
public class PazienteEntity extends PersonaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_paziente", nullable = false)
    private Long id;
    @Column(name = "codice_fiscale", nullable = false)

    private String codiceFiscale;
    @Column(name = "indirizzo", nullable = false)

    private String indirizzo;
    @Column(name = "allergie")
    private String allergie;
    @Column(name = "storico_malattie")
    private String storicoMalattie;

    @OneToMany(mappedBy = "paziente")
    private List<AppuntamentoEntity> listaAppuntamenti;

    @ManyToMany
    @JoinTable(name = "medico_paziente",
            joinColumns =
            @JoinColumn(name = "id_paziente", referencedColumnName = "id_paziente"),
            inverseJoinColumns =
            @JoinColumn(name = "id_medico", referencedColumnName = "id_medico")
    )
    private List<MedicoEntity> listaMedici;


    public PazienteEntity(String nome, String cognome, String email, String contattoTelefonico, String codiceFiscale, String indirizzo, String allergie, String storicoMalattie, String creatoDa) {
        super(nome, cognome, email, contattoTelefonico, creatoDa);
        this.codiceFiscale = codiceFiscale;
        this.indirizzo = indirizzo;
        this.allergie = allergie;
        this.storicoMalattie = storicoMalattie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<AppuntamentoEntity> getListaAppuntamenti() {
        return listaAppuntamenti;
    }

    public void setListaAppuntamenti(List<AppuntamentoEntity> listaAppuntamenti) {
        this.listaAppuntamenti = listaAppuntamenti;
    }

    public List<MedicoEntity> getListaMedici() {
        return listaMedici;
    }

    public void setListaMedici(List<MedicoEntity> listaMedici) {
        this.listaMedici = listaMedici;
    }
}