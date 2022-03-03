package com.bootcamp.credit.model.dto;

import reactor.core.publisher.Mono;

public class CreateCreditResponse {
    private Integer code;
    private String mensaje;
    private Mono<?> objResult;
}
