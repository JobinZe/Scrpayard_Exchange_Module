package com.example.Exchange_Service.services;
import com.example.Exchange_Service.dto.ExchangeUserDto;
import com.example.Exchange_Service.entity.Exchanger;
import com.example.Exchange_Service.repo.ExchangerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    ExchangerRepo exchangerRepo;
    public boolean checkEmailExist(String email){
        if(email!=null && !email.isEmpty()){
            return exchangerRepo.existsByEmail(email);
        }
        return false;
    }
    public ExchangeUserDto exchangeUser(String email){
        try {
            if (email != null && !email.isEmpty()) {
                return exchangerRepo.fetchExchangeUserInfo(email);
            }
            else{
                throw new IllegalArgumentException("Email must not be empty");
            }
        }
        catch (DataAccessException dae) {
            // Handles database access errors
            dae.printStackTrace(); // log the full stack trace
            throw new RuntimeException("Database error occurred while fetching user details", dae.getCause());
        }
    }

}
