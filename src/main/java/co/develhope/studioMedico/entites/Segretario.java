package co.develhope.studioMedico.entites;

import javax.persistence.*;

@Entity
@Table(name = "segretario")
public class Segretario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome_medico" , nullable = false)
    private String nomeSegretario;

    @Column(name = "cognome_medico" , nullable = false)
    private String specializzazione;

    @Column(name = "email_medico" , nullable = false , unique = true)
    private String emailSegretario;

    @Column(name = "contatto_ufficio_medico" , nullable = false)
    private String contattoUfficioMedico;

    @Column(name = "sede_di_lavoro" , nullable = false)
    private String sedeDiLavoro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeSegretario() {
        return nomeSegretario;
    }

    public void setNomeSegretario(String nomeSegretario) {
        this.nomeSegretario = nomeSegretario;
    }

    public String getSpecializzazione() {
        return specializzazione;
    }

    public void setSpecializzazione(String specializzazione) {
        this.specializzazione = specializzazione;
    }

    public String getEmailSegretario() {
        return emailSegretario;
    }

    public void setEmailSegretario(String emailSegretario) {
        this.emailSegretario = emailSegretario;
    }

    public String getContattoUfficioMedico() {
        return contattoUfficioMedico;
    }

    public void setContattoUfficioMedico(String contattoUfficioMedico) {
        this.contattoUfficioMedico = contattoUfficioMedico;
    }

    public String getSedeDiLavoro() {
        return sedeDiLavoro;
    }

    public void setSedeDiLavoro(String sedeDiLavoro) {
        this.sedeDiLavoro = sedeDiLavoro;
    }
}
