package com.example.Exchange_Service.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="exchange_details")
public class SearchExchange {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
public Integer item_id;
@Column(name = "owner_name")
private String name;
private String email;
public String item_name;
public String item_condition;
public Integer category;
public Integer price;
public LocalDateTime posted_on;
public String item_image;

    public SearchExchange() {
    }
    public SearchExchange(Integer item_id, LocalDateTime posted_on,
                          Integer price, String item_name, Integer category,
                          String email, String name,String item_image, String item_condition) {
        this.item_id = item_id;
        this.posted_on = posted_on;
        this.price = price;
        this.item_name = item_name;
        this.category = category;
        this.email = email;
        this.name = name;
        this.item_image = item_image;
        this.item_condition = item_condition;
    }

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
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
    public String getItem_condition() {
        return item_condition;
    }

    public void setItem_condition(String item_condition) {
        this.item_condition = item_condition;
    }

    public String getItem_image() {
        return item_image;
    }

    public void setItem_image(String item_image) {
        this.item_image = item_image;
    }
}
