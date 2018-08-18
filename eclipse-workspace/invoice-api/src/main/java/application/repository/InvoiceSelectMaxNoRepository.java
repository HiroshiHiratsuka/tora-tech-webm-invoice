package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import application.entity.InvoiceSelectMaxNoEntity;

@Repository
public interface InvoiceSelectMaxNoRepository extends JpaRepository<InvoiceSelectMaxNoEntity, Integer>{
	@Query(value =
			" select "
			+ "  MAX(invoice_No) AS invoice_No"
			+ " from"
			+ "  invoice",
			nativeQuery = true)
    InvoiceSelectMaxNoEntity findByInvoiceNo();
}
