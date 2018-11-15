package com.ex.honey.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.*;
import org.springframework.stereotype.Service;

@Service
public class FirstServiceImpl implements FirstService {

	
	Map<String, String> money = new HashMap<String, String>(); 
	Map<String, Double> precious = new HashMap();
	Map<String, Integer> value = new HashMap();
	
	
	public String returnResult(String[] Sentence) {		
		
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
		
		String[] line = Sentence;
		
		List<String> count = new ArrayList();
		List<String> resultWord = new ArrayList();
		double multiply = 1.00;
		for(String getWord : line) {
			if(money.containsKey(getWord)) {
				count.add(money.get(getWord));
				resultWord.add(getWord);
			}else if(precious.containsKey(getWord.toLowerCase())) {
				try {
					System.out.println();
					multiply = precious.get(getWord.toLowerCase());
				} catch (Exception e) {
					// TODO: handle exception
					multiply = 1.00;
				}
								
				resultWord.add(getWord);
			}
		}
		
		String newSentence ="";
		for(String b: resultWord) {
			newSentence +=b +"\t";
		}
		
		int res =0;
		try {
			if(count.size()>1) {
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
				}
			}else {
				res = value.get(count.get(0));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			return "I have no Idea";
		}
		
		double total = Double.valueOf(res) * multiply;
		return newSentence.concat("  is ").concat(String.valueOf(total));
	}

	public void setMoney(String setMoney, String charRoman) {
		// TODO Auto-generated method stub	
		try {
			Iterator<String> iterator = money.keySet().iterator();
			while(iterator.hasNext()) {
				String gotDouble = iterator.next();
				System.out.println(gotDouble + "   "+money.get(gotDouble));
				if(money.get(gotDouble).equalsIgnoreCase(charRoman)) {
					System.out.println("masuk");
					money.remove(gotDouble);
				}
			}		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
			
		money.put(setMoney, charRoman.toUpperCase());		
	}
	
	
	public void resetMoney() {
		
		money = new HashMap<String, String>();
		precious = new HashMap<String, Double>();
		System.out.println("masuk");
	}
	
	
	public void setPrecious(String setPrecious, double value) {
		
		precious.put(setPrecious, value);
	}


	public String checkWord(String word) {
		// TODO Auto-generated method stub
		Map<String,String> charRoman = new HashMap<String, String>();
		charRoman.put("I", "I");
		charRoman.put("V", "V");
		charRoman.put("X", "X");
		charRoman.put("L", "L");
		charRoman.put("C", "C");
		charRoman.put("D", "D");
		charRoman.put("M", "M");
		
		String thingFullofWord ="";
		
		String[] wordResult = word.split(" ");
		int lastIndex = wordResult.length;
		int positionPoint = 0;
		for(int i =0;i<wordResult.length;i++) {
			if(wordResult[i].equalsIgnoreCase("is") && i<lastIndex) {
				positionPoint = i;
			}else {
				
			}
		}
		if(positionPoint != 0) {
			String valueWord = wordResult[positionPoint+1].replace(",", ".");
			String keyWord = wordResult[positionPoint-1];
			System.out.println(valueWord);
			System.out.println(keyWord);
			
			if(checkInteger(valueWord)) {
				setPrecious(keyWord, Double.parseDouble(valueWord));
			}else if(checkDouble(valueWord)) {
				setPrecious(keyWord, Double.parseDouble(valueWord));
			}else if(charRoman.get(valueWord.toUpperCase())!=null) {
				setMoney(keyWord,valueWord);
				thingFullofWord = "congratulation your "+keyWord+" has been saved";
			}
		}else {
			thingFullofWord = returnResult(wordResult);
		}		
		
		return thingFullofWord;
	}
	
	public boolean checkInteger(String number) {
		boolean isInteger = true;		
		try {
			int numb = Integer.parseInt(number);			
		} catch (Exception e) {
			// TODO: handle exception
			isInteger = false;
		}
		return isInteger;		
	}
	
	public boolean checkDouble(String number) {
		boolean isDouble = true;		
		try {
			double numb = Double.valueOf(number);			
		} catch (Exception e) {
			// TODO: handle exception
			isDouble = false;
		}
		return isDouble;
		
	}

	public Map<String, String> getListMoney() {
		// TODO Auto-generated method stub
		return money;
	}


	public Map<String, String> getListPrecious() {
		// TODO Auto-generated method stub
		Map<String, String> convert = new HashMap<String, String>();
		Iterator<String> iterator = precious.keySet().iterator();
		while(iterator.hasNext()) {
			String gotDouble = iterator.next();
			convert.put(gotDouble, String.valueOf(precious.get(gotDouble)));
		}	
		return convert;
	}

}
