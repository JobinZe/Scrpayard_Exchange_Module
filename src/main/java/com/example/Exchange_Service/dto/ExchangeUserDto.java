package com.example.Exchange_Service.dto;

public class ExchangeUserDto {
    public Integer ownerId;
    public String email;
    public String city;
    public Integer pincode;
    public String owner_name;

    public ExchangeUserDto() {
    }

    public ExchangeUserDto(Integer ownerId, String email, String city, Integer pincode, String owner_name) {
        this.ownerId = ownerId;
        this.email = email;
        this.city = city;
        this.pincode = pincode;
        this.owner_name = owner_name;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
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

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }
}
