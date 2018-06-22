package application.respons;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

import application.entity.InvoiceError;
import application.result.InvoiceResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class ResponseInvoice.
 */
@Component
@AllArgsConstructor
@ToString
@Getter // 参照を更新させてバグとなるのを防ぐため参照のみとする
public class ResponseInvoice implements Responce {

    /** The errors. */
    @JsonProperty("errors")
    private List<InvoiceError> invoiceErrorList = new ArrayList<InvoiceError>();

    /** The results. */
    @JsonProperty("results")
    private List<InvoiceResult> invoiceResultList = new ArrayList<InvoiceResult>();

}
