package co.develhope.studioMedico.repositories;

import co.develhope.studioMedico.entites.Paziente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PazienteRepository extends JpaRepository<Paziente, Long> {
}
