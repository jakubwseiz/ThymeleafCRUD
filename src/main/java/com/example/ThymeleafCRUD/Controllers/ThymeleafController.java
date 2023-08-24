package com.example.ThymeleafCRUD.Controllers;

import com.example.ThymeleafCRUD.Entities.Invoice;
import com.example.ThymeleafCRUD.Entities.InvoiceItem;
import com.example.ThymeleafCRUD.Services.InvoiceService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/invoices")
public class ThymeleafController {
    @Autowired
    private InvoiceService invoiceService;

    @GetMapping
    public String getAllInvoices(Model model) {
        List<Invoice> invoices = invoiceService.getAllInvoices();
        model.addAttribute("invoices", invoices);
        return "invoices";
    }

    @GetMapping("/{id}")
    public String getInvoiceById(@PathVariable Long id, Model model) {
        Invoice invoice = invoiceService.getInvoiceById(id);
        model.addAttribute("invoice", invoice);
        return "invoice";
    }

    @GetMapping("/add")
    public String showAddInvoiceForm(Model model) {
        Invoice newInvoice = new Invoice();
        newInvoice.setItems(new ArrayList<>());
        newInvoice.getItems().add(new InvoiceItem()); // Add an initial empty item
        model.addAttribute("newInvoice", newInvoice);
        return "addInvoice"; // Use the appropriate template name
    }

    @PostMapping("/add")
    public String addInvoice(@ModelAttribute("newInvoice") Invoice newInvoice) {
        // Ensure at least one item is provided
        if (newInvoice.getItems().isEmpty()) {
            // Handle the case where no items are provided
            return "redirect:/invoices/add";
        }

        // Save the invoice and its items to the database
        invoiceService.createInvoice(newInvoice);

        return "redirect:/invoices"; // Redirect to invoices list after submission
    }

}
