package com.example.ThymeleafCRUD.Controllers;

import com.example.ThymeleafCRUD.Entities.Invoice;
import com.example.ThymeleafCRUD.Entities.InvoiceItem;
import com.example.ThymeleafCRUD.Repository.InvoiceRepository;
import com.example.ThymeleafCRUD.Services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/invoices")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @GetMapping
    public List<Invoice> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }

    @GetMapping("/{id}")
    public Invoice getInvoiceById(@PathVariable Long id) {
        return invoiceService.getInvoiceById(id);
    }

    @PostMapping
    public Invoice createInvoice(@RequestBody Invoice invoice) {
        return invoiceService.createInvoice(invoice);
    }

    @PutMapping("/{id}")
    public Invoice updateInvoice(@PathVariable Long id, @RequestBody Invoice updatedInvoice) {
        return invoiceService.updateInvoice(id, updatedInvoice);
    }

    @DeleteMapping("/{id}")
    public void deleteInvoice(@PathVariable Long id) {
        invoiceService.deleteInvoice(id);
    }

    @PostMapping("/{id}/items")
    public Invoice addItemToInvoice(@PathVariable Long id, @RequestBody InvoiceItem item) {
        return invoiceService.addItemToInvoice(id, item);
    }

    @DeleteMapping("/items/{itemId}")
    public void removeItemFromInvoice(@PathVariable Long itemId) {
        invoiceService.removeItemFromInvoice(itemId);
    }
}


