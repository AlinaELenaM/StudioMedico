package co.develhope.studioMedico.services;

import co.develhope.studioMedico.entites.AppuntamentoEntity;
import co.develhope.studioMedico.enums.StatusEnumeration;
import co.develhope.studioMedico.repositories.AppuntamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class AppuntamentoService {

    @Autowired
    private AppuntamentoRepository appuntamentoRepository;

    public AppuntamentoEntity creaAppuntamento(AppuntamentoEntity appuntamentoEntity){
        appuntamentoEntity.setStatus(StatusEnumeration.A);
        return appuntamentoRepository.saveAndFlush(appuntamentoEntity);
    }

    public AppuntamentoEntity readOne(Long id) throws Exception {
        if (appuntamentoRepository.getReferenceById(id) == null){
            throw new Exception("Questo appuntamento non esiste nel database");}
        AppuntamentoEntity appuntamentoEntity = appuntamentoRepository.getById(id);
        if(appuntamentoEntity.getStatus() == StatusEnumeration.D) throw new Exception("Errore: l'appuntamento è disattivo!");
        if(!appuntamentoRepository.existsById(id)) throw new EntityNotFoundException("Appuntamento non trovato");
        return appuntamentoEntity;
    }

    public List<AppuntamentoEntity> readAll(){
        return appuntamentoRepository.findByStatus(StatusEnumeration.A);
    }

    public AppuntamentoEntity modificaAppuntamento(AppuntamentoEntity appuntamentoEntity, Long id) {
        if(!appuntamentoRepository.existsById(id)) {
            throw new EntityNotFoundException("Lìappuntamento non esiste");
        }
        AppuntamentoEntity appuntamento = appuntamentoRepository.findById(id).get();

        if(appuntamentoEntity.getOrarioAppuntamento() != null) {
            appuntamento.setOrarioAppuntamento(appuntamentoEntity.getOrarioAppuntamento());
        }
        if(appuntamentoEntity.getNoteAppuntamento() != null) {
            appuntamento.setNoteAppuntamento(appuntamentoEntity.getNoteAppuntamento());
        }
        if(appuntamentoEntity.getStatus() != null) {
            appuntamento.setStatus(appuntamentoEntity.getStatus());
        }
        if(appuntamentoEntity.getStatoAppuntamento() != null) {
            appuntamento.setStatoAppuntamento(appuntamentoEntity.getStatoAppuntamento());
        }
        return appuntamentoRepository.saveAndFlush(appuntamento);
    }

    public String cancellaAppuntaemnto(Long id , HttpServletResponse response){
        if(appuntamentoRepository.existsById(id)){
            AppuntamentoEntity appuntamentoEntity = appuntamentoRepository.getById(id);
            appuntamentoEntity.setStatus(StatusEnumeration.D);
            appuntamentoRepository.save(appuntamentoEntity);
        } else {
            response.setStatus(409);
            return "Errore: l'id selezionato non esiste";
        }
        return "L'appuntamento è stato disattivato";
    }

    public String riattivaAppuntamento(Long id , HttpServletResponse response){
        if(appuntamentoRepository.existsById(id)){
            AppuntamentoEntity appuntamentoEntity = appuntamentoRepository.getById(id);
            appuntamentoEntity.setStatus(StatusEnumeration.A);
            appuntamentoRepository.save(appuntamentoEntity);
        } else {
            response.setStatus(409);
            return "Errore: l'id selezionato non esiste";
        }
        return "L'appuntamento è stato riattivato";
    }



}
