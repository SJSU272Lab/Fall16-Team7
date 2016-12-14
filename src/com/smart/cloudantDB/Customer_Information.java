package com.smart.cloudantDB;

public class Customer_Information {
	private String _id = null;
	private String _rev = null;
	private String name = null;
	private String zipcode = null;
	private String address = null;
	private long income = 0;
	
	public Customer_Information(String name, String zipcode, String address, int income) {
		// TODO Auto-generated constructor stub
		this._id = _id;
		this.name = name;
		this.zipcode = zipcode;
		this.address = address;
		this.income = income;
	}
	
	public Customer_Information(String id, String name, String zipcode, String address, int income) {
		// TODO Auto-generated constructor stub
		this._id = id;
		this.name = name;
		this.zipcode = zipcode;
		this.address = address;
		this.income = income;
	}
	
	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getIncome() {
		return income;
	}

	public void setIncome(long income) {
		this.income = income;
	}

	public String toString() {
		String st = "{\n" +
				"  \"_id\":" + _id + ",\n" +
                "  \"name\":" + name + ",\n" +
                "  \"zipcode\":" + zipcode + ",\n" +
                "  \"address\":" + address + ",\n" +
                "  \"income\":" +  income + " \n" +
                "}";
		return st;
	}
	
}
