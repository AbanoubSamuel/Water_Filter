package com.aqua.prod.dto;

import com.aqua.prod.entity.Status;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.aqua.prod.entity.Position}
 */
@Value
public class PositionDto implements Serializable {
    @NotNull
    @Size(max = 200)
    String name;
    @NotNull
    Status status;
    @Size(max = 1000)
    String description;
}