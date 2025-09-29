package com.example.Exchange_Service.mapper;

import com.example.Exchange_Service.dto.ExchangeDto;
import com.example.Exchange_Service.entity.Exchange;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring", uses = {ExchangeUserMapper.class})
public interface SingleExchange {
    ExchangeDto toDto(Exchange exchange);
    Exchange toEntity(ExchangeDto dto);

}
