package com.smart.cloudantDB;

import java.util.ArrayList;
import java.util.Random;

public class GaussianInsert {
	private String[] shopping_way = {"Online", "Offline"};
	
	private String[] shopping_content = {"Tea", "Badmin Racket", "Apple MacPro", "Cola"};
	
	private String[] gender = {"male", "female"};
	
	private String[] zipcode = {"95129", "95133", "95112", "95123", "94027", "92145", "95119", "93706"};
	
	private Random random;
	private int miu;
	private int sithe;
	
	public GaussianInsert() {
		this.random = new Random();
		this.miu = 0;
		this.sithe = 1;
	}
	
	public int getGaussianNumber(int miu, int sithe) {
		double temp = Math.sqrt(this.random.nextGaussian());
		int result = (int)(sithe * temp + miu);
		return result;
	}
	
	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}

	public int getMiu() {
		return miu;
	}

	public void setMiu(int miu) {
		this.miu = miu;
	}

	public int getSithe() {
		return sithe;
	}

	public void setSithe(int sithe) {
		this.sithe = sithe;
	}
	
	public String[] getZipcode() {
		return zipcode;
	}

	public void setZipcode(String[] zipcode) {
		this.zipcode = zipcode;
	}
	
	/**
	 * set all the elements in the arraylist to random gender.
	 * @param list
	 * @return
	 */
	public ArrayList<DataAnalysisInfo> getRandomShoppingWay(ArrayList<DataAnalysisInfo> list) {
		Random random  = new Random();		
		int n = list.size();
		for (int i = 0; i < n; i++) {
			int temp = random.nextInt(2);
			list.get(i).setShopping_way(this.shopping_way[temp]);
		}
		return list;
	}
	
	public ArrayList<DataAnalysisInfo> getRandomAge(ArrayList<DataAnalysisInfo> list) {
		Random random  = new Random();
		int n = list.size();
		for (int i = 0; i < n; i++) {
			int temp = random.nextInt(60);
			list.get(i).setAge(String.valueOf(temp));
		}
		return list;
	}
	
	public ArrayList<DataAnalysisInfo> getRandomGender(ArrayList<DataAnalysisInfo> list) {
		Random random  = new Random();
		int n = list.size();
		for (int i = 0; i < n; i++) {
			int temp = random.nextInt(2);
			list.get(i).setGender(this.gender[temp]);
		}
		return list;
	}
	/**
	 * Get an ArrayList about DataAnalysisInfo which is a list with ratio (num1:num2)
	 * @param list
	 * @param num1
	 * @param num2
	 * @return an ArrayList with the ratio shoppingWay
	 */
	public ArrayList<DataAnalysisInfo> getRatioShoppingWay(ArrayList<DataAnalysisInfo> list, int num1, int num2) {
		int n = list.size();
		int i = 0;
		if ((num1 + num2) != n) {
			System.out.println("Input ratio error: " + num1 + ":" + " " + num2);
		}
		for (; i < num1; i++) {
			list.get(i).setShopping_way(shopping_way[0]);
		}
		int temp = i;
		for (; i < (temp + num2); i++) {
			list.get(i).setShopping_way(shopping_way[1]);
		}
		return list;
	}
	
	public ArrayList<DataAnalysisInfo> getRatioGender(ArrayList<DataAnalysisInfo> list, int num1, int num2) {
		int n = list.size();
		int i = 0;
		if ((num1 + num2) != n) {
			System.out.println("Input ratio error: " + num1 + ":" + " " + num2);
		}
		for (; i < num1; i++) {
			list.get(i).setGender(gender[0]);
		}
		int temp = i;
		for (; i < (temp + num2); i++) {
			list.get(i).setGender(gender[1]);
		}
		return list;
	}
	
	public ArrayList<DataAnalysisInfo> getRatioShoppingContent(ArrayList<DataAnalysisInfo> list, int num1, int num2, int num3, int num4) {
		int n = list.size();
		int i = 0;
		if ((num1 + num2 + num3 + num4) != n) {
			System.out.println("Input ratio error: " + num1 + ":" + " " + num2);
		}
		for (i = 0; i < num1; i++) {
			list.get(i).setShopping_content(shopping_content[0]);
		}
		int temp = i;
		for (; i < (temp + num2); i++) {
			list.get(i).setShopping_content(shopping_content[1]);
		}
		temp = i;
		for (; i < (temp + num3); i++) {
			list.get(i).setShopping_content(shopping_content[2]);
		}
		temp = i;
		for (; i < (temp + num4); i++) {
			list.get(i).setShopping_content(shopping_content[3]);
		}
		return list;
	} 
	
	/**
	 * get the Gaussian list of shopping_content;
	 * @param list
	 * @param miu
	 * @param sithe
	 * @return a new shopping with the miu shopping_content;
	 */
	public ArrayList<DataAnalysisInfo> getGaussianShoppingContent(ArrayList<DataAnalysisInfo> list, int miu, int sithe) {
		int gaussianResult = 0;
		int n = list.size();
		int i = 0;
		for (i = 0; i < n; i++) {
			while ((gaussianResult = getGaussianNumber(miu, sithe)) > 3);
//			System.out.println("Gaussian shopping content: " + shopping_content[gaussianResult]);
			list.get(i).setShopping_content(shopping_content[gaussianResult]);
		}
		return list;	
	}
	
	/**
	 * get the Gaussian list of income;
	 * @param list
	 * @param miu
	 * @param sithe
	 * @return a new shopping with the miu shopping_content;
	 */
	public ArrayList<DataAnalysisInfo> getGaussianIncome(ArrayList<DataAnalysisInfo> list, int miu, int sithe) {
		int gaussianResult = 0;
		int n = list.size();
		int i = 0;
		for (i = 0; i < n; i++) {
			gaussianResult = getGaussianNumber(miu, sithe);		
			list.get(i).setIncome(String.valueOf(gaussianResult));
		}
		return list;	
	}
}
