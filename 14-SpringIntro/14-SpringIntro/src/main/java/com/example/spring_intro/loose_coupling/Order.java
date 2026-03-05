package com.example.spring_intro.loose_coupling;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {

    private Integer numeroOrdine;
    private List<String> listaProdotti;
    private Double totale;
}
