package application;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import application.entity.Invoice;
import application.entity.RergistrationEntity;
import application.entity.SearchEntity;
import application.respons.ResponseInvoice;
import application.service.InvoiceService;

@ComponentScan("application.service")
@SpringBootApplication
@Controller
@EnableAutoConfiguration
public class InvoiceApiController {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(InvoiceApiController.class, args);
	}

	@CrossOrigin
    @RequestMapping(value="/registration")
    @ResponseBody
    public List<Map<String, String>> registration(@RequestBody RergistrationEntity registration) {
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> map1 = new HashMap<String, String>();
		Map<String, String> map2 = new HashMap<String, String>();
		map1.put("map1-3", "value3");
		map2.put("map2-1", "value4");
		map2.put("map2-2", "value5");
		
		list.add(map1);
		list.add(map2);
		
        return list;
    }

    @Autowired
    public InvoiceService service;
    @Autowired
    public ResponseInvoice respons;
    
	@CrossOrigin
    @RequestMapping(value="/search")
    @ResponseBody
    public ResponseInvoice search(@RequestBody SearchEntity search) {
		
		Invoice invoice = service.search(Integer.parseInt(search.getInvoiceNo()));
		
		respons = new ResponseInvoice(null, null);		
        return respons;
    }
	
//	@CrossOrigin
//    @RequestMapping(value="/search")
//    @ResponseBody
//    public List<Map<String, String>> search() {
//		
//		List<Map<String, String>> responsList = new ArrayList<>();
//		Map<String, String> responsMap = new HashMap<String, String>();
//		
//		responsList.add(responsMap);
//		
//        return responsList;
//    }
}
