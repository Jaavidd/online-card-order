package onlinecardorder.service.functional;

import onlinecardorder.dto.entity.RegisteredCardDto;
import onlinecardorder.dto.response.GetContractsResponse;
import onlinecardorder.entity.RegisteredCardEntity;
import onlinecardorder.helper.BusinessException;
import onlinecardorder.helper.BusinessStatus;
import onlinecardorder.mappers.RegisteredCardsMapper;
import onlinecardorder.repository.OnlineCardRegistrationRepository;
import onlinecardorder.util.FObjectUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;


@Service
public class CardOrderService {
    private OnlineCardRegistrationRepository onlineCardRegistrationRepository;


    public CardOrderService(OnlineCardRegistrationRepository onlineCardRegistrationRepository) {
        this.onlineCardRegistrationRepository = onlineCardRegistrationRepository;
    }

    public RegisteredCardDto registerCard(RegisteredCardDto registeredCardDto) {
        registeredCardDto.setId();
        return RegisteredCardsMapper.INSTANCE.toDto(onlineCardRegistrationRepository
                .save(RegisteredCardsMapper.INSTANCE.toEntity(registeredCardDto)));
    }

    public RegisteredCardDto makePayment(Long id,Double amountPaid) {
        RegisteredCardDto registeredCardDto = RegisteredCardsMapper.INSTANCE.toDto(onlineCardRegistrationRepository.getOne(id));
        FObjectUtils.ifNull(registeredCardDto).throwEx(BusinessStatus.ERROR_NO_SUCH_UNICODE);

        registeredCardDto.setBalance(registeredCardDto.getBalance() + amountPaid);

        if (registeredCardDto.getBalance().compareTo(registeredCardDto.getCardPrice()) >= 0) {
            registeredCardDto.setFullyPaid(true);
        }
        registeredCardDto.setPartiallyPaid(true);

        return RegisteredCardsMapper.INSTANCE.toDto(onlineCardRegistrationRepository
                .save(RegisteredCardsMapper.INSTANCE.toEntity(registeredCardDto)));

    }
    public GetContractsResponse getContracts(String status){
        ArrayList<RegisteredCardEntity> allContracts= onlineCardRegistrationRepository.findAll();
        HashMap<String,ArrayList<RegisteredCardDto>> map=new HashMap<>(){{
                put("not paid", new ArrayList<>());
                put("partially paid", new ArrayList<>());
                put("fully paid", new ArrayList<>());
            }};

        for(RegisteredCardEntity entity: allContracts){
            if(entity.isFullyPaid())
                map.get("fully paid").add(RegisteredCardsMapper.INSTANCE.toDto(entity));
            else if(entity.isPartiallyPaid())
                map.get("partially paid").add(RegisteredCardsMapper.INSTANCE.toDto(entity));
            else
                map.get("not paid").add(RegisteredCardsMapper.INSTANCE.toDto(entity));
        }

        return new GetContractsResponse().setAllContracts(map.get(status));
    }
    public String checkUniCode(Long unicode){
        Optional<RegisteredCardEntity> entity=onlineCardRegistrationRepository.findById(unicode);
        return entity.isEmpty() ? "unicode does not exist" : "unicode exist";
    }
}
