package com.ar.stocksapp.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "symbols")
@Getter
@Setter
@ToString
public class Symbol {
    public static final int START_SEQ = 0;

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    private long id;

    @Column(name = "symbol")
    private String symbol;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "primary_exchange")
    private String primaryExchange;

    @Column(name = "calculation_price")
    private String calculationPrice;

    @Column(name = "open")
    private Double open;

    @Column(name = "open_time")
    private Long openTime;

    @Column(name = "open_source")
    private String openSource;

    @Column(name = "close")
    private Double close;

    @Column(name = "close_time")
    private Long closeTime;

    @Column(name = "close_source")
    private String closeSource;

    @Column(name = "high")
    private Double high;

    @Column(name = "high_time")
    private Long highTime;

    @Column(name = "high_source")
    private String highSource;

    @Column(name = "low_time")
    private Long lowTime;

    @Column(name = "low_source")
    private String lowSource;

    @Column(name = "latest_price")
    private Double latestPrice;

    @Column(name = "latest_source")
    private String latestSource;

    @Column(name = "latest_time")
    private String latestTime;

    @Column(name = "latest_update")
    private Long latestUpdate;

    @Column(name = "latest_volume")
    private Long latestVolume;

    @Column(name = "iex_real_time_price")
    private Double iexRealTimePrice;

    @Column(name = "iex_real_time_size")
    private Long iexRealTimeSize;

    @Column(name = "iex_last_updated")
    private Long iexLastUpdated;

    @Column(name = "delayed_price")
    private Double delayedPrice;

    @Column(name = "delayed_price_time")
    private Long delayedPriceTime;

    @Column(name = "odd_lot_delayed_price")
    private Double oddLotDelayedPrice;

    @Column(name = "odd_lot_delayed_price_time")
    private Long oddLotDelayedPriceTime;

    @Column(name = "extended_price")
    private Double extendedPrice;

    @Column(name = "extended_change")
    private Double extendedChange;

    @Column(name = "extended_change_percent")
    private Double extendedChangePercent;

    @Column(name = "extended_price_time")
    private Long extendedPriceTime;

    @Column(name = "previous_close")
    private Double previousClose;

    @Column(name = "previous_volume")
    private Long previousVolume;

    @Column(name = "change")
    private Double change;

    @Column(name = "change_percent")
    private Double changePercent;

    @Column(name = "volume")
    private Long volume;

    @Column(name = "iex_market_percent")
    private Double iexMarketPercent;

    @Column(name = "iex_volume")
    private Long iexVolume;

    @Column(name = "avg_total_volume")
    private Long avgTotalVolume;

    @Column(name = "iex_bid_price")
    private Long iexBidPrice;

    @Column(name = "iex_bid_size")
    private Long iexBidSize;

    @Column(name = "iex_ask_price")
    private Long iexAskPrice;

    @Column(name = "iex_ask_size")
    private Long iexAskSize;

    @Column(name = "iex_open")
    private Double iexOpen;

    @Column(name = "iex_open_time")
    private Long iexOpenTime;

    @Column(name = "iex_close")
    private Double iexClose;

    @Column(name = "iex_close_time")
    private Long iexCloseTime;

    @Column(name = "market_cap")
    private Long marketCap;

    @Column(name = "pe_ratio")
    private Long peRatio;

    @Column(name = "week52_high")
    private Double week52High;

    @Column(name = "week52_low")
    private Double week52Low;

    @Column(name = "ytd_change")
    private Double ytdChange;

    @Column(name = "last_trade_time")
    private Long lastTradeTime;

    @Column(name = "is_us_market_open")
    private Boolean isUSMarketOpen;
}
