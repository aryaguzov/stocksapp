package com.ar.stocksapp.repository;

import com.ar.stocksapp.model.Symbol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SymbolRepository extends JpaRepository<Symbol, Long> {
    /*List<Symbol> getTopHighestValueStocks();

    List<Symbol> getTopWithHighestRecentIncome();*/

}
