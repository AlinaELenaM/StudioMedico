package co.develhope.studioMedico.repositories;

import co.develhope.studioMedico.entites.AppuntamentoEntity;
import co.develhope.studioMedico.entites.MedicoEntity;
import co.develhope.studioMedico.enums.StatusEnumeration;
import co.develhope.studioMedico.services.AppuntamentoService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppuntamentoRepository extends JpaRepository<AppuntamentoEntity, Long> {

    List<AppuntamentoEntity> findByStatus(StatusEnumeration statusEnumeration);


}
