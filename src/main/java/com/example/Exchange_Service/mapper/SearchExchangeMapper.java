package com.example.Exchange_Service.mapper;

import com.example.Exchange_Service.dto.SearchExchangeRequestDto;
import com.example.Exchange_Service.dto.SearchExchangeResponseDTO;
import com.example.Exchange_Service.entity.SearchExchange;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SearchExchangeMapper {
    SearchExchangeResponseDTO toDto(SearchExchange exchange);
}
