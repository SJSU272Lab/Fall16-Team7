package com.smart.cloudantDB;

import java.util.ArrayList;

public interface DatabaseOperation<T> {
	
	/**
	 * insert a new element to the database.
	 * @param list
	 */
	public void insert(ArrayList<T> list);
	
	/**
	 * select all the elements conform to the condition
	 * @param property1
	 * @param operation: eq gt lt gte lte;
	 * @param property2
	 * @return
	 */
	public ArrayList<T> select(String property1, String operation, String property2);
	
	/**
	 * delete an item based on the _id of the element;
	 * @param _id
	 */
	public void delete(String _id);
}
