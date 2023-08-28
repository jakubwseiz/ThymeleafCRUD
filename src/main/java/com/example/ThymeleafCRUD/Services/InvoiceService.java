package com.example.ThymeleafCRUD.Services;

import com.example.ThymeleafCRUD.Entities.Invoice;
import com.example.ThymeleafCRUD.Entities.InvoiceItem;
import com.example.ThymeleafCRUD.Repository.InvoiceItemRepository;
import com.example.ThymeleafCRUD.Repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private InvoiceItemRepository invoiceItemRepository;

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

    public InvoiceItem getItemById(Long id) {
        return invoiceItemRepository.findById(id).orElse(null);
    }

    public Invoice addItemToInvoice(Long invoiceId, InvoiceItem item) {
        Invoice invoice = invoiceRepository.findById(invoiceId).orElse(null);
        if (invoice != null) {
            item.setInvoice(invoice);
            invoice.getItems().add(item);
            invoiceRepository.save(invoice);
        }
        return invoice;
    }

    public void removeItemFromInvoice(Long itemId) {
        InvoiceItem item = invoiceItemRepository.findById(itemId).orElse(null);
        if (item != null) {
            Invoice invoice = item.getInvoice();
            invoice.getItems().remove(item);
            invoiceRepository.save(invoice);
            invoiceItemRepository.delete(item);
        }
    }
}
