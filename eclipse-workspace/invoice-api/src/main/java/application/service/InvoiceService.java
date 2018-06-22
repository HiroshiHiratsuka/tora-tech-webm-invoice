package application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import application.entity.Invoice;
import application.respons.InvoiceRepository;

@Component
@Service
public class InvoiceService {

    @Autowired
    InvoiceRepository repository;
 
    public Invoice search(Integer no) {
    	Invoice invoice = repository.findOne(no);
        return invoice;
    }
}
