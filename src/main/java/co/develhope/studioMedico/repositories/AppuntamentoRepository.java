package co.develhope.studioMedico.repositories;

import co.develhope.studioMedico.entites.Appuntamento;
import co.develhope.studioMedico.entites.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppuntamentoRepository extends JpaRepository<Appuntamento, Long> {
}
