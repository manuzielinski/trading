package com.manudev.Trading.walletService.controller;

import com.manudev.Trading.userService.dto.UserDTO;
import com.manudev.Trading.userService.model.UserEntity;
import com.manudev.Trading.userService.service.UserService;
import com.manudev.Trading.OrderService.model.Order;
import com.manudev.Trading.walletService.model.Wallet;
import com.manudev.Trading.walletService.model.WalletTransaction;
import com.manudev.Trading.walletService.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.manudev.Trading.userService.mapper.UserMapper;

@RestController
@RequestMapping("/api/wallet")
public class WalletController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private WalletService walletService;

    @Autowired
    private UserService userService;

    @GetMapping("/api/wallet")
    public ResponseEntity<Wallet> getUserWallet(@RequestHeader("Authorization") String jwt){
        UserDTO userDTO = userService.findUserProfileByJwt(jwt);
        UserEntity user = userMapper.dtoToUser(userDTO);

        Wallet wallet = walletService.getUserWallet(user);

        return new ResponseEntity<>(wallet, HttpStatus.ACCEPTED);
    }

    @PutMapping("/api/wallet/${walletId}/transfer")
    public ResponseEntity<Wallet> walletToWalletTransfer(@RequestHeader("Authorization") String jwt,
                                                         @PathVariable Long walletId,
                                                         @RequestBody WalletTransaction req) throws Exception {

        UserDTO senderUserDTO = userService.findUserProfileByJwt(jwt);
        UserEntity userEntity = userMapper.dtoToUser(senderUserDTO);
        Wallet receiverWallet = walletService.findWalletById(walletId);
        Wallet wallet = walletService.WalletToWalletTransfer(userEntity, receiverWallet, req.getAmount());

        return new ResponseEntity<>(wallet, HttpStatus.ACCEPTED);
    }

    @PutMapping("/api/wallet/order/${orderId}/pay")
    public ResponseEntity<Wallet> payOrderPayment(@RequestHeader("Authorization") String jwt,
                                                         @PathVariable Long orderId) throws Exception {

        UserDTO userDTO = userService.findUserProfileByJwt(jwt);
        UserEntity userEntity = userMapper.dtoToUser(userDTO);
        Order order = orderService.getOrderById(orderId);
        Wallet wallet = walletService.payOrderPayment(order,userEntity);
        return new ResponseEntity<>(wallet, HttpStatus.ACCEPTED);
    }
}
