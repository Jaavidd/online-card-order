package onlinecardorder.service.functional;

import onlinecardorder.dto.entity.RegisteredCardDto;
import onlinecardorder.mappers.RegisteredCardsMapper;
import onlinecardorder.repository.OnlineCardRegistrationRepository;
import org.springframework.stereotype.Service;

@Service
public class CardOrderService {
    private OnlineCardRegistrationRepository onlineCardRegistrationRepository;

    public CardOrderService(OnlineCardRegistrationRepository onlineCardRegistrationRepository) {
        this.onlineCardRegistrationRepository = onlineCardRegistrationRepository;
    }

    public RegisteredCardDto registerCard(RegisteredCardDto registeredCardDto) {
        return RegisteredCardsMapper.INSTANCE.toDto(onlineCardRegistrationRepository
                .save(RegisteredCardsMapper.INSTANCE.toEntity(registeredCardDto)));
    }

//    public void makePayment()
}
