package com.tradingApp.trading.model.user;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class JwtResponse {
    private String jwtToken;
    private String userName;
}
