package com.bootcamp.credit.service;

import com.bootcamp.credit.model.dto.Credit;
import com.bootcamp.credit.model.dto.PaymentCredit;
import com.bootcamp.credit.repository.IPaymentCreditRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class PaymentCreditImpl implements IPaymentCredit{

    private final IPaymentCreditRepository repository;
    @Override
    public Flux<PaymentCredit> getAllPaymentCredits() {
        return repository.findAll();
    }

    @Override
    public Mono<PaymentCredit> getPaymentCredit(String code) {
        return repository.findById(code);
    }

    @Override
    public Mono<PaymentCredit> createPaymentCredit(PaymentCredit paymentCredit) {
        String today= LocalDateTime.now().toString();
        paymentCredit.setDate(today);
        return repository.save(paymentCredit);
    }

    @Override
    public Mono<PaymentCredit> updatePaymentCredit(PaymentCredit paymentCredit) {
        return repository.save(paymentCredit);
    }

    @Override
    public void deletePaymentCredit(String code) {
        repository.deleteById(code).subscribe();
    }
}
