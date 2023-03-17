package co.develhope.studioMedico.dto.response.paziente;

import co.develhope.studioMedico.dto.response.appuntamento.AppuntamentoMinimalNoPazienteResponseDto;
import co.develhope.studioMedico.dto.response.medico.MedicoMinimalResponseDto;

import java.util.List;

public class PazienteResponseDto {
    private Long id;
    private String nome;
    private String cognome;
    private String email;
    private String contattoTelefonico;
    private String codiceFiscale;
    private String indirizzo;
    private String allergie;
    private String storicoMalattie;
    private List<AppuntamentoMinimalNoPazienteResponseDto> listaAppuntamenti;
    private List<MedicoMinimalResponseDto> listaMedici;

    public PazienteResponseDto(Long id, String nome, String cognome, String email, String contattoTelefonico, String codiceFiscale, String indirizzo, String allergie, String storicoMalattie, List<AppuntamentoMinimalNoPazienteResponseDto> listaAppuntamenti, List<MedicoMinimalResponseDto> listaMedici) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.contattoTelefonico = contattoTelefonico;
        this.codiceFiscale = codiceFiscale;
        this.indirizzo = indirizzo;
        this.allergie = allergie;
        this.storicoMalattie = storicoMalattie;
        this.listaAppuntamenti = listaAppuntamenti;
        this.listaMedici = listaMedici;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContattoTelefonico() {
        return contattoTelefonico;
    }

    public void setContattoTelefonico(String contattoTelefonico) {
        this.contattoTelefonico = contattoTelefonico;
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

    public List<AppuntamentoMinimalNoPazienteResponseDto> getListaAppuntamenti() {
        return listaAppuntamenti;
    }

    public void setListaAppuntamenti(List<AppuntamentoMinimalNoPazienteResponseDto> listaAppuntamenti) {
        this.listaAppuntamenti = listaAppuntamenti;
    }

    public List<MedicoMinimalResponseDto> getListaMedici() {
        return listaMedici;
    }

    public void setListaMedici(List<MedicoMinimalResponseDto> listaMedici) {
        this.listaMedici = listaMedici;
    }
}
