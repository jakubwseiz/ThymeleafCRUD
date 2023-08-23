package com.example.ThymeleafCRUD.Controllers;

import com.example.ThymeleafCRUD.Entities.Invoice;
import com.example.ThymeleafCRUD.Repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/invoices")
public class InvoiceController {
    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceController(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @GetMapping
    public String listInvoices(Model model) {
        List<Invoice> invoices = invoiceRepository.findAll();
        model.addAttribute("invoices", invoices);
        return "invoices/list";
    }

    @GetMapping("/new")
    public String showInvoiceForm(Model model) {
        model.addAttribute("invoice", new Invoice());
        return "invoices/form";
    }

    @PostMapping("/new")
    public String saveInvoice(@ModelAttribute Invoice invoice) {
        invoiceRepository.save(invoice);
        return "redirect:/invoices";
    }

    @GetMapping("/{id}")
    public String showInvoiceDetails(@PathVariable Long id, Model model) {
        Optional<Invoice> invoice = invoiceRepository.findById(id);
        if (invoice.isPresent()) {
            model.addAttribute("invoice", invoice.get());
            return "invoices/details";
        } else {
            return "redirect:/invoices";
        }
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Invoice> invoice = invoiceRepository.findById(id);
        if (invoice.isPresent()) {
            model.addAttribute("invoice", invoice.get());
            return "invoices/form";
        } else {
            return "redirect:/invoices";
        }
    }

    @PostMapping("/{id}/edit")
    public String updateInvoice(@PathVariable Long id, @ModelAttribute Invoice updatedInvoice) {
        Optional<Invoice> existingInvoice = invoiceRepository.findById(id);
        if (existingInvoice.isPresent()) {
            updatedInvoice.setId(id);
            invoiceRepository.save(updatedInvoice);
        }
        return "redirect:/invoices";
    }

    @PostMapping("/{id}/delete")
    public String deleteInvoice(@PathVariable Long id) {
        invoiceRepository.deleteById(id);
        return "redirect:/invoices";
    }
}

