package com.tradingApp.trading.model;

import com.tradingApp.trading.model.rm.RefinedMetalTrade;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "Trades")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Trade_Type",
discriminatorType = DiscriminatorType.STRING)
public class Trade {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long tradeId;
    @Column(name = "Price")
    private Double price;
    @Enumerated(EnumType.STRING)
    private CurrencyType Currency;
    private Double quantity;


}
