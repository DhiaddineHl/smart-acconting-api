package com.wind.windrecruitmentapi.repositories;

import com.wind.windrecruitmentapi.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
}
