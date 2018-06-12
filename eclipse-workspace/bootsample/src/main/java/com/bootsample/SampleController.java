package com.bootsample;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.RergistrationEntity;
import entity.SearchEntity;

@Controller
@EnableAutoConfiguration
public class SampleController {

	@CrossOrigin
    @RequestMapping(value="/")
    @ResponseBody
    List<SearchEntity> home() {    	
    	List<SearchEntity> returnList = new ArrayList<SearchEntity>();
    	
    	SearchEntity entity = new SearchEntity();
    	entity.setTest("test1");
    	returnList.add(entity);
    	entity.setTest("test2");
    	returnList.add(entity);
    	
    	
        return returnList;
    }

	@CrossOrigin
    @RequestMapping(value="/param")
    @ResponseBody
    public List<Map<String, String>> hogehoge(@RequestParam("param") String param) {
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> map1 = new HashMap<String, String>();
		Map<String, String> map2 = new HashMap<String, String>();
		map1.put("map1-1", param);
		map1.put("map1-2", "value2");
		map1.put("map1-3", "value3");
		map2.put("map2-1", "value4");
		map2.put("map2-2", "value5");
		
		list.add(map1);
		list.add(map2);
		
        return list;
    }

	@CrossOrigin
    @RequestMapping(value="/registration")
    @ResponseBody
    public List<Map<String, String>> registration(@RequestBody RergistrationEntity registration) {
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> map1 = new HashMap<String, String>();
		Map<String, String> map2 = new HashMap<String, String>();
		map1.put("map1-1", "registration");
		map1.put("map1-2", "value2");
		map1.put("map1-3", "value3");
		map2.put("map2-1", "value4");
		map2.put("map2-2", "value5");
		
		list.add(map1);
		list.add(map2);
		
        return list;
    }

	@CrossOrigin
    @RequestMapping(value="/search")
    @ResponseBody
    public List<Map<String, String>> search(@RequestBody SearchEntity search) {
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("map1", search.getTest()+"1");
		map1.put("map1", search.getTest()+"2");
		map1.put("map1", search.getTest()+"3");
		
		list.add(map1);
		
        return list;
    }

	public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}
