package bg.BulgariaTripPlanner.repository;

import bg.BulgariaTripPlanner.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String value);

    Optional<UserEntity> findByUsername(String value);

    Boolean existsByEmail(String email);
}
