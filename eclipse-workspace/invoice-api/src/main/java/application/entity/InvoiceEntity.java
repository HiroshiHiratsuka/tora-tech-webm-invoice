package application.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class InvoiceEntity {

	/** The invoice_no. */
	@Id
	private int invoiceNo;

	/** The client_no. */
	private int clientNo;

	/** The invoice_status. */
	private int invoiceStatus;

	/** The invoice_create_date. */
	private Date invoiceCreateDate;

	/** The invoice_title. */
	private String invoiceTitle;

	/** The invoice_amt. */
	private int invoiceAmt;

	/** The tax_amt. */
	private int taxAmt;

	/** The invoice_start_date. */
	private Date invoiceStartDate;

	/** The invoice_end_date. */
	private Date invoiceEndDate;

	/** The invoice_note. */
	private String invoiceNote;

	/** The create_user. */
	private String createUser;

	/** The create_datetime. */
	private Timestamp createDatetime;

	/** The Stringupdate_user. */
	private String updateUser;

	/** The update_datetime. */
	private Timestamp updateDatetime;

	/** The del_flg. */
	private int delFlg;

}
