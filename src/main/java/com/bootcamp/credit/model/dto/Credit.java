package com.bootcamp.credit.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="credit")
public class Credit {

    @Id
    private String _id;
    private String code;
    private String numDocument;
    private double total;
    private double amortization;
    private LocalDate dateLapsed;

}
