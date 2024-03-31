package com.patika.paymentservice.repository;

import com.patika.paymentservice.entity.Invoice;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InvoiceRepository {

    private List<Invoice> invoices = new ArrayList<>();
    private long nextId = 1;

    public List<Invoice> getAllInvoices() {
        return invoices;
    }

    public Invoice getInvoiceById(long id) {
        for (Invoice invoice : invoices) {
            if (invoice.getId() == id) {
                return invoice;
            }
        }
        return null;
    }

    public Invoice addInvoice(Invoice invoice) {
        invoice.setId(nextId++);
        invoices.add(invoice);
        return invoice;
    }

    public Invoice updateInvoice(long id, Invoice updatedInvoice) {
        for (int i = 0; i < invoices.size(); i++) {
            Invoice invoice = invoices.get(i);
            if (invoice.getId() == id) {
                updatedInvoice.setId(id);
                invoices.set(i, updatedInvoice);
                return updatedInvoice;
            }
        }
        return null;
    }

    public void deleteInvoice(long id) {
        invoices.removeIf(invoice -> invoice.getId() == id);
    }
}
