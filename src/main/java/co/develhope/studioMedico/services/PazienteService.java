package co.develhope.studioMedico.services;
import co.develhope.studioMedico.entites.MedicoEntity;
import co.develhope.studioMedico.entites.PazienteEntity;
import co.develhope.studioMedico.enums.StatusEnumeration;
import co.develhope.studioMedico.repositories.PazienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * La classe PazienteService realizza la logica di business relativamente le operazioni di CRUD dei dati di PazienteEntity.
 * Utilizza PazienteRepository (mediante dependency injection), i metodi del service verranno richiamati
 * nel relativo controller PazienteController
 */
@Service
public class PazienteService {

    @Autowired
    private PazienteRepository pazienteRepository;

    /**
     * Metodo che crea il paziente.
     * @param paziente il paziente
     */
    public PazienteEntity createPaziente(PazienteEntity paziente){
        paziente.setStatus(StatusEnumeration.A);
        return pazienteRepository.saveAndFlush(paziente);
    }

    /**
     * Metodo che restituisce il paziente tramite id.
     *
     * @param id the id
     * @return the paziente by id
     */
    public PazienteEntity getPazienteById(Long id) throws Exception {
        if (pazienteRepository.getReferenceById(id) == null){
            throw new Exception("Questo paziente non esiste nel database");}
        PazienteEntity pazienteEntity = pazienteRepository.getById(id);
        if(pazienteEntity.getStatus() == StatusEnumeration.D) throw new Exception("Errore: l'utente paziente è disattivo!");
        if(!pazienteRepository.existsById(id)) throw new EntityNotFoundException("Paziente non trovato");
        return pazienteEntity;
    }


    /**
     * Metodo che restituisce tutti i pazienti.
     * @return i pazienti
     */
    public List<PazienteEntity> tuttiPazienti(){
        return pazienteRepository.findByStatus(StatusEnumeration.A);
    }


    /**
     * questo metodo verifica l'esistenza "existsById" di un'entità Paziente nel database con un if,
     * se l'entità non esiste viene lanciata un'eccezione "EntityNotFoundException" con un messaggio.
     * Se l'entità "PazienteEntity" esiste, viene caricata dal database mediante la chiamata al metodo "findById" del repository.
     * Il metodo controlla se i vari attributi dell'oggetto "pazienteEdit" sono diversi da null,
     * e se lo sono, aggiorna l'attributo corrispondente dell'entità "paziente" con il valore dell'oggetto "pazienteEdit".
     * Dopo aver aggiornato tutti gli attributi necessari dell'entità "paziente", viene chiamato il metodo "saveAndFlush"
     * del repository per salvare l'entità aggiornata nel database.
     * Infine, il metodo restituisce l'entità "paziente" aggiornata
     */
    public PazienteEntity modificaPaziente(PazienteEntity pazienteEdit, Long id) {
        if(!pazienteRepository.existsById(id)) {
            throw new EntityNotFoundException("Il paziente non esiste");
        }
        PazienteEntity paziente = pazienteRepository.findById(id).get();

        if(pazienteEdit.getNome() != null) {
            paziente.setNome(pazienteEdit.getNome());
        }
        if(pazienteEdit.getCognome() != null) {
            paziente.setCognome(pazienteEdit.getCognome());
        }
        if(pazienteEdit.getEmail() != null) {
            paziente.setEmail(pazienteEdit.getEmail());
        }
        if(pazienteEdit.getNumeroTelefonico() != null) {
            paziente.setNumeroTelefonico(pazienteEdit.getNumeroTelefonico());
        }
        if(pazienteEdit.getCodiceFiscale() != null) {
            paziente.setCodiceFiscale(pazienteEdit.getCodiceFiscale());
        }
        if(pazienteEdit.getIndirizzo() != null) {
            paziente.setIndirizzo(pazienteEdit.getIndirizzo());
        }
        if(pazienteEdit.getAllergie() != null) {
            paziente.setAllergie(pazienteEdit.getAllergie());
        }
        if(pazienteEdit.getStoricoMalattie() != null) {
            paziente.setStoricoMalattie(pazienteEdit.getStoricoMalattie());
        }
        return pazienteRepository.saveAndFlush(paziente);
    }

    public String cancellaPaziente(Long id , HttpServletResponse response){
        if(pazienteRepository.existsById(id)){
            PazienteEntity pazienteEntity = pazienteRepository.getById(id);
            pazienteEntity.setStatus(StatusEnumeration.D);
            pazienteRepository.save(pazienteEntity);
        } else {
            response.setStatus(409);
            return "Errore: l'id selezionato non esiste";
        }
        return "L'utente paziente è stato disattivato";
    }

    public String riattivaPaziente(Long id , HttpServletResponse response){
        if(pazienteRepository.existsById(id)){
            PazienteEntity pazienteEntity = pazienteRepository.getById(id);
            pazienteEntity.setStatus(StatusEnumeration.A);
            pazienteRepository.save(pazienteEntity);
        } else {
            response.setStatus(409);
            return "Errore: l'id selezionato non esiste";
        }
        return "L'utente paziente è stato attivato";
    }


}
