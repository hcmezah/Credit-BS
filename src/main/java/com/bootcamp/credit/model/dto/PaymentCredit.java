package com.bootcamp.credit.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "paymentCredit")
public class PaymentCredit {
    @Id
    private String _id;
    private String nroDocument;
    private int amount;
    private String date;
}
