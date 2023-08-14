package com.aqua.prod.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.aqua.prod.entity.Country}
 */
@Getter
@Setter
public class CountryDto implements Serializable {
    @NotNull
    @Size(max = 100)
    String name;
    Integer statusId;
    @NotNull
    Integer currencyId;
    @Size(max = 1000)
    String description;
}