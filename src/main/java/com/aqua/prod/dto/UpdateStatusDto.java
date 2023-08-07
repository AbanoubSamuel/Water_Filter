package com.aqua.prod.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.aqua.prod.entity.Status}
 */
@Value
public class UpdateStatusDto implements Serializable {
    Integer id;
    @NotNull
    @Size(max = 200)
    String name;
    @NotNull
    Boolean isActive;
    @Size(max = 1000)
    String description;
}