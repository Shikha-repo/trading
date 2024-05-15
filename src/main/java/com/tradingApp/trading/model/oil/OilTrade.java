package com.tradingApp.trading.model.oil;

import com.tradingApp.trading.model.Trade;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@DiscriminatorValue(value = "OilTrade")
public class OilTrade extends Trade {
//    @Enumerated(EnumType.STRING)
//    private OilShipmentType shipmentType;
    @Enumerated(EnumType.STRING)
    private OilType oilType;
}
