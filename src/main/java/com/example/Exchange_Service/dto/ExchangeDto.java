package com.example.Exchange_Service.dto;

import com.example.Exchange_Service.entity.Exchanger;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;

public class ExchangeDto {
    public Integer item_id;
    public String item_name;
    public Integer category;
    public Integer item_condition;
    public LocalDateTime posted_on;
    public String item_image;
    public String item_wanted;
    public String notes;
    public Integer price;
    private ExchangeUserDto exchangeUser;

    public ExchangeDto() {
    }

    public ExchangeDto(Integer item_id, String item_name, Integer category,
                       LocalDateTime posted_on, Integer item_condition, String item_image, String item_wanted,
                       String notes, Integer price, ExchangeUserDto exchangeUser) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.category = category;
        this.posted_on = posted_on;
        this.item_condition = item_condition;
        this.item_image = item_image;
        this.item_wanted = item_wanted;
        this.notes = notes;
        this.price = price;
        this.exchangeUser = exchangeUser;
    }

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public ExchangeUserDto getExchangeUser() {
        return exchangeUser;
    }

    public void setExchangeUser(ExchangeUserDto exchangeUser) {
        this.exchangeUser = exchangeUser;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getItem_wanted() {
        return item_wanted;
    }

    public void setItem_wanted(String item_wanted) {
        this.item_wanted = item_wanted;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getItem_image() {
        return item_image;
    }

    public void setItem_image(String item_image) {
        this.item_image = item_image;
    }

    public Integer getItem_condition() {
        return item_condition;
    }

    public void setItem_condition(Integer item_condition) {
        this.item_condition = item_condition;
    }

    public LocalDateTime getPosted_on() {
        return posted_on;
    }

    public void setPosted_on(LocalDateTime posted_on) {
        this.posted_on = posted_on;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }
}
