package co.develhope.studioMedico.repositories;

import co.develhope.studioMedico.entites.AppuntamentoEntity;
import co.develhope.studioMedico.enums.StatusEnumeration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppuntamentoRepository extends CrudRepository<AppuntamentoEntity, Long> {

    List<AppuntamentoEntity> findByStato(StatusEnumeration stato);

    Optional<AppuntamentoEntity> findByIdAppuntamentoAndStato(Long id, StatusEnumeration stato);

}
