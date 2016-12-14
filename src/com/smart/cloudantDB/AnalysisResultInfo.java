package com.smart.cloudantDB;

public class AnalysisResultInfo {
	private String shopping_content;
	private String zipcode;
	private double evaluation;
	private String description;
	private String _id;
	private String _rev;
	
	public AnalysisResultInfo() {
		this.shopping_content = "";
		this.zipcode = "";
		this.evaluation = 0;
		this.description = "";
		this._id = null;
	}
	
	public AnalysisResultInfo(String shopping_content, String zipcode, double evaluation, String description) {
		this.shopping_content = shopping_content;
		this.zipcode = zipcode;
		this.evaluation = evaluation;
		this.description = description;
		this._id = null;
		this._rev = null;
	}

	public String getShopping_content() {
		return shopping_content;
	}

	public void setShopping_content(String shopping_content) {
		this.shopping_content = shopping_content;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public double getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(double evaluation) {
		this.evaluation = evaluation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String toString() {
		String st = "{\n" +
				"  \"_id\":" + _id + ",\n" +
				"  \"_rev\":" + _rev + ",\n" +
                "  \"shopping_content\":" + shopping_content + ",\n" +
                "  \"zipcode\":" + zipcode + ",\n" +
                "  \"evaluation\":" + evaluation + ",\n" +
                "  \"description\":" + description + " \n" +
                "}";
		return st;
	}	
}
