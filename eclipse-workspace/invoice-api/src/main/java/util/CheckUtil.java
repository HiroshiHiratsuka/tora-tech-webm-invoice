package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import application.entity.InvoiceErrorEntity;
import application.request.RergistrationRequest;

public class CheckUtil {

	// エラーチェック
	public static List<InvoiceErrorEntity> checkInputData (RergistrationRequest registration) {
    	// 戻り値用変数
    	List<InvoiceErrorEntity> invoiceErrorList = new ArrayList<InvoiceErrorEntity>();

    	// 必須チェック
		InvoiceErrorEntity error = isNotNull(registration.getInvoiceCreateDate(), "請求書作成日", "invoice_create_date");
    	if (error != null) {
    		invoiceErrorList.add(error);    		
    	} else {
    		// フォーマットチェック
    		error = checkFormat(registration.getInvoiceCreateDate(), "請求書作成日", "invoice_create_date");
    		if (error != null) invoiceErrorList.add(error);
    	}
		return invoiceErrorList;
	}

	// 必須エラーチェック
	private static InvoiceErrorEntity isNotNull (String targetStr, String itemName, String colmunName) {
    	if (null != targetStr && targetStr.length() == 0) {
    		// エラー内容設定
    		InvoiceErrorEntity error = new InvoiceErrorEntity();
    		error.setErrorCode("40001");
    		error.setErrorDetail(itemName + "（" + colmunName + "）");
    		error.setErrorMessage("[" + itemName + "]は必須入力です。");
    		return error;
    	}
		return null;
	}

	// フォーマットエラーチェック
	private static InvoiceErrorEntity checkFormat (String targetStr, String itemName, String colmunName) {
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		try {
    		// フォーマット確認
		    format.setLenient(false);
		    format.parse(targetStr);
		} catch (ParseException e) {
    		// エラー内容設定
    		InvoiceErrorEntity error = new InvoiceErrorEntity();
    		error.setErrorCode("40002");
    		error.setErrorDetail(itemName + "（" + colmunName + "）");
    		error.setErrorMessage("[" + itemName + "]のフォーマットが不正です。");
    		return error;
		}
		return null;
	}
}
