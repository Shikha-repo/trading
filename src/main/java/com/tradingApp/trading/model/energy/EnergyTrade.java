package com.tradingApp.trading.model.energy;

import com.tradingApp.trading.model.Trade;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@DiscriminatorValue(value = "Energy")
public class EnergyTrade extends Trade {
    @Enumerated(EnumType.STRING)
    private EnergyType type;
//    @Enumerated(EnumType.STRING)
//    private EnergyShipmentType shipmentType;
}
