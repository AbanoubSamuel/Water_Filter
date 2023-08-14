package com.aqua.prod.api.controller;

import com.aqua.prod.common.GenericService;
import com.aqua.prod.dto.CountryDto;
import com.aqua.prod.dto.CreateStatusDto;
import com.aqua.prod.dto.JsonResponse;
import com.aqua.prod.dto.UpdateStatusDto;
import com.aqua.prod.entity.Country;
import com.aqua.prod.entity.Status;
import com.aqua.prod.mappers.CountryMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/country")
public class CountryController {

    private GenericService<Country, CountryDto> service;

    public CountryController(GenericService<Country, CountryDto> service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<JsonResponse<Country>> createCountry(@Valid @RequestBody CountryDto dto) {
        Optional<Country> statusExists = service.checkEntityByName(dto.getName());
        if (statusExists.isPresent()) {
            JsonResponse<Country> jsonResponse = new JsonResponse<>();
            jsonResponse.setStatus(false);
            jsonResponse.setMessage("Country already exists");
            return new ResponseEntity<>(jsonResponse, HttpStatusCode.valueOf(409));
        }

        //// Create new country ////
        Country country = service.save(dto);
        JsonResponse<Country> jsonResponse = new JsonResponse<>();
        jsonResponse.setStatus(true);
        jsonResponse.setMessage("Country created successfully");
        jsonResponse.setData(country);
        return new ResponseEntity<>(jsonResponse, HttpStatusCode.valueOf(201));
    }

    @PutMapping("/{countryId}")
    public ResponseEntity<JsonResponse<Country>> updateCountry(@Valid @PathVariable int countryId, @Valid @RequestBody CountryDto dto) {
        Country updatedStatus = service.update(countryId, dto);
        JsonResponse<Country> jsonResponse = new JsonResponse<>();
        jsonResponse.setStatus(true);
        jsonResponse.setMessage("Country updated successfully");
        jsonResponse.setData(updatedStatus);

        return new ResponseEntity<>(jsonResponse, HttpStatusCode.valueOf(200));
    }

    @GetMapping()
    public ResponseEntity<JsonResponse<List<CountryDto>>> getAllCountries() {
        List<CountryDto> status = service.getAll().stream().map(country -> {
            CountryMapper countryMapper = new CountryMapper();
            return countryMapper.fromEntityToDto(country);
        }).toList();

        JsonResponse<List<CountryDto>> jsonResponse = new JsonResponse<>();
        jsonResponse.setStatus(true);
        jsonResponse.setMessage("Fetched Country successfully");
        jsonResponse.setData(status);
        return new ResponseEntity<>(jsonResponse, HttpStatusCode.valueOf(200));


    }
}
