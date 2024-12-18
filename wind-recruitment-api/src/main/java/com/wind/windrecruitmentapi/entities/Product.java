package com.wind.windrecruitmentapi.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {

    private Integer id;
    private String reference;
    private String name;
    private String quantity;
    private String unit;
    private String unitPrice;
    private String discount;
    private String priceTaxFree;
    private String taxPerCent;

}
