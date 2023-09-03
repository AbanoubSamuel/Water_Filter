package com.aqua.prod.entity;

import com.aqua.prod.dto.EiCurrencyDto;
import com.aqua.prod.dto.StatusDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Currency}
 */
@Data
public class CurrencyDto implements Serializable {
    public CurrencyDto(Integer id)
    {
        this.id = id;
    }

    Integer id;
    @Size(max = 100)
    String name;
    @Size(max = 100)
    String nativeLanguageName;
    EiCurrencyDto eiCurrency;
    @NotNull
    StatusDto status;
    @Size(max = 1000)
    String remarks;
}