package com.wind.windrecruitmentapi.entities;


import com.wind.windrecruitmentapi.utils.ledger.LedgerType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Ledger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private User owner;
    private Double balance;

    private LedgerType type;

    private String ledgerOfId;

    @OneToMany
    private List<Transaction> transactions;


}
