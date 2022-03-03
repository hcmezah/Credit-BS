package com.bootcamp.credit.repository;

import com.bootcamp.credit.model.dto.Credit;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ICreditRepository extends ReactiveMongoRepository<Credit,String> {

    Mono<Credit> findByCode(String code);

    Flux<Credit> findByNumDocument(String numDocument);

}
