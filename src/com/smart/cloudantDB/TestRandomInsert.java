package com.smart.cloudantDB;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestRandomInsert {

	@Test
	public void test() {
		String zipcode = "";
		String income = "";
		String age = "";
		String gender = "";
		String shopping_way = "";
		String shopping_content = ""; 
		int i = 0;
		int n = 10;
		
		DataAnalysisInfo dataInfo = new DataAnalysisInfo(zipcode, income, age, gender, shopping_way, shopping_content);
		DatabaseSparkOperation dbOperation = new DatabaseSparkOperation();
		
		for(i = 0; i < n; i++) {
			ArrayList<String> list = new ArrayList<String>();
			RandomInsert randomInsert = new RandomInsert();
			zipcode = randomInsert.getRandomZipCode();
			income = randomInsert.getRandomIncome();
			age = randomInsert.getRandomAge();
			gender = randomInsert.getRandomGender();
			shopping_way = randomInsert.getRandomShoppingWay();
			shopping_content = randomInsert.getRandomShoppingContent();
			list.add(zipcode);
			list.add(income);
			list.add(age);
			list.add(gender);
			list.add(shopping_way);
			list.add(shopping_content);
			dbOperation.insert(list);
			System.out.println("insert records: " + i);
		}
	}
}
