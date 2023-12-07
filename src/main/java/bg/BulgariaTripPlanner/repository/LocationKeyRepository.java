package bg.BulgariaTripPlanner.repository;

import bg.BulgariaTripPlanner.model.WeatherLocationKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationKeyRepository extends JpaRepository<WeatherLocationKey, Long> {
}
