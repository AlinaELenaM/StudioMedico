package co.develhope.studioMedico.dto.response.medico;

import co.develhope.studioMedico.dto.response.appuntamento.AppuntamentoMinimalNoMedicoResponseDto;
import co.develhope.studioMedico.dto.response.paziente.PazienteMinimalResponseDto;
import co.develhope.studioMedico.dto.response.segretario.SegretarioMinimalResponseDto;
import co.develhope.studioMedico.enums.GiorniLavorativiEnum;

import java.util.List;

public class MedicoResponseDto {
    private Long id;
    private String nome;
    private String cognome;
    private String email;
    private String contattoTelefonico;
    private String specializzazione;
    private String sedeLavoro;
    private List<GiorniLavorativiEnum> giorniLavorativi;
    private List<PazienteMinimalResponseDto> listaMinimalPazienti;
    private List<SegretarioMinimalResponseDto> listaMinimalSegretari;
    private List<AppuntamentoMinimalNoMedicoResponseDto> listaMinimalAppuntamenti;

    public MedicoResponseDto(Long id, String nome, String cognome, String email, String contattoTelefonico, String specializzazione, String sedeLavoro, List<GiorniLavorativiEnum> giorniLavorativi, List<PazienteMinimalResponseDto> listaMinimalPazienti, List<SegretarioMinimalResponseDto> listaMinimalSegretari, List<AppuntamentoMinimalNoMedicoResponseDto> listaMinimalAppuntamenti) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.contattoTelefonico = contattoTelefonico;
        this.specializzazione = specializzazione;
        this.sedeLavoro = sedeLavoro;
        this.giorniLavorativi = giorniLavorativi;
        this.listaMinimalPazienti = listaMinimalPazienti;
        this.listaMinimalSegretari = listaMinimalSegretari;
        this.listaMinimalAppuntamenti = listaMinimalAppuntamenti;
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

    public List<PazienteMinimalResponseDto> getListaMinimalPazienti() {
        return listaMinimalPazienti;
    }

    public void setListaMinimalPazienti(List<PazienteMinimalResponseDto> listaMinimalPazienti) {
        this.listaMinimalPazienti = listaMinimalPazienti;
    }

    public List<SegretarioMinimalResponseDto> getListaMinimalSegretari() {
        return listaMinimalSegretari;
    }

    public void setListaMinimalSegretari(List<SegretarioMinimalResponseDto> listaMinimalSegretari) {
        this.listaMinimalSegretari = listaMinimalSegretari;
    }

    public List<AppuntamentoMinimalNoMedicoResponseDto> getListaMinimalAppuntamenti() {
        return listaMinimalAppuntamenti;
    }

    public void setListaMinimalAppuntamenti(List<AppuntamentoMinimalNoMedicoResponseDto> listaMinimalAppuntamenti) {
        this.listaMinimalAppuntamenti = listaMinimalAppuntamenti;
    }
}
