package com.example.Exchange_Service.services;
import com.example.Exchange_Service.dto.SearchExchangeRequestDto;
import com.example.Exchange_Service.dto.SearchExchangeResponseDTO;
import com.example.Exchange_Service.entity.SearchExchange;
import com.example.Exchange_Service.mapper.SearchExchangeMapper;
import com.example.Exchange_Service.repo.SearchExchangeRepo;
import com.example.Exchange_Service.specification.ExchangeSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SearchExchangeService {
    private final SearchExchangeRepo repo;
    private final SearchExchangeMapper mapper;
    @Autowired
    public SearchExchangeService(SearchExchangeRepo repo, SearchExchangeMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }
    public Page<SearchExchangeResponseDTO> searchExchange(SearchExchangeRequestDto filter){
     int pageSize = (filter!=null && filter.getPageSize()!=null) ? filter.getPageSize() : 10;
     int pageNo = (filter!=null && filter.getPageNo()!=null) ? filter.getPageNo() : 10;
     Pageable pageable = PageRequest.of(pageNo,pageSize,Sort.by("posted_on").descending());
     Page<SearchExchange> pageResult = repo.findAll(ExchangeSpecification.byFilter(filter),pageable);
     return pageResult.map(mapper::toDto);
    }
}
