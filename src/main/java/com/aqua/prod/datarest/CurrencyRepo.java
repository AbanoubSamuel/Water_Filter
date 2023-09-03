package com.aqua.prod.datarest;

import com.aqua.prod.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurrencyRepo extends JpaRepository<Currency, Integer> {
}