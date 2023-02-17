package co.develhope.studioMedico.entites;

import javax.persistence.*;

@Table
@Entity
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_medico")
    private long idMedico;
    @Column(name = "nome_medico" , nullable = false)
    private String nomeMedico;
    @Column(name = "cognome_medico" , nullable = false)

    private String cognomeMedico;
    @Column(name = "specializzazione" , nullable = false)

    private String specializzazione;
    @Column(name = "email_medico" , nullable = false , unique = true)

    private String emailMedico;
    @Column(name = "contatto_ufficio_medico" , nullable = false)
    private String contattoUfficioMedico;
    @Column(name = "sede_di_lavoro" , nullable = false)
    private String sedeDiLavoro;

    public Medico(long idMedico, String nomeMedico, String cognomeMedico, String specializzazione, String emailMedico, String contattoUfficioMedico, String sedeDiLavoro) {
        this.idMedico = idMedico;
        this.nomeMedico = nomeMedico;
        this.cognomeMedico = cognomeMedico;
        this.specializzazione = specializzazione;
        this.emailMedico = emailMedico;
        this.contattoUfficioMedico = contattoUfficioMedico;
        this.sedeDiLavoro = sedeDiLavoro;
    }

    public Medico(){}

    public long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(long idMedico) {
        this.idMedico = idMedico;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public String getCognomeMedico() {
        return cognomeMedico;
    }

    public void setCognomeMedico(String cognomeMedico) {
        this.cognomeMedico = cognomeMedico;
    }

    public String getSpecializzazione() {
        return specializzazione;
    }

    public void setSpecializzazione(String specializzazione) {
        this.specializzazione = specializzazione;
    }

    public String getEmailMedico() {
        return emailMedico;
    }

    public void setEmailMedico(String emailMedico) {
        this.emailMedico = emailMedico;
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
