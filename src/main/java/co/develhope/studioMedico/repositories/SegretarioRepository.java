package co.develhope.studioMedico.repositories;

import co.develhope.studioMedico.entites.SegretarioEntity;
import co.develhope.studioMedico.enums.StatusEnumeration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SegretarioRepository extends JpaRepository<SegretarioEntity, Long> {

    List<SegretarioEntity> findByStatus(StatusEnumeration statusEnumeration);

}

