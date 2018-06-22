package application.respons;

import org.springframework.data.jpa.repository.JpaRepository;

import application.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer>{
}
