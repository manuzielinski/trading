package com.manudev.Trading.walletService.service;

import com.manudev.Trading.userService.model.UserEntity;
import com.manudev.Trading.walletService.model.Order;
import com.manudev.Trading.walletService.model.Wallet;

public interface WalletService {
    Wallet getUserWallet (UserEntity user);
    Wallet addBalance(Wallet wallet, Long amount);
    Wallet findWalletById(Long walletId) throws Exception;
    Wallet WalletToWalletTransfer(UserEntity sender, Wallet receiver, Long amount) throws Exception;
    Wallet payOrderPayment(Order order, UserEntity user) throws Exception;

}
