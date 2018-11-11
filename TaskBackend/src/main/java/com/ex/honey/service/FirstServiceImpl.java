package com.ex.honey.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.*;
import org.springframework.stereotype.Service;

@Service
public class FirstServiceImpl implements FirstService {

	
	Map<String, String> money;
	
	public String returnResult(String Sentence) {
		// TODO Auto-generated method stub
		Map<String, Integer> value = new HashMap();
		value.put("I",1);
		value.put("IV",4);
		value.put("V",5);
		value.put("IX",9);
		value.put("X",10);
		value.put("XL",40);
		value.put("L",50);
		value.put("XC",90);
		value.put("C",100);
		value.put("CD",400);
		value.put("D",500);
		value.put("CM",900);
		value.put("M",1000);
		
		money = new HashMap<String, String>();
		money.put("glob", "I");
		money.put("prok", "V");
		money.put("pish", "X");
		money.put("tegj", "L");
		money.put("groot", "C");
		money.put("quill", "D");
		money.put("gamora", "M");
		
		Map<String, Double> precious = new HashMap();
		precious.put("silver", 17.00);
		precious.put("gold", 14450.0);
		precious.put("iron", 195.5);
		
		
		
		String[] line = Sentence.split(" ");
		List<String> count = new ArrayList();
		List<String> resultWord = new ArrayList();
		double multiply = 1.00;
		for(String getWord : line) {
			if(money.containsKey(getWord)) {
				count.add(money.get(getWord));
				resultWord.add(getWord);
			}else if(precious.containsKey(getWord.toLowerCase())) {
				if(getWord.equalsIgnoreCase("Silver")) {
					multiply = 17.00;
				}else if(getWord.equalsIgnoreCase("Gold")) {
					multiply = 14450.0;
				}else {
					multiply = 195.5;
				}
				resultWord.add(getWord);
			}
		}
		
		String newSentence ="";
		for(String b: resultWord) {
			newSentence +=b +"\t";
		}
		
		int res =0;
		for(int i=0;i<count.size()-1;) {
			
			int val = value.get(count.get(i));
			int valnext = value.get(count.get(i+1));			
				String rom = count.get(i).concat(count.get(i+1));
				if(value.get(rom)!=null) {
					res+=value.get(rom);
					i+=2;
				}else {
					res+=val;
					i+=1;
				}
				
				if(i == count.size()-1) {
					res+=value.get(count.get(count.size()-1));
				}
			System.out.println(res +" = "+valnext+"  "+ val);
			System.out.println(i +" of "+count.size());
		}
		double total = Double.valueOf(res) * multiply;
		return newSentence.concat("  is ").concat(String.valueOf(total));
	}

	


	public void setMoney(HashMap<String, String> moneyName) {
		// TODO Auto-generated method stub
		money = moneyName;
		/*money.put("glob", "I");
		money.put("prok", "V");
		money.put("pish", "X");
		money.put("tegj", "L");
		money.put("groot", "C");
		money.put("quill", "D");
		money.put("gamora", "M");*/
		
	}

}
