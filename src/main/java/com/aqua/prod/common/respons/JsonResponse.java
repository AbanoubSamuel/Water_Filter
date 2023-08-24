package com.aqua.prod.common.respons;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JsonResponse<T> {
    private boolean status;
    private String message;
    @Nullable
    private T data;
}
