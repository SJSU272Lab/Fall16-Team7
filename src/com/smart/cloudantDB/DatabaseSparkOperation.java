package com.smart.cloudantDB;

import java.util.ArrayList;
import java.util.List;

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.FindByIndexOptions;
import com.cloudant.client.api.model.IndexField;
import com.cloudant.client.api.model.IndexField.SortOrder;

public class DatabaseSparkOperation implements DatabaseOperation{
	private DataAnalysisInfo sparkInfo;
	private Database db;
	
	public DatabaseSparkOperation() {
		this.sparkInfo = new DataAnalysisInfo();
		dbInit();
	}
	
	public void dbInit() {
		String account = "aca81918-9362-42f5-b167-48ea5023836b-bluemix";
		String username = "befordstandidediabithedu";
		String password = "2afdca66d2176d8373338a8013a94fd8d1699eef";
		CloudantClient client = ClientBuilder.account(account)
                .username(username)
                .password(password)
                .build();
		System.out.println("Server Version: " + client.serverVersion());
		this.db = client.database("spark-analysis", false);
	}
	
	/**
	 * After we delete all the doc in the database, we need to createIndex again.
	 * Before we use selector, we also need to create indexes.
	 * @param index
	 */
	public void createIndex(String index) {
		String indexString = "{\n" +
                "  \"index\": {\n" +
                "    \"fields\": [\n" +
                "      \"" + index + "\"\n" +
                "    ]\n" +
                "  },\n" +
                "  \"type\": \"json\"\n" +
                "}";
		db.createIndex(indexString);
	}
	
	@Override
	public void insert(ArrayList list) {
		// TODO Auto-generated method stub
		String zipcode = (String) list.get(0);
		String income = (String) list.get(1);
		String age = (String) list.get(2);
		String gender = (String) list.get(3);
		String shopping_way = (String) list.get(4);
		String shopping_content = (String) list.get(5);
		sparkInfo.setZipcode(zipcode);
		sparkInfo.setIncome(income);
		sparkInfo.setAge(age);
		sparkInfo.setGender(gender);
		sparkInfo.setShopping_way(shopping_way);
		sparkInfo.setShopping_content(shopping_content);
		db.save(sparkInfo);
	}

//	@Override
//	public ArrayList<String> select(String property1, String operation, String property2) {
//		// TODO Auto-generated method stub
//		String field0 = "zipcode";
//        String field1 = "income";
//        String field2 = "age";
//        String field3 = "gender";
//        String field4 = "shopping_way";
//        String field5 = "shopping_content";
//        String id = "_id";
//        ArrayList<String> arrayList = new ArrayList<String>();
//        
//		if (operation.equals("eq") == true) {
////			String selectorJson = "\"selector\": { \"" + property1 + "\": \"" + property2 + "\"}";
//			String selectorJson = "\"selector\": { \"" + property1 + "\": {\"$eq\": \"" + property2 + "\"}}";
////			String selectorJson = "\"selector\": { \"zipcode\": {\"$eq\": \"" + property2 + "\"}}";                  
//			List<DataAnalysisInfo> resultQuery = 
//					db.findByIndex(selectorJson, DataAnalysisInfo.class, new FindByIndexOptions()
//							.sort(new IndexField("zipcode", SortOrder.asc))
//							.fields(id).fields(field0).fields(field1).fields(field2).fields(field3).fields(field4).fields(field5));
//			if (resultQuery.size() == 0 || resultQuery == null) {
//				System.out.println("resultQuery is enpty!");
//				return null;
//			}
//			else {
//				for (DataAnalysisInfo dai : resultQuery) {
//					arrayList.add(dai.toString());
//				}
//				return arrayList;
//			}
//		}
//		else if (operation.equals("gt") == true) {
//			String selectorJson = "\"selector\": {\"" + property1 + "\": {\"$gt\": \"" + property2 + "\"}}";
//			List<DataAnalysisInfo> resultQuery = 
//					db.findByIndex(selectorJson, DataAnalysisInfo.class, new FindByIndexOptions()
//							.sort(new IndexField("zipcode", SortOrder.asc))
//							.fields(id).fields(field0).fields(field1).fields(field2).fields(field3).fields(field4).fields(field5));
//			if (resultQuery.size() == 0 || resultQuery == null) {
//				System.out.println("resultQuery is enpty!");
//				return null;
//			}
//			else {
//				for (DataAnalysisInfo dai : resultQuery) {
//					arrayList.add(dai.toString());
//				}
//				return arrayList;
//			}
//		}
//		else if (operation.equals("lt") == true) {
//			String selectorJson = "\"selector\": {\"" + property1 + "\": {\"$lt\": \"" + property2 + "\"}}";
//			List<DataAnalysisInfo> resultQuery = 
//					db.findByIndex(selectorJson, DataAnalysisInfo.class, new FindByIndexOptions()
//							.sort(new IndexField("zipcode", SortOrder.asc))
//							.fields(id).fields(field0).fields(field1).fields(field2).fields(field3).fields(field4).fields(field5));
//			if (resultQuery.size() == 0 || resultQuery == null) {
//				System.out.println("resultQuery is enpty!");
//				return null;
//			}
//			else {
//				for (DataAnalysisInfo dai : resultQuery) {
//					arrayList.add(dai.toString());
//				}
//				return arrayList;
//			}
//		}
//		else if (operation.equals("gte") == true) {
//			String selectorJson = "\"selector\": {\"" + property1 + "\": {\"$gte\": \"" + property2 + "\"}}";
//			List<DataAnalysisInfo> resultQuery = 
//					db.findByIndex(selectorJson, DataAnalysisInfo.class, new FindByIndexOptions()
//							.sort(new IndexField("zipcode", SortOrder.asc))
//							.fields(id).fields(field0).fields(field1).fields(field2).fields(field3).fields(field4).fields(field5));
//			if (resultQuery.size() == 0 || resultQuery == null) {
//				System.out.println("resultQuery is enpty!");
//				return null;
//			}
//			else {
//				for (DataAnalysisInfo dai : resultQuery) {
//					arrayList.add(dai.toString());
//				}
//				return arrayList;
//			}
//		}
//		else if (operation.equals("lte") == true) {
//			String selectorJson = "\"selector\": {\"" + property1 + "\": {\"$lte\": \"" + property2 + "\"}}";
//			List<DataAnalysisInfo> resultQuery = 
//					db.findByIndex(selectorJson, DataAnalysisInfo.class, new FindByIndexOptions()
//							.sort(new IndexField("zipcode", SortOrder.asc))
//							.fields(id).fields(field0).fields(field1).fields(field2).fields(field3).fields(field4).fields(field5));
//			if (resultQuery.size() == 0 || resultQuery == null) {
//				System.out.println("resultQuery is enpty!");
//				return null;
//			}
//			else {
//				for (DataAnalysisInfo dai : resultQuery) {
//					arrayList.add(dai.toString());
//				}
//				return arrayList;
//			}
//		}
//		else {
//			;
//		}
//		return arrayList;
//	}
	
	@Override
	public ArrayList<DataAnalysisInfo> select(String property1, String operation, String property2) {
		// TODO Auto-generated method stub
		String field0 = "zipcode";
        String field1 = "income";
        String field2 = "age";
        String field3 = "gender";
        String field4 = "shopping_way";
        String field5 = "shopping_content";
        String id = "_id";
        ArrayList<DataAnalysisInfo> arrayList = new ArrayList<DataAnalysisInfo>();
        
		if (operation.equals("eq") == true) {
//			String selectorJson = "\"selector\": { \"" + property1 + "\": \"" + property2 + "\"}";
			String selectorJson = "\"selector\": { \"" + property1 + "\": {\"$eq\": \"" + property2 + "\"}}";
//			String selectorJson = "\"selector\": { \"zipcode\": {\"$eq\": \"" + property2 + "\"}}";                  
			List<DataAnalysisInfo> resultQuery = 
					db.findByIndex(selectorJson, DataAnalysisInfo.class, new FindByIndexOptions()
							.sort(new IndexField("zipcode", SortOrder.asc))
							.fields(id).fields(field0).fields(field1).fields(field2).fields(field3).fields(field4).fields(field5));
			if (resultQuery.size() == 0 || resultQuery == null) {
				System.out.println("resultQuery is enpty!");
				return null;
			}
			else {
				for (DataAnalysisInfo dai : resultQuery) {
					arrayList.add(dai);
				}
				return arrayList;
			}
		}
		else if (operation.equals("gt") == true) {
			String selectorJson = "\"selector\": {\"" + property1 + "\": {\"$gt\": \"" + property2 + "\"}}";
			List<DataAnalysisInfo> resultQuery = 
					db.findByIndex(selectorJson, DataAnalysisInfo.class, new FindByIndexOptions()
							.sort(new IndexField("zipcode", SortOrder.asc))
							.fields(id).fields(field0).fields(field1).fields(field2).fields(field3).fields(field4).fields(field5));
			if (resultQuery.size() == 0 || resultQuery == null) {
				System.out.println("resultQuery is enpty!");
				return null;
			}
			else {
				for (DataAnalysisInfo dai : resultQuery) {
					arrayList.add(dai);
				}
				return arrayList;
			}
		}
		else if (operation.equals("lt") == true) {
			String selectorJson = "\"selector\": {\"" + property1 + "\": {\"$lt\": \"" + property2 + "\"}}";
			List<DataAnalysisInfo> resultQuery = 
					db.findByIndex(selectorJson, DataAnalysisInfo.class, new FindByIndexOptions()
							.sort(new IndexField("zipcode", SortOrder.asc))
							.fields(id).fields(field0).fields(field1).fields(field2).fields(field3).fields(field4).fields(field5));
			if (resultQuery.size() == 0 || resultQuery == null) {
				System.out.println("resultQuery is enpty!");
				return null;
			}
			else {
				for (DataAnalysisInfo dai : resultQuery) {
					arrayList.add(dai);
				}
				return arrayList;
			}
		}
		else if (operation.equals("gte") == true) {
			String selectorJson = "\"selector\": {\"" + property1 + "\": {\"$gte\": \"" + property2 + "\"}}";
			List<DataAnalysisInfo> resultQuery = 
					db.findByIndex(selectorJson, DataAnalysisInfo.class, new FindByIndexOptions()
							.sort(new IndexField("zipcode", SortOrder.asc))
							.fields(id).fields(field0).fields(field1).fields(field2).fields(field3).fields(field4).fields(field5));
			if (resultQuery.size() == 0 || resultQuery == null) {
				System.out.println("resultQuery is enpty!");
				return null;
			}
			else {
				for (DataAnalysisInfo dai : resultQuery) {
					arrayList.add(dai);
				}
				return arrayList;
			}
		}
		else if (operation.equals("lte") == true) {
			String selectorJson = "\"selector\": {\"" + property1 + "\": {\"$lte\": \"" + property2 + "\"}}";
			List<DataAnalysisInfo> resultQuery = 
					db.findByIndex(selectorJson, DataAnalysisInfo.class, new FindByIndexOptions()
							.sort(new IndexField("zipcode", SortOrder.asc))
							.fields(id).fields(field0).fields(field1).fields(field2).fields(field3).fields(field4).fields(field5));
			if (resultQuery.size() == 0 || resultQuery == null) {
				System.out.println("resultQuery is enpty!");
				return null;
			}
			else {
				for (DataAnalysisInfo dai : resultQuery) {
					arrayList.add(dai);
				}
				return arrayList;
			}
		}
		else {
			;
		}
		return arrayList;
	}
	
	@Override
	public void delete(String _id) {
		// TODO Auto-generated method stub
		
	}
	
	
}
