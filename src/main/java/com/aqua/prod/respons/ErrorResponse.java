package com.aqua.prod.respons;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
   private boolean status;
    private String message;
}
