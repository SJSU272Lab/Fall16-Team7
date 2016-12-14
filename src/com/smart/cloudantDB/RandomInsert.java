package com.smart.cloudantDB;

import java.util.Random;

public class RandomInsert {
	private String[] firstName = {"Aaberg", "Aaby", "Aadland", "Aagaard", "Aaker", "Aakre", "Aamodt", "Babey", 
			"Babiak", "Babiarz", "Babik", "Babinec", "Babish", "Bable", "Bartholomew", "Bart", "Barton",
			"Bartley", "Basil", "Beacher", "Beau"};
	
	private String[] lastName = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wison",
			"Moore", "Taylor", "Anderson", "Thomas", "Jackson", "White", "Harris", "Martin", "Thompson",
			"Garcia", "Martinez", "Robinson", "Clark", "Rodriduez", "Lewis", "Lee", "Walker", "Hall",
			"Allen", "Young", "King", "Wright", "Lopez", "Hill", "Scott", "Green", "Adams", "Baker",
			"Gonzalez", "Nelson", "Carter", "Mitchell", "Perez", "Roberts", "Turner" };
	
	private String[] shopping_way = {"Online", "Offline"};
	
	private String[] shopping_content = {"Milk powder", "Badmin Racket", "Apple MacPro", "Orange Juice"};
	
	private String[] gender = {"male", "female"};
	
	private String zipcode = "9";
	
	public RandomInsert() {
		getRandomZipCode();
	}
	
	public String getRandomZipCode() {
		int i = 0;
		int n = 2;
		Random random = new Random();
		while (i < n) {
			int temp = random.nextInt(10);
			this.zipcode += String.valueOf(temp);
			i++;
		}
		return this.zipcode;
	}
	
	public String getRandomName() {
		Random random = new Random();
		int firstArrayListN = this.firstName.length;
		int secondArrayListN = this.lastName.length;
		int temp1 = random.nextInt(firstArrayListN);
		int temp2 = random.nextInt(secondArrayListN);
		String name = firstName[temp1] + lastName[temp2];
		return name;
	}
	
	public String getRandomIncome() {
		Random random = new Random();
		int temp = random.nextInt(1000000);
		return String.valueOf(temp);
	}
	
	public String getRandomAge() {
		Random random = new Random();
		int temp = random.nextInt(100);
		return String.valueOf(temp);
	}
	
	public String getRandomShoppingWay() {
		Random random = new Random();
		int temp = random.nextInt(2);
		return this.shopping_way[temp];
	}
	
	public String getRandomShoppingContent() {
		Random random  = new Random();
		int temp = random.nextInt(4);
		return this.shopping_content[temp];
	}
	
	public String getRandomGender() {
		Random random  = new Random();
		int temp = random.nextInt(2);
		return this.gender[temp];
	}
}
