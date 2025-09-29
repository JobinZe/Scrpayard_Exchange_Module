package com.example.Exchange_Service.controller;

import com.example.Exchange_Service.dto.EmailDto;
import com.example.Exchange_Service.dto.ExchangeUserDto;
import com.example.Exchange_Service.entity.APIResponse;
import com.example.Exchange_Service.services.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/exchange")
public class EmailController {
    private final EmailService emailService;
    private String recievedEmail = null;
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }
    @PostMapping("/verify-email")
    private ResponseEntity<APIResponse> checkEmailExist(@RequestBody EmailDto email)throws Exception{
        try {
            if (email.getEmail() == null || email.getEmail().isEmpty()) {
                return ResponseEntity.ok(new APIResponse(2, "1014"));
            }
            boolean isExist = emailService.checkEmailExist(email.getEmail());

            if (isExist) {
                recievedEmail = email.getEmail();
                return ResponseEntity.ok(new APIResponse(1, "1015"));
            } else {
               return ResponseEntity.ok(new APIResponse(1, "1016"));
            }
        } catch (Exception e) {
           return ResponseEntity.badRequest().body(new APIResponse(2,"error" + e.getMessage()));
        }
    }
    @PostMapping("/fetch-ExchangeUser")
    public ResponseEntity<?> fetchExchangeUser(@RequestBody EmailDto email){
        System.out.println(email.getEmail() +"email Id");
        try {
           ExchangeUserDto exchangeUserDto = emailService.exchangeUser(email.getEmail());
           return ResponseEntity.ok(exchangeUserDto);
        }
        catch (IllegalArgumentException iae) {
            return ResponseEntity.badRequest().body(new APIResponse(2, iae.getMessage()));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(new APIResponse(2,"error" + e.getMessage()));
        }
    }
}
