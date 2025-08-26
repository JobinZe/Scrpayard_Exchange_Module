package com.example.Exchange_Service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.validation.annotation.Validated;


import java.time.LocalDateTime;

@Entity
@Table(name="exchange_details")
public class Exchange {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer item_id;
    @NotNull
    @Size(max=25)
    public String item_name;
    @NotNull
    public Integer category;
    @NotNull
    public Integer item_condition;
    @NotNull
    public LocalDateTime posted_on;
    @NotNull
    public String item_image;
    @NotNull
    public String item_wanted;
    public String notes;
    @ManyToOne
    @JoinColumn(name = "owner_id",nullable = false)
    private Exchanger exchangeUser;
    public Exchange(){

     }
    public Exchange(String item_name, Integer item_id, Integer item_condition, Integer category,
                    LocalDateTime posted_on, String item_image, String item_wanted, String notes,
                    Exchanger exchangeUser) {
        this.item_name = item_name;
        this.item_id = item_id;
        this.item_condition = item_condition;
        this.category = category;
        this.posted_on = posted_on;
        this.item_image = item_image;
        this.item_wanted = item_wanted;
        this.notes = notes;
        this.exchangeUser = exchangeUser;
    }


    public Exchanger getExchangeUser() {
        return exchangeUser;
    }

    public void setExchangeUser(Exchanger exchangeUser) {
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

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
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
}
