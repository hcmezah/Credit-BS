package com.bootcamp.credit.controller;

import com.bootcamp.credit.model.dto.Credit;
import com.bootcamp.credit.model.dto.PaymentCredit;
import com.bootcamp.credit.service.ICreditService;
import com.bootcamp.credit.service.IPaymentCredit;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/paymentCredit")
public class PaymentCrediController {
    private final IPaymentCredit service;

    @GetMapping
    public Flux<PaymentCredit> getAllPaymentCredits(){
        return this.service.getAllPaymentCredits();
    }

    @GetMapping("/{code}")
    public Mono<PaymentCredit> getPaymentCredit(@PathVariable("code") String code){
        return this.service.getPaymentCredit(code);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<PaymentCredit> createPaymentCredit(@RequestBody PaymentCredit paymentCredit){
        return this.service.createPaymentCredit(paymentCredit);
    }

    @PutMapping
    public Mono<ResponseEntity<PaymentCredit>> updatePaymentCredit(@RequestBody PaymentCredit paymentCredit){
        return this.service.updatePaymentCredit(paymentCredit).flatMap(c -> Mono.just(ResponseEntity.ok(c))).switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @DeleteMapping("/{code}")
    public void deletePaymentCredit(@PathVariable("code") String code) {
        service.deletePaymentCredit(code);
    }

}
