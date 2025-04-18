package com.manudev.Trading.walletService.model;

import com.manudev.Trading.userService.model.UserEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long walletId;

    @OneToOne
    private UserEntity user;

    // en este punto se utiliza bid decimal debido a que se necesita una presicion absoluta
    private BigDecimal balance;

}
