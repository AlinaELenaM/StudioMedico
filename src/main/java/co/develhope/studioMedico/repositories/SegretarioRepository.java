package co.develhope.studioMedico.repositories;

import co.develhope.studioMedico.entites.Segretario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SegretarioRepository extends JpaRepository<Segretario, Long> {
}

