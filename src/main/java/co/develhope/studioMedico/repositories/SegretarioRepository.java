package co.develhope.studioMedico.repositories;

import co.develhope.studioMedico.entites.SegretarioEntity;
import co.develhope.studioMedico.enums.StatusEnumeration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SegretarioRepository extends CrudRepository<SegretarioEntity, Long> {

    List<SegretarioEntity> findByStato(StatusEnumeration statusEnumeration);

    Optional<SegretarioEntity> findByIdAndStato(Long id, StatusEnumeration stato);
}

