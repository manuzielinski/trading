package com.manudev.Trading.coinService.service;

import com.manudev.Trading.coinService.coinRepository.CoinRepository;
import com.manudev.Trading.coinService.model.Coin;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface CoinService {

    List<Coin> getCoinList(int page);

    String getMatketChart(String coinId, int days);

    String getCoindDetails(String coinId);

    Coin findById(String coinId);

    String searchCoin(String keyword);

    String getTop50CoinsByMarketCapRank();

    String GetTreadingCoins();
}
