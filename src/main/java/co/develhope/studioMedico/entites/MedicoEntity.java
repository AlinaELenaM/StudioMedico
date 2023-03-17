package co.develhope.studioMedico.entites;

import co.develhope.studioMedico.enums.GiorniLavorativiEnum;

import javax.persistence.*;
import java.util.List;

@Table(name = "medico")
@Entity
public class MedicoEntity extends PersonaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_medico", nullable = false)
    private Long id;
    @Column(name = "specializzazione", nullable = false)
    private String specializzazione;
    @Column(name = "sede_lavoro", nullable = false)
    private String sedeLavoro;
    @Column(name = "giorni_lavorativi", nullable = false)
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = GiorniLavorativiEnum.class)
    @JoinTable(name = "giorni_lavorativi", joinColumns = @JoinColumn(name = "id_medico"))
    private List<GiorniLavorativiEnum> giorniLavorativi;

    @OneToMany(mappedBy = "medico")
    private List<AppuntamentoEntity> listaAppuntamenti;
    @ManyToMany(mappedBy = "listaMedici")
    private List<PazienteEntity> listaPazienti;
    @ManyToMany(mappedBy = "listaMedici")
    private List<SegretarioEntity> listaSegretari;


    public MedicoEntity(String nome, String cognome, String email, String contattoTelefonico, String specializzazione, String sedeLavoro, List<GiorniLavorativiEnum> giorniLavorativi, String creatoDa) {
        super(nome, cognome, email, contattoTelefonico, creatoDa);
        this.specializzazione = specializzazione;
        this.sedeLavoro = sedeLavoro;
        this.giorniLavorativi = giorniLavorativi;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecializzazione() {
        return specializzazione;
    }

    public void setSpecializzazione(String specializzazione) {
        this.specializzazione = specializzazione;
    }

    public String getSedeLavoro() {
        return sedeLavoro;
    }

    public void setSedeLavoro(String sedeLavoro) {
        this.sedeLavoro = sedeLavoro;
    }

    public List<GiorniLavorativiEnum> getGiorniLavorativi() {
        return giorniLavorativi;
    }

    public void setGiorniLavorativi(List<GiorniLavorativiEnum> giorniLavorativi) {
        this.giorniLavorativi = giorniLavorativi;
    }

    public List<AppuntamentoEntity> getListaAppuntamenti() {
        return listaAppuntamenti;
    }

    public void setListaAppuntamenti(List<AppuntamentoEntity> listaAppuntamenti) {
        this.listaAppuntamenti = listaAppuntamenti;
    }

    public List<PazienteEntity> getListaPazienti() {
        return listaPazienti;
    }

    public void setListaPazienti(List<PazienteEntity> listaPazienti) {
        this.listaPazienti = listaPazienti;
    }

    public List<SegretarioEntity> getListaSegretari() {
        return listaSegretari;
    }

    public void setListaSegretari(List<SegretarioEntity> listaSegretari) {
        this.listaSegretari = listaSegretari;
    }
}
