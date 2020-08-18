package onlinecardorder.repository;

import onlinecardorder.entity.RegisteredCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OnlineCardRegistrationRepository extends JpaRepository<RegisteredCardEntity, Long> {

}
