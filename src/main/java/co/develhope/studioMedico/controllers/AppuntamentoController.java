package co.develhope.studioMedico.controllers;

import co.develhope.studioMedico.entites.Appuntamento;
import co.develhope.studioMedico.repositories.AppuntamentoRepository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/appuntamento")
public class AppuntamentoController {

    private final AppuntamentoRepository appuntamentoRepository;
    public AppuntamentoController(AppuntamentoRepository appuntamentoRepository) {
        this.appuntamentoRepository = appuntamentoRepository;
    }

    @PostMapping("/create")
    public Appuntamento createAppuntamento(@RequestBody Appuntamento appuntamento) {
        return appuntamentoRepository.save(appuntamento);
    }

    @GetMapping("/get-all")
    public List<Appuntamento> getAllAppuntamento() {
        return appuntamentoRepository.findAll();
    }

    @GetMapping("/get-one-by-id/{id}")
    public Appuntamento getOneById(@PathVariable Long id) {
      return appuntamentoRepository.existsById(id) ? appuntamentoRepository.getById(id) : new Appuntamento();
    }
    @PutMapping("/update/{id}")
    public Appuntamento updateAppuntamento(@PathVariable long id , @RequestBody Appuntamento appuntamento){
        appuntamento.setIdAppuntamento(id);
        return appuntamentoRepository.saveAndFlush(appuntamento);
    }

    @DeleteMapping("/delete-by-id/{id}")
    public void deleteAppuntamentoById(@PathVariable long id , HttpServletResponse response){
        if(appuntamentoRepository.existsById(id)){
            appuntamentoRepository.deleteById(id);
        }
        else
            response.setStatus(409);
    }


    @DeleteMapping("/delete-all")
    public void deleteAllAppuntamento(){
        appuntamentoRepository.deleteAll();
    }

}
