package co.develhope.studioMedico.controllers;

import co.develhope.studioMedico.entites.MedicoEntity;
import co.develhope.studioMedico.repositories.MedicoRepository;
import co.develhope.studioMedico.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medico")
public class MedicoController {
    @Autowired
    private MedicoService medicoService;
    @Autowired
    private MedicoRepository medicoRepository;

    //TODO : manca visualizzaSchedaPaziente, visualizzaAppuntamenti, cancellaAppuntamento


    @PostMapping("/crea")
    public MedicoEntity crea(@RequestBody MedicoEntity medicoEntity){
        return medicoService.creaMedico(medicoEntity);
    }

    @GetMapping("/lista_medici")
    public List<MedicoEntity> listaMedici(){
        return medicoService.readAll();
    }

    @GetMapping("/{id}")
    public MedicoEntity singoloMedico(@PathVariable Long id) throws Exception {
        return (MedicoEntity) medicoService.readOne(id);
    }



    @DeleteMapping("/elimina/{id}")
    public String delete(@PathVariable Long id , HttpServletResponse response){
        return medicoService.cancellaMedico(id , response);
    }

    @PutMapping("/riattiva_medico/{id}")
    public String riattiva(@PathVariable Long id , HttpServletResponse response){
        return medicoService.riattivaMedico(id , response);
    }

}
