package com.wind.windrecruitmentapi.entities;

import com.wind.windrecruitmentapi.utils.invoice.InvoiceType;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    private Invoice invoice;

    private InvoiceType invoiceType;

}
