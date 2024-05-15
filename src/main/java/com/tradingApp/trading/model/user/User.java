package com.tradingApp.trading.model.user;

import jakarta.persistence.Entity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Data
public class User {
    private String userId;
    private String name;
    private String email;
}
