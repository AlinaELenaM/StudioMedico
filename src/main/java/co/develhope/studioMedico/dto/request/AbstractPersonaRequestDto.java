package co.develhope.studioMedico.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public abstract class AbstractPersonaRequestDto {
    @NotNull
    private String nome;
    @NotNull
    private String cognome;
    @NotNull
    @Email
    private String email;
    @NotNull
    private String contattoTelefonico;

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
}
