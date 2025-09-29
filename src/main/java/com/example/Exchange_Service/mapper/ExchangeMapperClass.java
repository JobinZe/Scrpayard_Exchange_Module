package com.example.Exchange_Service.mapper;

import com.example.Exchange_Service.dto.ExchangeUserDto;
import com.example.Exchange_Service.dto.MultipleExchangeDto;
import com.example.Exchange_Service.entity.Exchange;

public class ExchangeMapperClass implements ExchangeMapper{
    @Override
    public Exchange toEntity(MultipleExchangeDto dto) {
        if(dto == null){
            return null;
        }
        Exchange exchange = new Exchange();
        exchange.setItem_image(dto.getItem_image());
        exchange.setCategory(dto.getCategory());
        exchange.setPrice(dto.getPrice());
        exchange.setNotes(dto.getNotes());
        exchange.setItem_wanted(dto.getItem_name());
        exchange.setItem_condition(dto.getItem_condition());
        exchange.setItem_wanted(dto.getItem_wanted());
        exchange.setPosted_on(dto.getPosted_on());
        return exchange;
    }

    @Override
    public MultipleExchangeDto toDto(Exchange entity) {
        if(entity == null) {
            return null;
        }
        MultipleExchangeDto multipleExchangeDto = new MultipleExchangeDto();
        multipleExchangeDto.setItem_image(entity.getItem_image());
        multipleExchangeDto.setCategory(entity.getCategory());
        multipleExchangeDto.setPrice(entity.getPrice());
        multipleExchangeDto.setNotes(entity.getNotes());
        multipleExchangeDto.setItem_wanted(entity.getItem_name());
        multipleExchangeDto.setItem_condition(entity.getItem_condition());
        multipleExchangeDto.setItem_wanted(entity.getItem_wanted());
        multipleExchangeDto.setPosted_on(entity.getPosted_on());
        return multipleExchangeDto;
    }
}
