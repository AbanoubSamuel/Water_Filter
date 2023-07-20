package com.aqua.prod.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JsonResponse<T> {
    boolean status;
    String message;
    T data;
}
