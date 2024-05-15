package com.tradingApp.trading.controller;

import com.tradingApp.trading.model.CurrencyType;
import com.tradingApp.trading.model.Trade;
import com.tradingApp.trading.model.TradeType;
import com.tradingApp.trading.model.rm.MetalType;
import com.tradingApp.trading.model.rm.RMShipmentType;
import com.tradingApp.trading.model.rm.RefinedMetalTrade;
import com.tradingApp.trading.services.TradeService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/v1/trades")
public class TradeController {
    @Autowired
    private TradeService tradeService;
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping
    public ResponseEntity<Trade> saveTrade(@RequestBody Trade trade) {
        try {
           Trade result= tradeService.saveTrade(trade);
            return new ResponseEntity(result, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity("Please send correct request", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Trade>> getAllTrades(){
        try {
            return new ResponseEntity(tradeService.getAllTrades(), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity("Server is facing issues", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/validate-and-save")
    public ResponseEntity<Trade> saveAndValidateTradeTest(@RequestBody Trade trade) throws Exception {
        String res=validateTradeWithRestTemplate(trade);
        if(res.equals("SUCCESS")) {
            tradeService.saveTrade(trade);
            return ResponseEntity.ok(trade);
        }
        else{
            return new ResponseEntity("invalid",HttpStatus.BAD_REQUEST);
        }
    }

    private String validateTradeWithRestTemplate(Trade trade) throws Exception {
        String res;
        String validationServiceUrl = "http://localhost:8082/api/v1/validate";
//        RestTemplate restTemplate = new RestTemplate(); // Default configuration

        try {
            return restTemplate.postForObject(validationServiceUrl, trade, String.class); // Send POST request with trade object
        } catch (RestClientResponseException e) {
            // Handle validation exception from service (e.g., check status code)
            throw new Exception(e.getMessage());
        }
//        return res;
    }


}
