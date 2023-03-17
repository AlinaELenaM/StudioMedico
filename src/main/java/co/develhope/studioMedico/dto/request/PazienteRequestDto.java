package co.develhope.studioMedico.dto.request;

import javax.validation.constraints.NotNull;
import java.util.List;

public class PazienteRequestDto extends AbstractPersonaRequestDto {
    @NotNull
    private String codiceFiscale;
    @NotNull
    private String indirizzo;
    private String allergie;
    private String storicoMalattie;
    private List<Long> listaIdMedici;

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

    public List<Long> getListaIdMedici() {
        return listaIdMedici;
    }

    public void setListaIdMedici(List<Long> listaIdMedici) {
        this.listaIdMedici = listaIdMedici;
    }
}
