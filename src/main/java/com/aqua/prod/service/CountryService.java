package com.aqua.prod.service;

import com.aqua.prod.dto.CountryDto;
import com.aqua.prod.entity.Country;
import jakarta.persistence.EntityNotFoundException;

import java.util.Optional;

public interface CountryService {
    Country createCountry(CountryDto countryDto);

    Country updateCountry(CountryDto countryDto);

    Optional<Country> getCountry(Integer id);

    void deleteCountry(Integer id);
}
