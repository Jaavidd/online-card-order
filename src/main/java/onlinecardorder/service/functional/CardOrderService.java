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

import java.lang.reflect.Array;
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
    public GetContractsResponse getAllContracts(){
        ArrayList<RegisteredCardEntity> allContracts= onlineCardRegistrationRepository.findAll();
        ArrayList<RegisteredCardDto> dto=new ArrayList<>();
        allContracts.forEach(contract -> dto.add(RegisteredCardsMapper.INSTANCE.toDto(contract)));
        return new GetContractsResponse().setAllContracts(dto);
    }

    public GetContractsResponse getFullyContracts() {
        ArrayList<RegisteredCardEntity> allContracts = onlineCardRegistrationRepository.findAll();
        ArrayList<RegisteredCardDto> dto = new ArrayList<>();

        for (RegisteredCardEntity entity : allContracts) {
            if (entity.isFullyPaid())
                dto.add(RegisteredCardsMapper.INSTANCE.toDto(entity));
        }
        return new GetContractsResponse().setAllContracts(dto);
    }


    public GetContractsResponse getPartiallyContracts() {
        ArrayList<RegisteredCardEntity> allContracts = onlineCardRegistrationRepository.findAll();
        ArrayList<RegisteredCardDto> dto = new ArrayList<>();

        for (RegisteredCardEntity entity : allContracts) {
            if (entity.isPartiallyPaid())
                dto.add(RegisteredCardsMapper.INSTANCE.toDto(entity));
        }
        return new GetContractsResponse().setAllContracts(dto);
    }

    public String checkUniCode(Long unicode){
        Optional<RegisteredCardEntity> entity=onlineCardRegistrationRepository.findById(unicode);
        return entity.isEmpty() ? "unicode does not exist" : "unicode exist";
    }
}
