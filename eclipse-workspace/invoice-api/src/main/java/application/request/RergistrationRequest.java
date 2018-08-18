package application.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RergistrationRequest {
	
	/** The client_no. */
	private String clientNo;

	/** The invoice_status. */
	private String invoiceStatus;

	/** The invoice_create_date. */
	private String invoiceCreateDate;

	/** The invoice_title. */
	private String invoiceTitle;

	/** The invoice_amt. */
	private String invoiceAmt;

	/** The tax_amt. */
	private String taxAmt;

	/** The invoice_start_date. */
	private String invoiceStartDate;

	/** The invoice_end_date. */
	private String invoiceEndDate;

	/** The invoice_note. */
	private String invoiceNote;
	
}
