package com.example.Exchange_Service.dto;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class MultipleExchangeDto {
    public Integer item_id;
    public String item_name;
    public Integer category;
    public Integer item_condition;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime posted_on;
    public String item_image;
    public String item_wanted;
    public String notes;
    public Integer price;

    public MultipleExchangeDto(Integer item_id, String item_name,
                               Integer category, Integer item_condition, LocalDateTime posted_on,
                               String item_image, String item_wanted, String notes, Integer price) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.category = category;
        this.item_condition = item_condition;
        this.posted_on = posted_on;
        this.item_image = item_image;
        this.item_wanted = item_wanted;
        this.notes = notes;
        this.price = price;
    }

    public MultipleExchangeDto() {
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

    public Integer getItem_condition() {
        return item_condition;
    }

    public void setItem_condition(Integer item_condition) {
        this.item_condition = item_condition;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }
    public LocalDateTime getPosted_on() {
        return posted_on;
    }

    public void setPosted_on(LocalDateTime posted_on) {
        this.posted_on = posted_on;
    }

    public String getItem_image() {
        return item_image;
    }

    public void setItem_image(String item_image) {
        this.item_image = item_image;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
