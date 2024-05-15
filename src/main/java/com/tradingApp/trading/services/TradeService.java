package com.tradingApp.trading.services;

import com.tradingApp.trading.model.Trade;
import com.tradingApp.trading.repository.RmRepository;
import com.tradingApp.trading.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TradeService {
    @Autowired
    private RmRepository tradeRepository;
    @Autowired
    private RestTemplate restTemplate;

    public Trade saveTrade(Trade trade) {
        return tradeRepository.save(trade);
    }

    public List<Trade> getAllTrades() {
        return (List<Trade>) tradeRepository.findAll();
    }

//    public String validateTrade(Trade trade) {
//        String status=restTemplate.getForObject("/api/v1/validate",String.class);
//        return status;
//    }

}
