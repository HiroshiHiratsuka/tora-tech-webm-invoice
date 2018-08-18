package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.entity.InvoiceEntity;

@Repository
public interface InvoiceInsertRepository extends JpaRepository<InvoiceEntity, Integer>{
}
