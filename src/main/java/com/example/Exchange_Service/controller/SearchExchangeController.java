package com.example.Exchange_Service.controller;
import com.example.Exchange_Service.dto.SearchExchangeRequestDto;
import com.example.Exchange_Service.dto.SearchExchangeResponseDTO;
import com.example.Exchange_Service.services.SearchExchangeService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exchange")
public class SearchExchangeController {
    private final SearchExchangeService service;

    public SearchExchangeController( SearchExchangeService service) {
        this.service=service;
    }
    @PostMapping("/search-exchange")
    public ResponseEntity<?> search(@RequestBody SearchExchangeRequestDto dto){
        Page<SearchExchangeResponseDTO> results = service.searchExchange(dto);
        return ResponseEntity.ok(results);
    }
}
