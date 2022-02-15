package com.bootcamp.credit.model.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection="credit")
public class Credit {

    @Id
    private String _id;
    private String code;
    private String numDocument;
    private double total;
    private double amortization;
}
