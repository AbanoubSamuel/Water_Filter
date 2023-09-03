package com.aqua.prod.api.controller;

import com.aqua.prod.common.respons.JsonResponse;
import com.aqua.prod.dto.CountryDto;
import com.aqua.prod.entity.Country;
import com.aqua.prod.service.CountryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/country")
public class CountryController {
    private CountryService countryService;

    public CountryController(CountryService countryService)
    {
        this.countryService = countryService;
    }

    @GetMapping
    public ResponseEntity<JsonResponse<Country>> getCountry(@Valid @RequestParam(name = "id") Integer id)
    {
        try {
            Optional<Country> country = countryService.getCountry(id);
            JsonResponse<Country> jsonResponse = new JsonResponse<>();
            jsonResponse.setStatus(true);
            jsonResponse.setMessage("Successfully fetched country");
            jsonResponse.setData(country.get());
            return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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

    @PatchMapping
    public ResponseEntity<JsonResponse<Country>> updateCountry(@RequestBody CountryDto countryDto)
    {
        Country country = countryService.updateCountry(countryDto);
        JsonResponse<Country> jsonResponse = new JsonResponse<>();
        jsonResponse.setStatus(true);
        jsonResponse.setMessage("Successfully updated country");
        jsonResponse.setData(country);
        return new ResponseEntity<>(jsonResponse, HttpStatus.ACCEPTED);
    }

    @DeleteMapping
    public ResponseEntity<JsonResponse<String>> deleteCountry(@Valid @RequestParam(name = "id") Integer id)
    {
        countryService.deleteCountry(id);
        JsonResponse<String> jsonResponse = new JsonResponse<>();
        jsonResponse.setStatus(true);
        jsonResponse.setMessage("Successfully deleted country");
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }

}
