package application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.entity.Invoice;
import application.respons.InvoiceRepository;

@Service
public class InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepo;
 
    public Invoice search(Integer no) {
    	Invoice invoice = invoiceRepo.findOne(no);
        return invoice;
    }
}
