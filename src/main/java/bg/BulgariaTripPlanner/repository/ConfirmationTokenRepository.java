package bg.BulgariaTripPlanner.repository;

import bg.BulgariaTripPlanner.model.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long> {
    ConfirmationToken findByConfirmationToken(String confirmationToken);

    Optional<ConfirmationToken> findByUserId(Long id);
}
