package co.develhope.studioMedico.repositories;

import co.develhope.studioMedico.entites.PazienteEntity;
import co.develhope.studioMedico.entites.SegretarioEntity;
import co.develhope.studioMedico.enums.StatusEnumeration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PazienteRepository extends JpaRepository<PazienteEntity, Long> {

    List<PazienteEntity> findByStatus(StatusEnumeration statusEnumeration);

}
