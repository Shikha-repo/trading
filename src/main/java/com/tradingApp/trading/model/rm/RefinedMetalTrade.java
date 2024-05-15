package com.tradingApp.trading.model.rm;

import com.tradingApp.trading.model.Trade;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@DiscriminatorValue(value = "RefinedMetal")
public class RefinedMetalTrade extends Trade {
    @Enumerated(EnumType.STRING)
    private MetalType metalType;
//    @Enumerated(EnumType.STRING)
//    private RMShipmentType shipmentType;
}
