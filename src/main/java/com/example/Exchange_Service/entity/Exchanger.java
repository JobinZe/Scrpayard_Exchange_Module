package com.example.Exchange_Service.entity;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="exchange_item_owner")
public class Exchanger {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer owner_id;
    @NotNull
    private String email;
    @NotNull
    private String city;
    @NotNull
    private String pincode;
    @OneToMany(mappedBy = "exchangeUser",cascade = CascadeType.ALL)
    public List<Exchange> exchanges = new ArrayList<>();
    public Exchanger(Integer owner_id, String email, String city, String pincode) {
        this.owner_id = owner_id;
        this.email = email;
        this.city = city;
        this.pincode = pincode;
    }

    public Integer getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Integer owner_id) {
        this.owner_id = owner_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
