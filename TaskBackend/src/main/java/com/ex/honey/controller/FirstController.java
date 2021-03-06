package com.ex.honey.controller;

import java.util.HashMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.ex.honey.service.FirstServiceImpl;

@Controller
public class FirstController {

	private FirstServiceImpl firstServiceImpl = new FirstServiceImpl();
	
	@RequestMapping("/")
    public String welcome(Model model) {        
        model.addAttribute("word", new String());    
        model.addAttribute("map", new HashMap<String, String>());   
        return "welcome";
        
    }
	
	@RequestMapping(value = "/sendRequest",method = RequestMethod.POST)
    public String sendRequest(@RequestParam(value="word", required=false)String word, Model model) {

		model.addAttribute("prec",firstServiceImpl.getListPrecious()); 
		model.addAttribute("map", firstServiceImpl.getListMoney()); 
		model.addAttribute("result", firstServiceImpl.checkWord(word)); 
       return "welcome";
        
    }
		
	@RequestMapping(value = "/sendMap",method = RequestMethod.POST)
    public String sendMap(@RequestParam(value="word", required=false)String word, Model model) {
        
		model.addAttribute("result", word); 
        return "welcome";
        
    }
	
	@RequestMapping(value = "/reset",method = RequestMethod.POST)
	public String resetMoney() {
		firstServiceImpl.resetMoney();
		return "welcome";
		
	}
}
