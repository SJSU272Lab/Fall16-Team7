package com.cmpe272;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Item {
	public String ads = "";
	public String zipcode = "";
	public String income = "";
	public String age = "";
	public String gender = "";
	public String shoppingOnline = "";
	public String shoppingContent = "";
	public String des = "";
	public String u_id = "";
	
	public Item(DataAnalysisInfo d)
	{
		this.zipcode = d.getZipcode();
		this.income = d.getIncome();
		this.age = d.getAge();
		this.gender = d.getGender();
		this.shoppingOnline = d.getShopping_way();
		this.shoppingContent = d.getShopping_content();
	}
	
	public Item() {
		// TODO Auto-generated constructor stub
	}

	public void transform(BufferedWriter out) throws IOException {
		
		out.append(categorizeShoppingContent(shoppingContent) + " 1:" +categorizeZipcode(zipcode)+" 2:"+categorizeIncome(income)+" 3:"+categorizeAge(age)+" 4:"+categorizeGender(gender)+" 5:"+categorizeShoppingOnline(shoppingOnline)+"\n");
//		out.append(csq);
		
	}
	
	public String toString1()
	{
		return categorizeShoppingContent(shoppingContent)+"|"+categorizeIncome(income)+"\n";
//		return categorizeShoppingContent(shoppingContent)+"|"+income+"\n";
	}
	
	public String toString()
	{
		return zipcode+"|"+age+"|"+income+"|"+gender+"|"+shoppingOnline+"|"+shoppingContent+"\n";
	}
	
	public int categorizeAds(String ads){
		switch(ads)
		{
		case "Tea": return 0;
		case "Cola": return 1;
		
		}
		return -1;
	}
	
	public int categorizeZipcode(String zipcode){
		switch(zipcode)
		{
		case "95112": return 0;
		case "95129": return 1;
		case "95133": return 2;
		case "94027": return 3;
		case "95123": return 4;
		case "92145": return 5;
		case "95119": return 6;
		case "93706": return 7;
		}
		return -1;
	}
	
	public int categorizeIncome(String income){
		try{
		int come = Integer.parseInt(income);
		if(come >= 0 && come < 28000)
		{
			return 0;
		}
		if(come >= 28000 && come < 56000)
		{
			return 1;
		}
		if(come >= 56000 && come < 112000)
		{
			return 2;
		}
		if(come >= 112000 && come < 224000)
		{
			return 3;
		}
		if(come >= 224000 && come < 448000)
		{
			return 4;
		}}catch(Exception e)
		{
			return -1;
		}
		return -1;
		
	}	
	
	public int categorizeAge(String age){
		int ageI = Integer.parseInt(age);
		if(ageI >= 0 && ageI < 18)
		{
			return 0;
		}
		if(ageI >= 18 && ageI < 30)
		{
			return 1;
		}
		if(ageI >= 30 && ageI < 45)
		{
			return 2;
		}
		if(ageI >= 45 && ageI < 60)
		{
			return 3;
		}
		if(ageI >= 60 && ageI < 100)
		{
			return 4;
		}
		return -1;
	}
	
	public int categorizeGender(String gender){
		switch(gender)
		{
		case "male": return 0;
		case "female": return 1;
		}
		return -1;
	}
	
	public int categorizeShoppingOnline(String shoppingOnline){
		if(shoppingOnline.equalsIgnoreCase("online"))
		{
			return 0;
		}
		else{
			return 1;
		}
	}
	
	public int categorizeShoppingContent(String shoppingContent){
		switch(shoppingContent)
		{
		case "Tea": return 0;
		case "Cola": return 1;
		case "Badmin Racket": return 2;
		case "Apple MacPro": return 3;
		}
		return -1;
	}

	
}
