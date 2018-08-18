package application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import application.entity.InvoiceSelectEntity;

@Repository
public interface InvoiceSelectRepository extends JpaRepository<InvoiceSelectEntity, Integer>{
	@Query(value =
			" select"
			+ "  invoice_No,"
			+ "  client_Name,"
			+ "  i.client_No,"
			+ "  client_Address,"
			+ "  client_Tel,"
			+ "  client_Fax,"
			+ "  CONCAT(client_Charge_first_Name,client_Charge_last_Name) as client_Charge_Name,"
			+ "  invoice_Status,"
			+ "  invoice_Create_Date,"
			+ "  invoice_Title,"
			+ "  invoice_Amt,"
			+ "  tax_Amt,"
			+ "  invoice_Start_Date,"
			+ "  invoice_End_Date,"
			+ "  invoice_Note,"
			+ "  i.create_User,"
			+ "  i.create_Datetime,"
			+ "  i.update_User,"
			+ "  i.update_Datetime"
			+ " from"
			+ "  invoice i, client c"
			+ " where"
			+ "  i.client_No = c.client_No"
			+ "  and invoice_No= :No"
			+ " order by invoice_No",
			nativeQuery = true)
    List<InvoiceSelectEntity> findByInvoiceNo(@Param("No") int invoiceNo);
	
	@Query(value =
			" select"
			+ "  invoice_No,"
			+ "  client_Name,"
			+ "  i.client_No,"
			+ "  client_Address,"
			+ "  client_Tel,"
			+ "  client_Fax,"
			+ "  CONCAT(client_Charge_first_Name,client_Charge_last_Name) as client_Charge_Name,"
			+ "  invoice_Status,"
			+ "  invoice_Create_Date,"
			+ "  invoice_Title,"
			+ "  invoice_Amt,"
			+ "  tax_Amt,"
			+ "  invoice_Start_Date,"
			+ "  invoice_End_Date,"
			+ "  invoice_Note,"
			+ "  i.create_User,"
			+ "  i.create_Datetime,"
			+ "  i.update_User,"
			+ "  i.update_Datetime"
			+ " from"
			+ "  invoice i, client c"
			+ " where"
			+ "  i.client_No = c.client_No"
			+ " order by invoice_No",
			nativeQuery = true)
    List<InvoiceSelectEntity> selectAll();
}
