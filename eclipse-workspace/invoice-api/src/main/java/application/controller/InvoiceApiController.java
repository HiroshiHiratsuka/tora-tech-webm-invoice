package application.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import application.entity.InvoiceSelectEntity;
import application.request.RergistrationRequest;
import application.request.SearchRequest;
import application.respons.ResponseInvoice;
import application.service.InvoiceService;

@Controller
@CrossOrigin
@ResponseBody
@RequestMapping(value="/invoice")
public class InvoiceApiController {

    @Autowired
    public InvoiceService invoiceService;

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<ResponseInvoice> registration(@RequestBody RergistrationRequest registration) {
    	// 登録処理
    	ResponseInvoice responseInvoice = invoiceService.registration(registration);
    	
    	// HTTPステータス設定
    	HttpStatus status = HttpStatus.OK;
    	if (!responseInvoice.getInvoiceErrorList().isEmpty()) {
        	if (responseInvoice.getInvoiceErrorList().get(0).getErrorCode() == "40001"
        			|| responseInvoice.getInvoiceErrorList().get(0).getErrorCode() == "40002") {
        		status = HttpStatus.BAD_REQUEST;
        	} else {
        		status = HttpStatus.INTERNAL_SERVER_ERROR;
        	}
    	}

    	// 処理結果
    	return new ResponseEntity<ResponseInvoice>(responseInvoice, status);
    }

    @RequestMapping(method=RequestMethod.GET)
    public List<InvoiceSelectEntity> search(@ModelAttribute SearchRequest search) {
    	List<InvoiceSelectEntity> invoiceResult = invoiceService.search(search.getInvoiceNo());
        return invoiceResult;
    }

}
