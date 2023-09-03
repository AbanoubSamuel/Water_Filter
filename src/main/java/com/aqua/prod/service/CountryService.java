package com.aqua.prod.service;

import com.aqua.prod.dto.CountryDto;
import com.aqua.prod.entity.Country;

public interface CountryService {
    Country createCountry(CountryDto countryDto);
}
