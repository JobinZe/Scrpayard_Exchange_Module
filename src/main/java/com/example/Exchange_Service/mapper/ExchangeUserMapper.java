package com.example.Exchange_Service.mapper;
import com.example.Exchange_Service.dto.ExchangeUserDto;
import com.example.Exchange_Service.entity.Exchanger;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExchangeUserMapper {
  ExchangeUserDto toDto(Exchanger exchanger);
  Exchanger toEntity(ExchangeUserDto exchangeUserDto);
}
