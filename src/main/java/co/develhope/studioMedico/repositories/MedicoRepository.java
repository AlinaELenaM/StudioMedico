package co.develhope.studioMedico.repositories;

import co.develhope.studioMedico.entites.MedicoEntity;
import co.develhope.studioMedico.enums.StatusEnumeration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MedicoRepository extends CrudRepository<MedicoEntity, Long> {

    List<MedicoEntity> findByStato(StatusEnumeration statusEnumeration);


}
