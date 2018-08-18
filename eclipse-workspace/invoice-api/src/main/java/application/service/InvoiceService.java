package application.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.entity.InvoiceEntity;
import application.entity.InvoiceErrorEntity;
import application.entity.InvoiceSelectEntity;
import application.entity.InvoiceSelectMaxNoEntity;
import application.repository.InvoiceInsertRepository;
import application.repository.InvoiceSelectRepository;
import application.repository.InvoiceSelectMaxNoRepository;
import application.request.RergistrationRequest;
import application.respons.ResponseInvoice;
import application.result.InvoiceResult;
import util.CheckUtil;

@Service
public class InvoiceService {

    @Autowired
    InvoiceSelectRepository repoSelect;
    @Autowired
    InvoiceSelectMaxNoRepository repoSelectMaxNo;
    @Autowired
    InvoiceInsertRepository repoInsert;
 
    public ResponseInvoice registration(RergistrationRequest registration) {
    	// 戻り値用変数
    	List<InvoiceResult> invoiceResultList = new ArrayList<InvoiceResult>();
    	List<InvoiceErrorEntity> invoiceErrorList = new ArrayList<InvoiceErrorEntity>();

    	// 入力値確認
    	invoiceErrorList = CheckUtil.checkInputData(registration);
    	if (!invoiceErrorList.isEmpty())
    		return new ResponseInvoice(invoiceErrorList, invoiceResultList);
    	
    	// 実行日時取得
    	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    	
    	try {
        	// 請求書管理番号の最大値取得
        	InvoiceSelectMaxNoEntity maxNo = repoSelectMaxNo.findByInvoiceNo();

        	// 登録する請求書の請求書管理番号を算出
        	int invoiceNo = 0;
        	if (null != maxNo && maxNo.getInvoiceNo() > 0) invoiceNo = maxNo.getInvoiceNo() + 1;
        	
        	// 請求書の登録値設定
        	InvoiceEntity invoice = new InvoiceEntity();
        	invoice.setInvoiceNo(invoiceNo);
        	invoice.setClientNo(99);
        	invoice.setInvoiceStatus(97);
        	invoice.setInvoiceCreateDate(new Date(timestamp.getTime()));
        	invoice.setInvoiceTitle("test1");
        	invoice.setInvoiceAmt(96);
        	invoice.setTaxAmt(95);
        	invoice.setInvoiceStartDate(new Date(timestamp.getTime()));
        	invoice.setInvoiceEndDate(new Date(timestamp.getTime()));
        	invoice.setInvoiceNote("test2");
        	invoice.setCreateUser("test3");
        	invoice.setCreateDatetime(timestamp);
        	invoice.setUpdateUser("test4");
        	invoice.setUpdateDatetime(timestamp);
        	invoice.setDelFlg(9);

        	// 請求書の登録
        	repoInsert.save(invoice);
        	
        	// 登録結果の設定
        	InvoiceResult result = new InvoiceResult();
        	result.setInvoiceNo(String.valueOf(invoice.getInvoiceNo()));
        	result.setInvoiceStatus(String.valueOf(invoice.getInvoiceStatus()));
        	result.setInvoiceCreateDate(String.valueOf(invoice.getInvoiceCreateDate()));
        	result.setInvoiceTitle(invoice.getInvoiceTitle());
        	result.setInvoiceAmt(String.valueOf(invoice.getInvoiceAmt()));
        	result.setTaxAmt(String.valueOf(invoice.getTaxAmt()));
        	result.setInvoiceStartDate(String.valueOf(invoice.getInvoiceStartDate()));
        	result.setInvoiceEndDate(String.valueOf(invoice.getInvoiceEndDate()));
        	result.setInvoiceNote(invoice.getInvoiceNote());
        	result.setCreateUser(invoice.getCreateUser());
        	result.setCreateDatetime(String.valueOf(invoice.getCreateDatetime()));
        	result.setUpdateUser(invoice.getUpdateUser());
        	result.setUpdateDatetime(String.valueOf(invoice.getUpdateDatetime()));
        	invoiceResultList.add(result);
    	} catch(Exception e) {
    		// エラー情報の設定
    		InvoiceErrorEntity error = new InvoiceErrorEntity();
    		error.setErrorCode("50001");
    		error.setErrorDetail("請求書の登録に失敗しました。");
    		error.setErrorMessage("予期しないエラーが発生しました。");
    		invoiceErrorList.add(error);
    	}
    	return new ResponseInvoice(invoiceErrorList, invoiceResultList);

    }
    
    public List<InvoiceSelectEntity> search(String no) {
    	List<InvoiceSelectEntity> invoice = new ArrayList<InvoiceSelectEntity>();
    	if (no.length() == 0) {
    		// 全件
        	invoice = repoSelect.selectAll();
    	} else {
    		// 請求書管理番号指定
        	invoice = repoSelect.findByInvoiceNo(Integer.parseInt(no));
    	}
		return invoice;
    }
}
