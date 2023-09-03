package com.aqua.prod.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.aqua.prod.entity.EiCurrency}
 */
@Data
public class EiCurrencyDto implements Serializable {
    public EiCurrencyDto(Integer id)
    {
        this.id = id;
    }

    Integer id;
    @Size(max = 100)
    String code;
    @Size(max = 1000)
    String englishDesc;
}