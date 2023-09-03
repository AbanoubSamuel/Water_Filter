package com.aqua.prod.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link Status}
 */
@Data
public class StatusDto implements Serializable {
    public StatusDto(int id){
        this.id = id;
    }
    @Nullable
    Integer id;
    @NotNull
    @Size(max = 200)
    String name;
    @NotNull
    Boolean isActive;
    @Size(max = 1000)
    String description;
}