package com.example.Exchange_Service.dto;

import java.time.LocalDateTime;

public class SearchExchangeRequestDto {
    private String name;
    private String email;
    public String item_name;
    public Integer category;
    public Integer price;
    public LocalDateTime posted_on;
    public Integer pageSize;
    public Integer pageNo;


    public SearchExchangeRequestDto() {
    }

    public SearchExchangeRequestDto(Integer item_id, String name,
                                    String email, String item_name, Integer category,
                                    Integer price, LocalDateTime posted_on,Integer pageNo,Integer pageSize) {
        this.name = name;
        this.email = email;
        this.item_name = item_name;
        this.category = category;
        this.price = price;
        this.posted_on = posted_on;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }
    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public LocalDateTime getPosted_on() {
        return posted_on;
    }

    public void setPosted_on(LocalDateTime posted_on) {
        this.posted_on = posted_on;
    }
}
