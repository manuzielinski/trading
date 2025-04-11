package com.manudev.Trading.walletService.controller;

import com.manudev.Trading.userService.model.UserEntity;
import com.manudev.Trading.userService.service.UserService;
import com.manudev.Trading.walletService.model.Wallet;
import com.manudev.Trading.walletService.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @Autowired
    private UserService userService;

    public ResponseEntity<Wallet> getUserWallet(@RequestHeader("Authorization") String jwt){
        UserEntity user = userService.
    }
}
