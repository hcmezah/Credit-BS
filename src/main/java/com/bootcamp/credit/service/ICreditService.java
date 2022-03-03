package com.bootcamp.credit.service;

import com.bootcamp.credit.model.dto.CreateCreditResponse;
import com.bootcamp.credit.model.dto.Credit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICreditService {

    Flux<Credit> getAllCredits();

    Mono<Credit> getCredit(String code);

    Mono<Credit> createCredit(Credit credit);

    Mono<Credit> updateCredit(Credit credit);

    Mono<Credit> deleteCredit(String code);

    Flux<Credit> getCreditNumDoc(String numDoc);

}
