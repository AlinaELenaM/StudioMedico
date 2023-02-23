package co.develhope.studioMedico.repositories;

import co.develhope.studioMedico.entites.Paziente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PazienteRepository extends JpaRepository<Paziente, Long> {
}
