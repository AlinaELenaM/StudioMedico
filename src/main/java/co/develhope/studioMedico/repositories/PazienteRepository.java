package co.develhope.studioMedico.repositories;


import co.develhope.studioMedico.entites.PazienteEntity;
import co.develhope.studioMedico.enums.StatusEnumeration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PazienteRepository extends CrudRepository<PazienteEntity, Long> {

    List<PazienteEntity> findByStato(StatusEnumeration statusEnumeration);

    Optional<PazienteEntity> findByIdAndStato(Long id, StatusEnumeration stato);


}
