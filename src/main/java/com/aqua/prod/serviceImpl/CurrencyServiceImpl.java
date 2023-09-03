package com.aqua.prod.serviceImpl;

import com.aqua.prod.datarest.CurrencyRepo;
import com.aqua.prod.entity.Currency;
import com.aqua.prod.service.CurrencyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    public CurrencyRepo currencyRepo;
    private final ObjectMapper mapper;

    public CurrencyServiceImpl(CurrencyRepo repo, ObjectMapper mapper)
    {
        this.currencyRepo = repo;
        this.mapper = mapper;
    }

    @Override
    public Optional<Currency> getCurrency(Integer id)
    {
        return currencyRepo.findById(id);
    }


}