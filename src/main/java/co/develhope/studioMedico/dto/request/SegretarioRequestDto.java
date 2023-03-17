package co.develhope.studioMedico.dto.request;


import javax.validation.constraints.NotNull;
import java.util.List;

public class SegretarioRequestDto extends AbstractPersonaRequestDto {

    @NotNull
    private String sedeLavoro;
    private List<Long> listaIdMedici;

    public String getSedeLavoro() {
        return sedeLavoro;
    }

    public void setSedeLavoro(String sedeLavoro) {
        this.sedeLavoro = sedeLavoro;
    }

    public List<Long> getListaIdMedici() {
        return listaIdMedici;
    }

    public void setListaIdMedici(List<Long> listaIdMedici) {
        this.listaIdMedici = listaIdMedici;
    }
}
