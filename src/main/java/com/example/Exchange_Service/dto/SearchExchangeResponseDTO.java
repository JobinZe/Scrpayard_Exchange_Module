package com.example.Exchange_Service.dto;

import java.time.LocalDateTime;

public class SearchExchangeResponseDTO {
    public Integer item_id;
    public String item_name;
    public Integer category;
    public Integer price;
    public LocalDateTime posted_on;
    public String item_image;
    public String item_condition;

    public SearchExchangeResponseDTO() {
    }

    public SearchExchangeResponseDTO(Integer item_id, String item_name,
                             LocalDateTime posted_on, Integer price, Integer category,
                             String item_image, String item_condition) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.posted_on = posted_on;
        this.price = price;
        this.category = category;
        this.item_image = item_image;
        this.item_condition = item_condition;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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

    public String getItem_condition() {
        return item_condition;
    }

    public void setItem_condition(String item_condition) {
        this.item_condition = item_condition;
    }
}
