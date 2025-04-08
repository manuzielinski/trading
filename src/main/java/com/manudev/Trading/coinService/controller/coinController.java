package com.manudev.Trading.coinService.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manudev.Trading.coinService.coinRepository.CoinRepository;
import com.manudev.Trading.coinService.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coins")
public class coinController {

    @Autowired
    private CoinService coinService;

    @Autowired
    private ObjectMapper objectMapper;

}
