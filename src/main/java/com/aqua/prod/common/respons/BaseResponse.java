package com.aqua.prod.common.respons;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse<T> {
    private boolean status;
    private String message;
    private T data;
}
