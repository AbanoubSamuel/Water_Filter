package com.aqua.prod.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link com.aqua.prod.entity.Country}
 */
@Data
public class CountryDto implements Serializable {
    @Nullable
    Integer id;
    @NotNull
    @Size(max = 100)
    String name;
    @NotNull
    Integer status;
    @NotNull
    Integer currencyId;
    @Size(max = 1000)
    String description;
}