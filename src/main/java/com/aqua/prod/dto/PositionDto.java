package com.aqua.prod.dto;

import com.aqua.prod.entity.Status;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.aqua.prod.entity.Position}
 */
@Data
public class PositionDto implements Serializable {
    Integer id;
    @NotNull
    @Size(max = 200)
    String name;
    @NotNull
    Integer status;
    @Size(max = 1000)
    String description;
}