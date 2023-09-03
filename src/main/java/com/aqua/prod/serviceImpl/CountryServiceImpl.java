package com.aqua.prod.serviceImpl;

import com.aqua.prod.datarest.CountryRepo;
import com.aqua.prod.datarest.CurrencyRepo;
import com.aqua.prod.datarest.StatusRepo;
import com.aqua.prod.dto.CountryDto;
import com.aqua.prod.entity.Country;
import com.aqua.prod.entity.Currency;
import com.aqua.prod.entity.Status;
import com.aqua.prod.service.CountryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepo countryRepo;
    private final ObjectMapper mapper;
    private final StatusRepo statusRepo;
    private final CurrencyRepo currencyRepo;

    public CountryServiceImpl(CountryRepo repo, ObjectMapper mapper, StatusRepo statusRepo,
                              CurrencyRepo currencyRepo)
    {
        this.countryRepo = repo;
        this.mapper = mapper;
        this.statusRepo = statusRepo;
        this.currencyRepo = currencyRepo;
    }

    @Override
    public Country createCountry(CountryDto countryDto)
    {
        try {
            Optional<Country> country = countryRepo.getCountryByName(countryDto.getName());
            if (country.isPresent()) {
                throw new RuntimeException("Country already exists");
            } else {
                Optional<Status> status = statusRepo.findById(countryDto.getStatus());
                Optional<Currency> currency = currencyRepo.findById(countryDto.getCurrencyId());
                if (status.isPresent() && currency.isPresent()) {
                    return countryRepo.save(mapper.convertValue(countryDto, Country.class));
                } else {
                    throw new EntityNotFoundException("Currency or status not found");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}