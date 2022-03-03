package com.bootcamp.credit.service;

import com.bootcamp.credit.model.dto.Credit;
import com.bootcamp.credit.repository.ICreditRepository;
import com.bootcamp.credit.utils.DataCredit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CreditServiceImplTest {
    @Mock
    private static ICreditRepository repository;

    private static CreditServiceImpl service;

    @BeforeAll
    public static void setUp() {
        repository=mock(ICreditRepository.class);
        service=new CreditServiceImpl(repository);
    }

    @Test
    void getAllCreditsTest() {
        when(service.getAllCredits()).thenReturn(Flux.just(DataCredit.getDataCredit()));

        Flux<Credit> response=service.getAllCredits();
        StepVerifier.create(response)
                .expectSubscription()
                .expectNext(DataCredit.getDataCredit())
                //.expectNext.one
                .verifyComplete();
    }

    @Test
    void getCreditTest() {
        Mono<Credit> cre=Mono.just(DataCredit.getDataCredit());
        when(service.getCredit(any())).thenReturn(cre);

        Mono<Credit> response=service.getCredit(any());

        StepVerifier.create(response)
                    .expectSubscription()
                    .expectNextMatches(c->c.get_id().equals("_0123123123asd"))
                    .verifyComplete();
    }

    @Test
    void createCreditTest() {
    }

    @Test
    void updateCreditTest() {
    }

    @Test
    void deleteCreditTest() {
    }

    @Test
    void getCreditNumDocTest() {
    }
}