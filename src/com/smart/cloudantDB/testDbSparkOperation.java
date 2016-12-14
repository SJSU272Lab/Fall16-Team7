package com.smart.cloudantDB;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class testDbSparkOperation {

//	@Test
//	public void testDbInit() {
//		DatabaseSparkOperation dbOperation = new DatabaseSparkOperation();
//		dbOperation.createIndex("zipcode");
//	}
	
//	@Test
//	public void testInsert() {
//		DatabaseSparkOperation dbOperation = new DatabaseSparkOperation();
//		ArrayList<String> list = new ArrayList<String>();
//		list.add("95123");
//		list.add("100000");
//		list.add("30");
//		list.add("male");
//		list.add("Online");
//		list.add("milk powder");
//		dbOperation.insert(list);
//	}
	
	@Test
	public void testQueryEq() {
		DatabaseSparkOperation dbOperation = new DatabaseSparkOperation();
		ArrayList<DataAnalysisInfo> resultQuary = dbOperation.select("zipcode", "eq", "94027");
		for (DataAnalysisInfo str: resultQuary) {
			System.out.println(str);
		}
	}
	
	@Test
	public void testQueryLt() {
		DatabaseSparkOperation dbOperation = new DatabaseSparkOperation();
		ArrayList<DataAnalysisInfo> resultQuary = dbOperation.select("zipcode", "lt", "95123");
		for (DataAnalysisInfo str: resultQuary) {
			System.out.println(str);
		}
	}
	
	@Test
	public void testQueryGt() {
		DatabaseSparkOperation dbOperation = new DatabaseSparkOperation();
		ArrayList<DataAnalysisInfo> resultQuary = dbOperation.select("zipcode", "gt", "95123");
		for (DataAnalysisInfo str: resultQuary) {
			System.out.println(str);
		}
	}
}
