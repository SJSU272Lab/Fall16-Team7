package com.smart.cloudantDB;

public class DataAnalysisInfo {
	private String _id;
	private String _rev;
	private String zipcode;
	private String income;
	private String age;
	private String gender;
	private String shopping_way;
	private String shopping_content;
		
	/**
	 * default constructor
	 */
	public DataAnalysisInfo() {
		this.zipcode = "";
		this.income = "";
		this.age = "";
		this.gender = "";
		this.shopping_way = "";
		this.shopping_content = "";
		this._id = null;
		this._rev = null;
	}

	/**
	 * DataAnalysisInfo Constructor;
	 * 
	 * @param zipcode
	 * @param income
	 * @param age
	 * @param gender
	 * @param shopping_way
	 * @param shopping_content
	 */
	public DataAnalysisInfo(String zipcode, String income, String age, String gender, String shopping_way,
			String shopping_content) {
		this.zipcode = zipcode;
		this.income = income;
		this.age = age;
		this.gender = gender;
		this.shopping_way = shopping_way;
		this.shopping_content = shopping_content;
	}
	
	public DataAnalysisInfo(String id, String zipcode, String income, String age, String gender, String shopping_way,
			String shopping_content) {
		this._id = id;
		this.zipcode = zipcode;
		this.income = income;
		this.age = age;
		this.gender = gender;
		this.shopping_way = shopping_way;
		this.shopping_content = shopping_content;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getIncome() {
		return income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getShopping_way() {
		return shopping_way;
	}

	public void setShopping_way(String shopping_way) {
		this.shopping_way = shopping_way;
	}

	public String getShopping_content() {
		return shopping_content;
	}

	public void setShopping_content(String shopping_content) {
		this.shopping_content = shopping_content;
	}	
	
	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String get_rev() {
		return _rev;
	}

	public void set_rev(String _rev) {
		this._rev = _rev;
	}

	/**
	 * get the age of the customer.
	 * @return if no information in the age return -1 or it will return the number of age.
	 */
	public int getAgeInt() {
		int temp = -1;
		if (age != null && age.equals("") == false) {
			temp = Integer.parseInt(age);
		}
		return temp;
	}
	
	/**
	 * get the income of the customer.
	 * @return if no information in the age return -1 or it will return the number of income.
	 */
	public int getIncomeInt() {
		int temp = -1;
		if (income != null && income.equals("") == false) {
			temp = Integer.parseInt(income);
		}
		return temp;
	}
	
	public String toString() {
		String st = "{\n" +
				"  \"_id\":" + _id + ",\n" +
                "  \"zipcode\":" + zipcode + ",\n" +
                "  \"income\":" + income + ",\n" +
                "  \"age\":" + age + ",\n" +
                "  \"gender\":" + gender + ",\n" +
                "  \"shopping_way\":" + shopping_way + ",\n" +
                "  \"shopping_content\":" +  shopping_content + " \n" +
                "}";
		return st;
	}
}
