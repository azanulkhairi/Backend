package com.ex.honey.service;

import java.util.Map;

public interface FirstService {

	public String returnResult(String[] word);
	
	public void setMoney(String setMoney, String charRoman);
	
	public String checkWord(String word);
	
	public void setPrecious(String setPrecious, double value);
	
	public void resetMoney();
	
	public Map<String, String> getListMoney();
	
	public Map<String, String> getListPrecious();
}
