package com.example.ThymeleafCRUD.Repository;

import com.example.ThymeleafCRUD.Entities.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Long> {
}
