package com.example.ThymeleafCRUD.Entities;

import jakarta.persistence.*;

@Entity
public class InvoiceItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String itemName;
    private double price;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    // getters, setters

    public InvoiceItem() {
    }

    public InvoiceItem(Long id, String itemName, double price, Invoice invoice) {
        this.id = id;
        this.itemName = itemName;
        this.price = price;
        this.invoice = invoice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
