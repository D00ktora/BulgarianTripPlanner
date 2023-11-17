package bg.BulgariaTripPlanner.repository;

import bg.BulgariaTripPlanner.model.Motorcycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorcycleRepository extends JpaRepository<Motorcycle, Long> {
    Motorcycle findByProducerAndModel(String producer, String model);
}
