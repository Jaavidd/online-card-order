package onlinecardorder.service.business;

import onlinecardorder.dto.entity.RegisteredCardDto;
import onlinecardorder.dto.request.RegistrationRequest;
import onlinecardorder.dto.response.RegistrationResponse;
import onlinecardorder.service.functional.CardOrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderRegistrationService {
    private CardOrderService cardOrderService;

    public OrderRegistrationService(CardOrderService cardOrderService) {
        this.cardOrderService = cardOrderService;
    }

    public RegistrationResponse registerCard(RegistrationRequest request){
            RegisteredCardDto dto=new RegisteredCardDto()
                    .setFirstName(request.getFirstName())
                    .setLastName(request.getLastName())
                    .setFatherName(request.getFatherName())
                    .setBirthday(request.getBirthday())
                    .setCardType(request.getCardType())
                    .setCurrency(request.getCurrency())
                    .setUrl(request.getUrl())
                    .setPhoneNumber(request.getPhoneNumber())
                    .setBalance(0.0)
                    .setCardPrice(100.0);

            RegisteredCardDto savedDto=cardOrderService.registerCard(dto);
            return new RegistrationResponse().setFirstName(savedDto.getFirstName())
                                             .setLastName(savedDto.getLastName())
                                              .setId(savedDto.getId());
    }


}
