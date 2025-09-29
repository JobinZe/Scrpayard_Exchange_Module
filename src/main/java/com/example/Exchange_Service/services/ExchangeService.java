package com.example.Exchange_Service.services;
import com.example.Exchange_Service.dto.ExchangeDto;
import com.example.Exchange_Service.dto.ExchangeUserDto;
import com.example.Exchange_Service.dto.MultipleExchangeDto;
import com.example.Exchange_Service.entity.APIResponse;
import com.example.Exchange_Service.entity.Exchange;
import com.example.Exchange_Service.entity.Exchanger;
import com.example.Exchange_Service.mapper.ExchangeMapper;
import com.example.Exchange_Service.mapper.ExchangeUserMapper;
import com.example.Exchange_Service.mapper.SingleExchange;
import com.example.Exchange_Service.repo.ExchangeRepo;
import com.example.Exchange_Service.repo.ExchangerRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExchangeService {
    @Autowired
    private ExchangeRepo exchangeRepo;
    @Autowired
    private ExchangerRepo exchangerRepo;
    @Autowired
    private ExchangeMapper exchangeMapper;
    @Autowired
    ExchangeUserMapper exchangeUserMapper;
    @Autowired
    SingleExchange singleExchange;

    public Exchange addExchangeItem(ExchangeDto exchangeValue){
        try{
            ExchangeUserDto exchangeUserDto = exchangeValue.getExchangeUser();
            Exchanger exchanger = exchangeUserMapper.toEntity(exchangeUserDto);
            Exchanger exsistingUser = exchangerRepo.fetchExchangeUserDetail(exchanger.getEmail());
            if(exsistingUser == null){
                exchangerRepo.save(exchanger);
            }
            Exchange exchange = new Exchange();
            exchange = singleExchange.toEntity(exchangeValue);
            exchange.setExchangeUser(exchanger);
            return exchangeRepo.save(exchange);
        }
        catch (Exception ex){
          ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }
    @Transactional
public APIResponse saveMultipleItems(List<MultipleExchangeDto> dto, Integer id){
   try{
       Exchanger exchanger= exchangerRepo.findById(id).
               orElseThrow(()->new RuntimeException("Please pass id"));
       for(int i = 0; i < dto.size();i++){
        Exchange exchange = exchangeMapper.toEntity(dto.get(i));
        exchange.setExchangeUser(exchanger);
        exchangeRepo.save(exchange);
       }
       return new APIResponse(1,"1016");
   } catch (Exception e) {
       e.printStackTrace();
       throw new RuntimeException(e);
   }
}
}
