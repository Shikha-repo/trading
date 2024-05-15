package com.tradingApp.trading.repository;

import com.tradingApp.trading.model.CurrencyType;
import com.tradingApp.trading.model.Trade;
import com.tradingApp.trading.model.TradeType;
import com.tradingApp.trading.model.rm.MetalType;
import com.tradingApp.trading.model.rm.RMShipmentType;
import com.tradingApp.trading.model.rm.RefinedMetalTrade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TradeRepositoryTest {
    @Autowired
    private RmRepository tradeRepository;

    @Test
    public void saveTrade(){
        Trade RMtrade= RefinedMetalTrade
                .builder()
                .metalType(MetalType.IRON)
//                .shipmentType(RMShipmentType.CARGO)
                .build();
        RMtrade.setPrice(2000.0);
        RMtrade.setCurrency(CurrencyType.USD);
        RMtrade.setQuantity(20.0);
//        RMtrade.setTradeType(TradeType.ENERGY);

        tradeRepository.save(RMtrade);
        List<Trade> trades= (List<Trade>) tradeRepository.findAll();
        System.out.println(trades);

    }
//    @Test
//    public void findAllTrades(){
//       List<Trade> trades=tradeRepository.findAll();
//        System.out.println(trades);
//    }
}