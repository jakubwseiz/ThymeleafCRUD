package com.example.ThymeleafCRUD.Repository;

import com.example.ThymeleafCRUD.Entities.Invoice;
import com.example.ThymeleafCRUD.Entities.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
