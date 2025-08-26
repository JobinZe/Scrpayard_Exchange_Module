package com.example.Exchange_Service.services;
import com.example.Exchange_Service.entity.Exchange;
import com.example.Exchange_Service.entity.Exchanger;
import com.example.Exchange_Service.repo.ExchangeRepo;
import com.example.Exchange_Service.repo.ExchangerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeService {
    @Autowired
    private ExchangeRepo exchangeRepo;
    @Autowired
    private ExchangerRepo exchangerRepo;

    public Exchange addExchangeItem(Exchange exchangeValue){
        Exchanger exchanger = exchangeValue.getExchangeUser();
        if(exchanger.getOwner_id()!=null) {
           exchanger = exchangerRepo.findById(exchanger.getOwner_id())
                    .orElseThrow(()->new RuntimeException("User not found"));
        }
        else{
            exchanger = exchangerRepo.save(exchanger);
        }
        exchangeValue.setExchangeUser(exchanger);
       return exchangeRepo.save(exchangeValue);
    }
}
