package com.bootcamp.credit.model.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "paymentCredit")
public class PaymentCredit {
    @Id
    private String _id;
    private String nroDocument;
    private int amount;
    private LocalDate date;
}
