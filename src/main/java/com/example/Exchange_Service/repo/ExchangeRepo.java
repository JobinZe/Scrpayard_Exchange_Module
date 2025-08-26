package com.example.Exchange_Service.repo;

import com.example.Exchange_Service.entity.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRepo extends JpaRepository<Exchange, Integer> {

}
