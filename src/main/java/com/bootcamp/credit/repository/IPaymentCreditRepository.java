package com.bootcamp.credit.repository;

import com.bootcamp.credit.model.dto.PaymentCredit;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaymentCreditRepository extends ReactiveMongoRepository<PaymentCredit, String> {
}
