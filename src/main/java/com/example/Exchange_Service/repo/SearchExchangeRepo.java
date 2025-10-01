package com.example.Exchange_Service.repo;

import com.example.Exchange_Service.entity.SearchExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SearchExchangeRepo extends JpaRepository<SearchExchange,Integer>, JpaSpecificationExecutor<SearchExchange> {
}
