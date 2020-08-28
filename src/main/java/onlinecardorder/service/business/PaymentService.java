package onlinecardorder.service.business;

import onlinecardorder.dto.entity.RegisteredCardDto;
import onlinecardorder.dto.response.PaymentResponse;
import onlinecardorder.service.functional.CardOrderService;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private CardOrderService cardOrderService;

    public PaymentService(CardOrderService cardOrderService) {
        this.cardOrderService = cardOrderService;
    }
    public PaymentResponse makePayment(Long id,Double amount){
        RegisteredCardDto registeredCardDto = cardOrderService.makePayment(id,amount);
        return new PaymentResponse()
                .setId(registeredCardDto.getId())
                .setMessage("Paid");
    }
    public String checkUniCode(Long unicode){
        return cardOrderService.checkUniCode(unicode);
    }
}