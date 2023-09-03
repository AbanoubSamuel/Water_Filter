package com.aqua.prod.datarest;

import com.aqua.prod.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRepo extends JpaRepository<Country, Integer> {
    Optional<Country> getCountryByName(String country);
}