package com.aqua.prod.mappers;

import com.aqua.prod.common.Mapper;
import com.aqua.prod.dto.CountryDto;
import com.aqua.prod.dto.UpdateStatusDto;
import com.aqua.prod.entity.Country;
import com.aqua.prod.entity.Status;
import org.springframework.stereotype.Component;

@Component
public class CountryMapper implements Mapper<Country, CountryDto> {

    @Override
    public Country fromDtoToEntity(CountryDto dto) {
        Country country = new Country();
        country.setName(dto.getName());

        country.setDescription(dto.getDescription());
        country.setCurrencyId(dto.getCurrencyId());

        Status status = new Status();
        status.setId(dto.getStatusId());
        country.setStatus(status);

        return country;
    }

    @Override
    public CountryDto fromEntityToDto(Country entity) {
        CountryDto dto = new CountryDto();
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setCurrencyId(entity.getCurrencyId());
        dto.setStatusId(entity.getStatus().getId());
        return dto;
    }
}