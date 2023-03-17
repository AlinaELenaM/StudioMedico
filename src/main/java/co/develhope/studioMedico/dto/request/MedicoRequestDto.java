package co.develhope.studioMedico.dto.request;

import co.develhope.studioMedico.enums.GiorniLavorativiEnum;

import javax.validation.constraints.NotNull;
import java.util.List;

public class MedicoRequestDto extends AbstractPersonaRequestDto {
    @NotNull
    private String specializzazione;
    @NotNull
    private String sedeLavoro;
    @NotNull
    private List<GiorniLavorativiEnum> giorniLavorativi;
    private List<Long> listaIdPazienti;
    private List<Long> listaIdSegretari;

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

    public List<Long> getListaIdPazienti() {
        return listaIdPazienti;
    }

    public void setListaIdPazienti(List<Long> listaIdPazienti) {
        this.listaIdPazienti = listaIdPazienti;
    }

    public List<Long> getListaIdSegretari() {
        return listaIdSegretari;
    }

    public void setListaIdSegretari(List<Long> listaIdSegretari) {
        this.listaIdSegretari = listaIdSegretari;
    }
}
