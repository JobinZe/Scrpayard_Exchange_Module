package com.example.Exchange_Service.mapper;

import com.example.Exchange_Service.dto.ExchangeUserDto;
import com.example.Exchange_Service.dto.MultipleExchangeDto;
import com.example.Exchange_Service.entity.Exchange;
import com.example.Exchange_Service.entity.Exchanger;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ExchangeMapper {
    // Map DTO -> Entity
    ExchangeMapper INSTANCE = Mappers.getMapper(ExchangeMapper.class);

    Exchange toEntity(MultipleExchangeDto dto);
    // Map Entity -> DTO

    MultipleExchangeDto toDto(Exchange entity);


}
