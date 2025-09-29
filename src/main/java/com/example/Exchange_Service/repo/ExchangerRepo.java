package com.example.Exchange_Service.repo;

import com.example.Exchange_Service.dto.ExchangeUserDto;
import com.example.Exchange_Service.entity.Exchanger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ExchangerRepo extends JpaRepository<Exchanger,Integer> {
//    @Query(value ="SELECT CASE WHEN COUNT(*) > 0 THEN TRUE ELSE FALSE END " +
//            "FROM scrapexchange.exchange_item_owner WHERE email = :email",nativeQuery = true)
//    boolean findByEmail(@Param("email") String email);
boolean existsByEmail(String email);

@Query(value = "SELECT * FROM scrapexchange.exchange_item_owner WHERE email = :email",nativeQuery = true)
Exchanger fetchExchangeUserDetail(@Param("email") String email);
@Query(value = "SELECT owner_id as ownerId,email,city,pincode,owner_name FROM scrapexchange.exchange_item_owner WHERE email = :email", nativeQuery = true)
ExchangeUserDto fetchExchangeUserInfo(@Param("email") String email);
}
