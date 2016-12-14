package com.smart.cloudantDB;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class testDbLoginOperation {

	@Test
	public void testIndex() {
		DatabaseLoginOperation dbOperation = new DatabaseLoginOperation();
		String indexField = "username";
		dbOperation.createIndex(indexField);
	}
	
	@Test
	public void testOperation() {
		DatabaseLoginOperation dbOperation = new DatabaseLoginOperation();
		ArrayList<String> list = new ArrayList<String>();
		list.add("Henry Liu");
		list.add("djsk@sjsu.edu");
		list.add("Baidu");
		list.add("1234");
		dbOperation.insert(list);
		list.clear();
		
		list.add("Jerry Yu");
		list.add("yuj@sjsu.edu");
		list.add("Google");
		list.add("4321");
		dbOperation.insert(list);
		list.clear();
		
		assertTrue(dbOperation.containUserName("Baidu"));
		assertTrue(dbOperation.containUserName("Google"));
		assertFalse(dbOperation.containUserName("Yahoo"));
		
		assertTrue(dbOperation.matchUserPassword("Baidu", "1234"));
		assertFalse(dbOperation.matchUserPassword("Google", "43210"));
		
		ArrayList<LoginInfo> resultInfo = new ArrayList<LoginInfo>();
		resultInfo = dbOperation.select("username", "eq", "Baidu");
		for (LoginInfo l : resultInfo) {
			System.out.println(l.toString());
		}
	}
}
