package com.tradingApp.trading;

import com.tradingApp.trading.model.CurrencyType;
import com.tradingApp.trading.model.Trade;
import com.tradingApp.trading.model.oil.OilTrade;
import com.tradingApp.trading.model.oil.OilType;
import com.tradingApp.trading.model.rm.MetalType;
import com.tradingApp.trading.model.rm.RefinedMetalTrade;
import com.tradingApp.trading.repository.OilRepository;
import com.tradingApp.trading.repository.RmRepository;
import com.tradingApp.trading.repository.TradeRepository;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TradingApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext configurableApplicationContext= SpringApplication.run(TradingApplication.class, args);
		TradeRepository rmRepository=configurableApplicationContext.getBean(RmRepository.class);
		TradeRepository oilRepo=configurableApplicationContext.getBean(OilRepository.class);
		Trade RMtrade= RefinedMetalTrade
				.builder()
				.metalType(MetalType.IRON)
//                .shipmentType(RMShipmentType.CARGO)
				.build();
		RMtrade.setPrice(2000.0);
		RMtrade.setCurrency(CurrencyType.USD);
		RMtrade.setQuantity(20.0);
//        RMtrade.setTradeType(TradeType.ENERGY);

		rmRepository.save(RMtrade);

		Trade oilTrade= OilTrade.builder()
				.oilType(OilType.CRUDE_OIL)
				.build();
		oilTrade.setCurrency(CurrencyType.USD);
		oilTrade.setQuantity(3000.0);
		oilTrade.setPrice(800.0);
		oilRepo.save(oilTrade);
	}

}
