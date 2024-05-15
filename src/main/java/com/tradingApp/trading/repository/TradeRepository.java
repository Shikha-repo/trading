package com.tradingApp.trading.repository;

import com.tradingApp.trading.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@NoRepositoryBean
public interface TradeRepository extends CrudRepository<Trade,Long> {
}
