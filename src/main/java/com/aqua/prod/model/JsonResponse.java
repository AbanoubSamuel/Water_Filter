package com.aqua.prod.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JsonResponse<T> {
    boolean status;
    String message;
    T data;
}
