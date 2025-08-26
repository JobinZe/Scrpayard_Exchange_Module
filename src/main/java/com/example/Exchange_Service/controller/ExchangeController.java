package com.example.Exchange_Service.controller;

import com.example.Exchange_Service.entity.APIResponse;
import com.example.Exchange_Service.entity.Exchange;
import com.example.Exchange_Service.services.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/exchange")
public class ExchangeController {
    @Autowired
    private ExchangeService exchangeService;
@PostMapping("/add-item")
    public ResponseEntity<APIResponse> addExchangeItems(@RequestPart("exchangeDetail") Exchange exchange,
                                                        @RequestPart("file") MultipartFile file) throws Exception {
        try {
            String uploadDir = "uploads/";
            Path path = Paths.get(uploadDir);
            if (!Files.exists(path)) {
                Files.createDirectories(path);

            }
            String filePath = uploadDir + file.getOriginalFilename();
            Path fullPaths = Paths.get(filePath);
            file.transferTo(fullPaths);
            exchange.setItem_image(filePath);
            exchangeService.addExchangeItem(exchange);
            return ResponseEntity.ok(new APIResponse(1, "1008"));
        }
        catch (Exception e){
            return ResponseEntity.ok(new APIResponse(2,e.getMessage()));
        }
    }
}
