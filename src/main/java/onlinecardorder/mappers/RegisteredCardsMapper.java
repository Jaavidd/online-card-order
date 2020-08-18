package onlinecardorder.mappers;

import onlinecardorder.dto.entity.RegisteredCardDto;
import onlinecardorder.entity.RegisteredCardEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface RegisteredCardsMapper {
        RegisteredCardsMapper INSTANCE= Mappers.getMapper(RegisteredCardsMapper.class);

        RegisteredCardEntity toEntity(RegisteredCardDto dto);
        RegisteredCardDto toDto(RegisteredCardEntity entity);
}
