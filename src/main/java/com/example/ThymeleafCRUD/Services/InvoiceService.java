package com.example.ThymeleafCRUD.Services;

import com.example.ThymeleafCRUD.Entities.Invoice;
import com.example.ThymeleafCRUD.Repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;


    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Invoice getInvoiceById(Long id) {
        return invoiceRepository.findById(id).orElse(null);
    }

    public Invoice addInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public Invoice updateInvoice(Invoice updatedInvoice) {
        return invoiceRepository.save(updatedInvoice);

    }

    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }

}
