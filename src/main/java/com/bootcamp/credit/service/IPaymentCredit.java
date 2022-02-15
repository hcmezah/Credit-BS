package com.bootcamp.credit.service;

import com.bootcamp.credit.model.dto.PaymentCredit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPaymentCredit {
    Flux<PaymentCredit> getAllPaymentCredits();

    Mono<PaymentCredit> getPaymentCredit(String code);

    Mono<PaymentCredit> createPaymentCredit(PaymentCredit paymentCredit);

    Mono<PaymentCredit> updatePaymentCredit(PaymentCredit paymentCredit);

    public void deletePaymentCredit(String code);
}
