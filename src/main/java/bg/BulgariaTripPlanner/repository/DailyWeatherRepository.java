package bg.BulgariaTripPlanner.repository;

import bg.BulgariaTripPlanner.model.DailyForecast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyWeatherRepository extends JpaRepository<DailyForecast, Long> {
    DailyForecast findTopByOrderByIdDesc();
}
