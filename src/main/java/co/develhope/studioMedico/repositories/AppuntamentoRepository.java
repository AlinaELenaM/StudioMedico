package co.develhope.studioMedico.repositories;

import co.develhope.studioMedico.entites.AppuntamentoEntity;
import co.develhope.studioMedico.enums.StatoAppuntamentoEnum;
import co.develhope.studioMedico.enums.StatusEnumeration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppuntamentoRepository extends CrudRepository<AppuntamentoEntity, Long> {

    List<AppuntamentoEntity> findByStato(StatusEnumeration stato);

    Optional<AppuntamentoEntity> findByIdAndStato(Long id, StatusEnumeration stato);

    List<AppuntamentoEntity> findByStatoAndStatoAppuntamento(StatusEnumeration stato, StatoAppuntamentoEnum statoAppuntamentoEnum);

    Optional<AppuntamentoEntity> findByIdAndStatoAndStatoAppuntamento(Long id, StatusEnumeration stato, StatoAppuntamentoEnum statoAppuntamentoEnum);

    Optional<AppuntamentoEntity> findByIdAndStatoAndPaziente_Id(Long id, StatusEnumeration stato, Long pazienteId);

    Optional<AppuntamentoEntity> findByIdAndStatoAndMedico_Id(Long id, StatusEnumeration stato, Long medicoId);

}
