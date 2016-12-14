package com.smart.cloudantDB;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestGaussianInsert {

	@Test
	public void test() {
		DatabaseSparkOperation dbOperation = new DatabaseSparkOperation();
		dbOperation.createIndex("zipcode");
		GaussianInsert gaussianInsert = new GaussianInsert();
		int number = 100;
		int i = 0, j = 0;
		int lengthZipArray = gaussianInsert.getZipcode().length;
		for(i = 0; i < lengthZipArray; i++) {
			ArrayList<DataAnalysisInfo> list = new ArrayList<DataAnalysisInfo>();
			for (j = 0; j < number; j++) {
				DataAnalysisInfo dataInfoTemp = new DataAnalysisInfo();
				String zip = gaussianInsert.getZipcode()[i];
				dataInfoTemp.setZipcode(zip);
				list.add(dataInfoTemp);
			}
			switch(i) {
			case 0: 
				{
					ArrayList<DataAnalysisInfo> tempList = new ArrayList<DataAnalysisInfo>();
					int miu = 107493, sithe = 10;
					tempList = gaussianInsert.getGaussianIncome(list, miu, sithe);
					list = tempList;
					tempList = gaussianInsert.getRatioShoppingContent(list, 40, 20, 20, 20);
					list = tempList;
					tempList = gaussianInsert.getRandomGender(list);
					list = tempList;
					tempList = gaussianInsert.getRandomAge(list);
					list = tempList;
					tempList = gaussianInsert.getRandomShoppingWay(list);
					list = tempList;
					int len = list.size();
					for (int m = 0; m < len; m++) {
						DataAnalysisInfo dataInfo = list.get(m);
						ArrayList<String> resultToDb = new ArrayList<String>();
						String zipCode = dataInfo.getZipcode();
						String income = dataInfo.getIncome();
						String age = dataInfo.getAge();
						String gender = dataInfo.getGender();
						String shopping_way = dataInfo.getShopping_way();
						String shopping_content = dataInfo.getShopping_content();
						resultToDb.add(zipCode);
						resultToDb.add(income);
						resultToDb.add(age);
						resultToDb.add(gender);
						resultToDb.add(shopping_way);
						resultToDb.add(shopping_content);
						dbOperation.insert(resultToDb);
						System.out.println("insert records: " + m + " zip: " + gaussianInsert.getZipcode()[i]);
					}
					break;
				}
			case 1: 
				{
					ArrayList<DataAnalysisInfo> tempList = new ArrayList<DataAnalysisInfo>();
					int miu = 72459, sithe = 10;
					tempList = gaussianInsert.getGaussianIncome(list, miu, sithe);
					list = tempList;
					tempList = gaussianInsert.getGaussianShoppingContent(list, 3, 1);
					list = tempList;
					tempList = gaussianInsert.getRatioGender(list, 60, 40);
					list = tempList;
					tempList = gaussianInsert.getRandomAge(list);
					list = tempList;
					tempList = gaussianInsert.getRandomShoppingWay(list);
					list = tempList;
					int len = list.size();
					for (int m = 0; m < len; m++) {
						DataAnalysisInfo dataInfo = list.get(m);
						ArrayList<String> resultToDb = new ArrayList<String>();
						String zipCode = dataInfo.getZipcode();
						String income = dataInfo.getIncome();
						String age = dataInfo.getAge();
						String gender = dataInfo.getGender();
						String shopping_way = dataInfo.getShopping_way();
						String shopping_content = dataInfo.getShopping_content();
						resultToDb.add(zipCode);
						resultToDb.add(income);
						resultToDb.add(age);
						resultToDb.add(gender);
						resultToDb.add(shopping_way);
						resultToDb.add(shopping_content);
						dbOperation.insert(resultToDb);
						System.out.println("insert records: " + m + " zip: " + gaussianInsert.getZipcode()[i]);
					}	
					break;
				}
			case 2: 
				{
					ArrayList<DataAnalysisInfo> tempList = new ArrayList<DataAnalysisInfo>();
					int miu = 49454, sithe = 10;
					tempList = gaussianInsert.getGaussianIncome(list, miu, sithe);
					list = tempList;
					tempList = gaussianInsert.getGaussianShoppingContent(list, 3, 1);
					list = tempList;
					tempList = gaussianInsert.getRatioGender(list, 60, 40);
					list = tempList;
					tempList = gaussianInsert.getRandomAge(list);
					list = tempList;
					tempList = gaussianInsert.getRandomShoppingWay(list);
					list = tempList;
					int len = list.size();
					for (int m = 0; m < len; m++) {
						DataAnalysisInfo dataInfo = list.get(m);
						ArrayList<String> resultToDb = new ArrayList<String>();
						String zipCode = dataInfo.getZipcode();
						String income = dataInfo.getIncome();
						String age = dataInfo.getAge();
						String gender = dataInfo.getGender();
						String shopping_way = dataInfo.getShopping_way();
						String shopping_content = dataInfo.getShopping_content();
						resultToDb.add(zipCode);
						resultToDb.add(income);
						resultToDb.add(age);
						resultToDb.add(gender);
						resultToDb.add(shopping_way);
						resultToDb.add(shopping_content);
						dbOperation.insert(resultToDb);
						System.out.println("insert records: " + m + " zip: " + gaussianInsert.getZipcode()[i]);
					}	
					break;
				}
			case 3: 
				{
					ArrayList<DataAnalysisInfo> tempList = new ArrayList<DataAnalysisInfo>();
					int miu = 90881, sithe = 10;
					tempList = gaussianInsert.getGaussianIncome(list, miu, sithe);
					list = tempList;
					tempList = gaussianInsert.getRatioShoppingContent(list, 20, 50, 20, 10);
					list = tempList;
					tempList = gaussianInsert.getRandomGender(list);
					list = tempList;
					tempList = gaussianInsert.getRandomAge(list);
					list = tempList;
					tempList = gaussianInsert.getRandomShoppingWay(list);
					list = tempList;
					int len = list.size();
					for (int m = 0; m < len; m++) {
						DataAnalysisInfo dataInfo = list.get(m);
						ArrayList<String> resultToDb = new ArrayList<String>();
						String zipCode = dataInfo.getZipcode();
						String income = dataInfo.getIncome();
						String age = dataInfo.getAge();
						String gender = dataInfo.getGender();
						String shopping_way = dataInfo.getShopping_way();
						String shopping_content = dataInfo.getShopping_content();
						resultToDb.add(zipCode);
						resultToDb.add(income);
						resultToDb.add(age);
						resultToDb.add(gender);
						resultToDb.add(shopping_way);
						resultToDb.add(shopping_content);
						dbOperation.insert(resultToDb);
						System.out.println("insert records: " + m + " zip: " + gaussianInsert.getZipcode()[i]);
					}
					break;
				}
			case 4: 
				{
					ArrayList<DataAnalysisInfo> tempList = new ArrayList<DataAnalysisInfo>();
					int miu = 236912, sithe = 10;
					tempList = gaussianInsert.getGaussianIncome(list, miu, sithe);
					list = tempList;
					tempList = gaussianInsert.getGaussianShoppingContent(list, 0, 1);
					list = tempList;
					tempList = gaussianInsert.getRandomGender(list);
					list = tempList;
					tempList = gaussianInsert.getRandomAge(list);
					list = tempList;
					tempList = gaussianInsert.getRatioShoppingWay(list, 60, 40);
					list = tempList;
					int len = list.size();
					for (int m = 0; m < len; m++) {
						DataAnalysisInfo dataInfo = list.get(m);
						ArrayList<String> resultToDb = new ArrayList<String>();
						String zipCode = dataInfo.getZipcode();
						String income = dataInfo.getIncome();
						String age = dataInfo.getAge();
						String gender = dataInfo.getGender();
						String shopping_way = dataInfo.getShopping_way();
						String shopping_content = dataInfo.getShopping_content();
						resultToDb.add(zipCode);
						resultToDb.add(income);
						resultToDb.add(age);
						resultToDb.add(gender);
						resultToDb.add(shopping_way);
						resultToDb.add(shopping_content);
						dbOperation.insert(resultToDb);
						System.out.println("insert records: " + m + " zip: " + gaussianInsert.getZipcode()[i]);
					}
					break;
				}
			case 5: 
				{
					ArrayList<DataAnalysisInfo> tempList = new ArrayList<DataAnalysisInfo>();
					int miu = 228587, sithe = 10;
					tempList = gaussianInsert.getGaussianIncome(list, miu, sithe);
					list = tempList;
					tempList = gaussianInsert.getGaussianShoppingContent(list, 1, 1);
					list = tempList;
					tempList = gaussianInsert.getRandomGender(list);
					list = tempList;
					tempList = gaussianInsert.getRandomAge(list);
					list = tempList;
					tempList = gaussianInsert.getRandomShoppingWay(list);
					list = tempList;
					int len = list.size();
					for (int m = 0; m < len; m++) {
						DataAnalysisInfo dataInfo = list.get(m);
						ArrayList<String> resultToDb = new ArrayList<String>();
						String zipCode = dataInfo.getZipcode();
						String income = dataInfo.getIncome();
						String age = dataInfo.getAge();
						String gender = dataInfo.getGender();
						String shopping_way = dataInfo.getShopping_way();
						String shopping_content = dataInfo.getShopping_content();
						resultToDb.add(zipCode);
						resultToDb.add(income);
						resultToDb.add(age);
						resultToDb.add(gender);
						resultToDb.add(shopping_way);
						resultToDb.add(shopping_content);
						dbOperation.insert(resultToDb);
						System.out.println("insert records: " + m + " zip: " + gaussianInsert.getZipcode()[i]);
					}
					break;
				}
			case 6: 
				{
					ArrayList<DataAnalysisInfo> tempList = new ArrayList<DataAnalysisInfo>();
					int miu = 107493, sithe = 10;
					tempList = gaussianInsert.getGaussianIncome(list, miu, sithe);
					list = tempList;
					tempList = gaussianInsert.getGaussianShoppingContent(list, 2, 1);
					list = tempList;
					tempList = gaussianInsert.getRandomGender(list);
					list = tempList;
					tempList = gaussianInsert.getRandomAge(list);
					list = tempList;
					tempList = gaussianInsert.getRandomShoppingWay(list);
					list = tempList;
					int len = list.size();
					for (int m = 0; m < len; m++) {
						DataAnalysisInfo dataInfo = list.get(m);
						ArrayList<String> resultToDb = new ArrayList<String>();
						String zipCode = dataInfo.getZipcode();
						String income = dataInfo.getIncome();
						String age = dataInfo.getAge();
						String gender = dataInfo.getGender();
						String shopping_way = dataInfo.getShopping_way();
						String shopping_content = dataInfo.getShopping_content();
						resultToDb.add(zipCode);
						resultToDb.add(income);
						resultToDb.add(age);
						resultToDb.add(gender);
						resultToDb.add(shopping_way);
						resultToDb.add(shopping_content);
						dbOperation.insert(resultToDb);
						System.out.println("insert records: " + m + " zip: " + gaussianInsert.getZipcode()[i]);
					}
					break;
				}
			case 7: 
				{
					ArrayList<DataAnalysisInfo> tempList = new ArrayList<DataAnalysisInfo>();
					int miu = 29197, sithe = 10;
					tempList = gaussianInsert.getGaussianIncome(list, miu, sithe);
					list = tempList;
					tempList = gaussianInsert.getGaussianShoppingContent(list, 3, 1);
					list = tempList;
					tempList = gaussianInsert.getRandomGender(list);
					list = tempList;
					tempList = gaussianInsert.getRandomAge(list);
					list = tempList;
					tempList = gaussianInsert.getRandomShoppingWay(list);
					list = tempList;
					int len = list.size();
					for (int m = 0; m < len; m++) {
						DataAnalysisInfo dataInfo = list.get(m);
						ArrayList<String> resultToDb = new ArrayList<String>();
						String zipCode = dataInfo.getZipcode();
						String income = dataInfo.getIncome();
						String age = dataInfo.getAge();
						String gender = dataInfo.getGender();
						String shopping_way = dataInfo.getShopping_way();
						String shopping_content = dataInfo.getShopping_content();
						resultToDb.add(zipCode);
						resultToDb.add(income);
						resultToDb.add(age);
						resultToDb.add(gender);
						resultToDb.add(shopping_way);
						resultToDb.add(shopping_content);
						dbOperation.insert(resultToDb);
						System.out.println("insert records: " + m + " zip: " + gaussianInsert.getZipcode()[i]);
					}
					break;
				}
			default:
				{
					;
				}
			}
		}
	}
}
