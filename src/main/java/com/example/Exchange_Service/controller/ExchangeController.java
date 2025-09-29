package com.example.Exchange_Service.controller;
import com.example.Exchange_Service.dto.ExchangeDto;
import com.example.Exchange_Service.dto.MultipleExchangeDto;
import com.example.Exchange_Service.entity.APIResponse;
import com.example.Exchange_Service.services.ExchangeService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController

@RequestMapping("/api/exchange")
public class ExchangeController {
    @Autowired
    private ExchangeService exchangeService;
    private final ObjectMapper mapper;
    private ExchangeController(ObjectMapper objectMapper){
        this.mapper=objectMapper;
    }
@PostMapping("/add-item")
    public ResponseEntity<APIResponse> addExchangeItems(@RequestPart("exchangeDetail") String exchange,
                                                        @RequestPart("file") MultipartFile file) throws Exception {
        try {
            ExchangeDto exchangeDto = mapper.readValue(exchange,ExchangeDto.class);
            String uploadDir = "uploads/";
            Path path = Paths.get(uploadDir);
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }
            String filePath = uploadDir + file.getOriginalFilename();
            Path fullPaths = Paths.get(filePath);
            file.transferTo(fullPaths);
            exchangeDto.setItem_image(filePath);
            exchangeService.addExchangeItem(exchangeDto);
            return ResponseEntity.ok(new APIResponse(1, "1008"));
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/multiple-items")
    public ResponseEntity<APIResponse> addMultipleItems(@RequestPart("product") String multiExchange,
                                                        @RequestPart("files") List<MultipartFile> file,
                                                        @RequestPart("user") String id) {

        try {
            // Convert JSON string to List<>
            List<MultipleExchangeDto> arrayValues = mapper.readValue(multiExchange,
                    new TypeReference<List<MultipleExchangeDto>>() {
                    });
//            ExchangeUserDto exchangeUserDto = mapper.readValue(exchangeUser, ExchangeUserDto.class);
            for (int i = 0; i < arrayValues.size(); i++) {
                MultipleExchangeDto exchangeDto = arrayValues.get(i);
                MultipartFile recievedFiles = file.get(i);
                if (!file.isEmpty()) {
                    String fileName = recievedFiles.getOriginalFilename();
                    String uploadDir = "uploads/";
                    Path path = Paths.get(uploadDir);
                    if (!Files.exists(path)) {
                        Files.createDirectories(path);
                    }
                    String fullDirName =  uploadDir + fileName;
                    Path fullPath = Paths.get(fullDirName);
                    recievedFiles.transferTo(fullPath);
                    exchangeDto.setItem_image(fullDirName);
                }
            }
            APIResponse response =  exchangeService.saveMultipleItems(arrayValues,Integer.parseInt(id));
            return ResponseEntity.ok().body(response);
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
