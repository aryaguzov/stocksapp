CREATE SEQUENCE IF NOT EXISTS global_seq START WITH 0;

CREATE TABLE IF NOT EXISTS symbols
(
    id                         BIGINT DEFAULT nextval('global_seq') PRIMARY KEY,
    symbol                     VARCHAR,
    company_name               VARCHAR,
    primary_exchange           VARCHAR,
    calculation_price          VARCHAR,
    open                       DOUBLE,
    open_time                  BIGINT,
    open_source                VARCHAR,
    close                      DOUBLE,
    close_time                 BIGINT,
    close_source               VARCHAR,
    high                       DOUBLE,
    high_time                  BIGINT,
    high_source                VARCHAR,
    low                        BIGINT,
    low_time                   BIGINT,
    low_source                 VARCHAR,
    latest_price               DOUBLE,
    latest_source              VARCHAR,
    latest_time                VARCHAR,
    latest_update              BIGINT,
    latest_volume              BIGINT,
    iex_real_time_price        DOUBLE,
    iex_real_time_size         BIGINT,
    iex_last_updated           BIGINT,
    delayed_price              DOUBLE,
    delayed_price_time         BIGINT,
    odd_lot_delayed_price      DOUBLE,
    odd_lot_delayed_price_time BIGINT,
    extended_price             DOUBLE,
    extended_change            DOUBLE,
    extended_change_percent    DOUBLE,
    extended_price_time        BIGINT,
    previous_close             DOUBLE,
    previous_volume            BIGINT,
    change                     DOUBLE,
    change_percent             DOUBLE,
    volume                     BIGINT,
    iex_market_percent         DOUBLE,
    iex_volume                 BIGINT,
    avg_total_volume           BIGINT,
    iex_bid_price              BIGINT,
    iex_bid_size               BIGINT,
    iex_ask_price              BIGINT,
    iex_ask_size               BIGINT,
    iex_open                   DOUBLE,
    iex_open_time              BIGINT,
    iex_close                  DOUBLE,
    iex_close_time             BIGINT,
    market_cap                 BIGINT,
    pe_ratio                   BIGINT,
    week52_high                DOUBLE,
    week52_low                 DOUBLE,
    ytd_change                 DOUBLE,
    last_trade_time            BIGINT,
    is_us_market_open          BOOLEAN
);

CREATE TABLE IF NOT EXISTS log_tracking AS
SELECT *
FROM symbols
WHERE 1 = 0;

ALTER TABLE log_tracking
    ADD COLUMN time_stamp TIMESTAMP;

CREATE TRIGGER symbols_upd
    AFTER UPDATE
    ON symbols
    FOR EACH ROW
CALL "com.ar.stocksapp.UpdTrigger";



