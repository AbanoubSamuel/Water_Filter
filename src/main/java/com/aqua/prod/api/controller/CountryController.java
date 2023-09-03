package com.aqua.prod.api.controller;

import com.aqua.prod.common.respons.JsonResponse;
import com.aqua.prod.dto.CountryDto;
import com.aqua.prod.entity.Country;
import com.aqua.prod.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/country")
public class CountryController {
    private CountryService countryService;

    public CountryController(CountryService countryService)
    {
        this.countryService = countryService;
    }

    @PostMapping
    public ResponseEntity<JsonResponse<Country>> createCountry(@RequestBody CountryDto countryDto)
    {
        Country country = countryService.createCountry(countryDto);
        JsonResponse<Country> jsonResponse = new JsonResponse<>();
        jsonResponse.setStatus(true);
        jsonResponse.setMessage("Successfully create country");
        jsonResponse.setData(country);
        return new ResponseEntity<>(jsonResponse, HttpStatus.CREATED);
    }
}
