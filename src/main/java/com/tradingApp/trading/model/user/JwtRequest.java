package com.tradingApp.trading.model.user;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class JwtRequest {
    private String email;
    private String password;
}
