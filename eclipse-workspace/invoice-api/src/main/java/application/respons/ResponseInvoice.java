package application.respons;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import application.entity.InvoiceErrorEntity;
import application.result.InvoiceResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class ResponseInvoice.
 */

@AllArgsConstructor
@ToString
@Getter // 参照を更新させてバグとなるのを防ぐため参照のみとする
public class ResponseInvoice implements Responce {

    /** The errors. */
    @JsonProperty("errors")
    private List<InvoiceErrorEntity> invoiceErrorList = new ArrayList<InvoiceErrorEntity>();

    /** The results. */
    @JsonProperty("results")
    private List<InvoiceResult> invoiceResultList = new ArrayList<InvoiceResult>();

}
