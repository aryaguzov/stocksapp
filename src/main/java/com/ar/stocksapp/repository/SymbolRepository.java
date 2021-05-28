package com.ar.stocksapp.repository;

import com.ar.stocksapp.model.Symbol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SymbolRepository extends JpaRepository<Symbol, Long> {
    @Query(nativeQuery = true,
            value = "SELECT id,\n" +
                    "       symbol,\n" +
                    "       company_name,\n" +
                    "       primary_exchange,\n" +
                    "       calculation_price,\n" +
                    "       open,\n" +
                    "       open_time,\n" +
                    "       open_source,\n" +
                    "       close,\n" +
                    "       close_time,\n" +
                    "       close_source,\n" +
                    "       high,\n" +
                    "       high_time,\n" +
                    "       high_source,\n" +
                    "       low,\n" +
                    "       low_time,\n" +
                    "       low_source,\n" +
                    "       latest_price,\n" +
                    "       latest_source,\n" +
                    "       latest_time,\n" +
                    "       latest_update,\n" +
                    "       latest_volume,\n" +
                    "       iex_real_time_price,\n" +
                    "       iex_real_time_size,\n" +
                    "       iex_last_updated,\n" +
                    "       delayed_price,\n" +
                    "       delayed_price_time,\n" +
                    "       odd_lot_delayed_price,\n" +
                    "       odd_lot_delayed_price_time,\n" +
                    "       extended_price,\n" +
                    "       extended_change,\n" +
                    "       extended_change_percent,\n" +
                    "       extended_price_time,\n" +
                    "       previous_close,\n" +
                    "       previous_volume,\n" +
                    "       change,\n" +
                    "       change_percent,\n" +
                    "       volume,\n" +
                    "       iex_market_percent,\n" +
                    "       iex_volume,\n" +
                    "       avg_total_volume,\n" +
                    "       iex_bid_price,\n" +
                    "       iex_bid_size,\n" +
                    "       iex_ask_price,\n" +
                    "       iex_ask_size,\n" +
                    "       iex_open,\n" +
                    "       iex_open_time,\n" +
                    "       iex_close,\n" +
                    "       iex_close_time,\n" +
                    "       market_cap,\n" +
                    "       pe_ratio,\n" +
                    "       week52_high,\n" +
                    "       week52_low,\n" +
                    "       ytd_change,\n" +
                    "       last_trade_time,\n" +
                    "       is_us_market_open\n" +
                    "FROM SYMBOLS\n" +
                    "ORDER BY COALESCE(volume, previous_volume) DESC,\n" +
                    "         company_name\n" +
                    "LIMIT 5;")
    List<Symbol> getTopHighestValueStocks();

    /*List<Symbol> getTopWithHighestRecentIncome();*/
}
