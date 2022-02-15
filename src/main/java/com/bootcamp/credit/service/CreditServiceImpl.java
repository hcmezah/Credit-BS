package com.bootcamp.credit.service;

import com.bootcamp.credit.repository.ICreditRepository;
import com.bootcamp.credit.model.dto.Credit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@RequiredArgsConstructor
@Service
public class CreditServiceImpl implements ICreditService {

    private final ICreditRepository repository;

    @Override
    public Flux<Credit> getAllCredits() {
        return this.repository.findAll();
    }

    @Override
    public Mono<Credit> getCredit(String code) {
        return this.repository.findByCode(code);
    }

    @Override
    public Mono<Credit> createCredit(Credit credit) {
        String numDoc = credit.getNumDocument();
        Integer digitOfND = numDoc.length();
        String customerType = "";
        //Boolean flgSave=false;

        switch (digitOfND) {
            case 8:
                customerType = "P";
                break;
            case 11:
                customerType = "E";
                break;
            default:
                customerType = "";
                break;
        }

        //seteandoData
        Integer digitCode1 = (int) (10 * Math.random());
        Integer digitCode2 = (int) (10 * Math.random());
        Integer digitCode3 = (int) (10 * Math.random());
        Integer digitCode4 = (int) (10 * Math.random());
        String codeFinal=digitCode1.toString()+""+digitCode2.toString()+""+digitCode3.toString();

        String codeF="CD"+codeFinal.toString();
        credit.setCode(codeF);
        credit.setAmortization(0);

        switch (customerType){
            case "P":
               this.repository.findByNumDocument(numDoc).flatMap(c -> {
                    if(c.getCode().isEmpty()){
                        return this.repository.save(credit);

                    }else{
                        return Mono.empty();
                    }
                });
            case "E": return this.repository.save(credit);
            default : return Mono.empty();
        }

    }

    @Override
    public Mono<Credit> updateCredit(Credit credit) {
        String code=credit.getCode();
        return this.repository.findByCode(code).flatMap(c -> {c.setCode(code);
                                return this.repository.save(credit);}).switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<Credit> deleteCredit(String code) {
        return this.repository.findByCode(code).flatMap(c -> this.repository.deleteById(c.get_id()).thenReturn(c));
    }
}
