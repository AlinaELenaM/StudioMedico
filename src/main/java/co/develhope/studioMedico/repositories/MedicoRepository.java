package co.develhope.studioMedico.repositories;

import co.develhope.studioMedico.entites.MedicoEntity;
import co.develhope.studioMedico.enums.StatusEnumeration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicoRepository extends JpaRepository <MedicoEntity, Long> {

   List<MedicoEntity> findByStatus(StatusEnumeration statusEnumeration);



}
