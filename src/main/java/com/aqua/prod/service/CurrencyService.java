package com.aqua.prod.service;

import com.aqua.prod.entity.Currency;

import java.util.Optional;

public interface CurrencyService {

    Optional<Currency> getCurrency(Integer id);
}
