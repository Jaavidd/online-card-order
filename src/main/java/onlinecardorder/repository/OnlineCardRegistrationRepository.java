package onlinecardorder.repository;

import onlinecardorder.entity.RegisteredCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public interface OnlineCardRegistrationRepository extends JpaRepository<RegisteredCardEntity, Long> {
            ArrayList<RegisteredCardEntity> findAll();
}
