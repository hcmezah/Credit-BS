package com.bootcamp.credit.controller;

import com.bootcamp.credit.service.ICreditService;
import com.bootcamp.credit.model.dto.Credit;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/credit")
public class CreditController {

    private final ICreditService service;

    @GetMapping
    public Flux<Credit> getAll(){
        return this.service.getAllCredits();
    }

    @GetMapping("/{code}")
    public Mono<Credit> getCredit(@PathVariable("code") String code){
        return this.service.getCredit(code);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Credit> createCredit(@RequestBody Credit credit){
        return this.service.createCredit(credit);
    }

    @PutMapping
    public Mono<ResponseEntity<Credit>> update(@RequestBody Credit credit){
    return this.service.updateCredit(credit).flatMap(c -> Mono.just(ResponseEntity.ok(c))).switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @DeleteMapping("/{code}")
    public Mono<ResponseEntity<Credit>> delete(@PathVariable("code") String code){
        return this.service.deleteCredit(code).flatMap(c -> Mono.just(ResponseEntity.ok(c)))
                        .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @GetMapping("/numDoc/{id}")
    public Flux<Credit> getCreditNumDoc(@PathVariable("id") String id){
        return this.service.getCreditNumDoc(id);
    }

}
