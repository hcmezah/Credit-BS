package com.bootcamp.credit.controller;

import com.bootcamp.credit.model.dto.Credit;
import com.bootcamp.credit.service.CreditServiceImpl;
import com.bootcamp.credit.utils.DataCredit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import javax.xml.crypto.Data;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CreditControllerTest {

    private static WebTestClient webTestClient;

    @Mock
    private static CreditServiceImpl service;

    @BeforeAll
    public static void setUp() {
        service=mock(CreditServiceImpl.class);
        webTestClient=WebTestClient.bindToController(new CreditController(service))
                                   .configureClient()
                .baseUrl("/credit")
                .build();
    }

    @Test
    void getAllTest() {
        when(service.getAllCredits()).thenReturn(Flux.just(DataCredit.getDataCredit()));
        Flux<Credit> response=webTestClient.get()
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .returnResult(Credit.class)
                .getResponseBody();

        StepVerifier.create(response)
                .expectSubscription()
                .expectNext(DataCredit.getDataCredit())
                .verifyComplete();

    }

    @Test
    void getCreditTest() {
    }

    @Test
    void createCreditTest() {
    }
}