package co.develhope.studioMedico.dto.response.segretario;

import co.develhope.studioMedico.dto.response.medico.MedicoMinimalResponseDto;

import java.util.List;

public class SegretarioResponseDto {
    private Long id;
    private String nome;
    private String cognome;
    private String email;
    private String contattoTelefonico;
    private String sedeLavoro;
    private List<MedicoMinimalResponseDto> listaMinimalMedici;

    public SegretarioResponseDto(Long id, String nome, String cognome, String email, String contattoTelefonico, String sedeLavoro, List<MedicoMinimalResponseDto> listaMinimalMedici) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.contattoTelefonico = contattoTelefonico;
        this.sedeLavoro = sedeLavoro;
        this.listaMinimalMedici = listaMinimalMedici;
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

    public String getSedeLavoro() {
        return sedeLavoro;
    }

    public void setSedeLavoro(String sedeLavoro) {
        this.sedeLavoro = sedeLavoro;
    }

    public List<MedicoMinimalResponseDto> getListaMinimalMedici() {
        return listaMinimalMedici;
    }

    public void setListaMinimalMedici(List<MedicoMinimalResponseDto> listaMinimalMedici) {
        this.listaMinimalMedici = listaMinimalMedici;
    }
}
