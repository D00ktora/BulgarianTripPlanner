package bg.BulgariaTripPlanner.repository;

import bg.BulgariaTripPlanner.model.Transmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransmissionRepository extends JpaRepository<Transmission, Long> {
    Optional<Transmission> findByType(String transmission);
}
