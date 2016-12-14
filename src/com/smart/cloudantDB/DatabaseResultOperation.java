package com.smart.cloudantDB;

import java.util.ArrayList;
import java.util.List;

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.FindByIndexOptions;
import com.cloudant.client.api.model.IndexField;
import com.cloudant.client.api.model.IndexField.SortOrder;

public class DatabaseResultOperation implements DatabaseOperation{
	private AnalysisResultInfo resultInfo;
	private Database db;
	
	public DatabaseResultOperation() {
		this.resultInfo = new AnalysisResultInfo();
		dbInit();
	}
	
	public void dbInit() {
		String account = "aca81918-9362-42f5-b167-48ea5023836b-bluemix";
		String username = "eterywaytochadvarryingto";
		String password = "124e2535d7364cf45ef29361d6b568d4150d55f9";
		CloudantClient client = ClientBuilder.account(account)
                .username(username)
                .password(password)
                .build();
		System.out.println("Server Version: " + client.serverVersion());
		this.db = client.database("result-database", false);
		
		String indexField0 = "shopping_content";
		String indexField1 = "zipcode";	
		createIndex(indexField0);
		createIndex(indexField1);
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
	
	/**
	 * Not include double evalution
	 */
	@Override
	public void insert(ArrayList list) {
		// TODO Auto-generated method stub
		String shopping_content = (String) list.get(0);
		String zipcode = (String) list.get(1);
		String description = (String) list.get(2);
		
		resultInfo.setShopping_content(shopping_content);
		resultInfo.setZipcode(zipcode);
		resultInfo.setDescription(description);
		
		db.save(resultInfo);
	}
	
	/**
	 * insert a result into database
	 * key is shopping_content
	 * @param list [shopping_content, zipcode, description] & evaluation
	 * @param evaluation
	 */
	public void insert(ArrayList list, double evaluation) {
		// TODO Auto-generated method stub
		String shopping_content = (String) list.get(0);
		String zipcode = (String) list.get(1);
		String description = (String) list.get(2);
		
		resultInfo.setShopping_content(shopping_content);
		resultInfo.setZipcode(zipcode);
		resultInfo.setEvaluation(evaluation);
		resultInfo.setDescription(description);
		
		db.save(resultInfo);
	}
	
	@Override
	public ArrayList<AnalysisResultInfo> select(String property1, String operation, String property2) {
		// TODO Auto-generated method stub
		String field0 = "shopping_content";
        String field1 = "zipcode";
        String field2 = "evaluation";
        String field3 = "description";
        String id = "_id";
        String rev = "_rev";
        ArrayList<AnalysisResultInfo> arrayList = new ArrayList<AnalysisResultInfo>();
        
		if (operation.equals("eq") == true) {
//			String selectorJson = "\"selector\": { \"" + property1 + "\": \"" + property2 + "\"}";
			String selectorJson = "\"selector\": { \"" + property1 + "\": {\"$eq\": \"" + property2 + "\"}}";
//			String selectorJson = "\"selector\": { \"zipcode\": {\"$eq\": \"" + property2 + "\"}}";                  
			List<AnalysisResultInfo> resultQuery = 
					db.findByIndex(selectorJson, AnalysisResultInfo.class, new FindByIndexOptions()
							.sort(new IndexField("shopping_content", SortOrder.asc))
							.fields(id).fields(rev).fields(field0).fields(field1).fields(field2).fields(field3));
			if (resultQuery.size() == 0 || resultQuery == null) {
				System.out.println("resultQuery is enpty!");
				return null;
			}
			else {
				for (AnalysisResultInfo dai : resultQuery) {
					arrayList.add(dai);
				}
				return arrayList;
			}
		}
		else if (operation.equals("gt") == true) {
			String selectorJson = "\"selector\": {\"" + property1 + "\": {\"$gt\": \"" + property2 + "\"}}";
			List<AnalysisResultInfo> resultQuery = 
					db.findByIndex(selectorJson, AnalysisResultInfo.class, new FindByIndexOptions()
							.sort(new IndexField("shopping_content", SortOrder.asc))
							.fields(id).fields(rev).fields(field0).fields(field1).fields(field2).fields(field3));
			if (resultQuery.size() == 0 || resultQuery == null) {
				System.out.println("resultQuery is enpty!");
				return null;
			}
			else {
				for (AnalysisResultInfo dai : resultQuery) {
					arrayList.add(dai);
				}
				return arrayList;
			}
		}
		else if (operation.equals("lt") == true) {
			String selectorJson = "\"selector\": {\"" + property1 + "\": {\"$lt\": \"" + property2 + "\"}}";
			List<AnalysisResultInfo> resultQuery = 
					db.findByIndex(selectorJson, AnalysisResultInfo.class, new FindByIndexOptions()
							.sort(new IndexField("shopping_content", SortOrder.asc))
							.fields(id).fields(rev).fields(field0).fields(field1).fields(field2).fields(field3));
			if (resultQuery.size() == 0 || resultQuery == null) {
				System.out.println("resultQuery is enpty!");
				return null;
			}
			else {
				for (AnalysisResultInfo dai : resultQuery) {
					arrayList.add(dai);
				}
				return arrayList;
			}
		}
		else if (operation.equals("gte") == true) {
			String selectorJson = "\"selector\": {\"" + property1 + "\": {\"$gte\": \"" + property2 + "\"}}";
			List<AnalysisResultInfo> resultQuery = 
					db.findByIndex(selectorJson, AnalysisResultInfo.class, new FindByIndexOptions()
							.sort(new IndexField("shopping_content", SortOrder.asc))
							.fields(id).fields(rev).fields(field0).fields(field1).fields(field2).fields(field3));
			if (resultQuery.size() == 0 || resultQuery == null) {
				System.out.println("resultQuery is enpty!");
				return null;
			}
			else {
				for (AnalysisResultInfo dai : resultQuery) {
					arrayList.add(dai);
				}
				return arrayList;
			}
		}
		else if (operation.equals("lte") == true) {
			String selectorJson = "\"selector\": {\"" + property1 + "\": {\"$lte\": \"" + property2 + "\"}}";
			List<AnalysisResultInfo> resultQuery = 
					db.findByIndex(selectorJson, AnalysisResultInfo.class, new FindByIndexOptions()
							.sort(new IndexField("shopping_content", SortOrder.asc))
							.fields(id).fields(rev).fields(field0).fields(field1).fields(field2).fields(field3));
			if (resultQuery.size() == 0 || resultQuery == null) {
				System.out.println("resultQuery is enpty!");
				return null;
			}
			else {
				for (AnalysisResultInfo dai : resultQuery) {
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
	
	/**
	 * delete one kind of shopping_content 
	 */
	@Override
	public void delete(String shopping_content) {
		// TODO Auto-generated method stub
		ArrayList<AnalysisResultInfo> resultList = select("shopping_content", "eq", shopping_content);
		if (resultList == null || resultList.size() == 0) {
			System.out.println("Shopping_content : " + shopping_content + "is empty.");
			return;
		}
		for (AnalysisResultInfo r : resultList) {
			String _id = r.get_id();
			String _rev = r.get_rev();
			System.out.println("Deleting all the " + shopping_content);
			db.remove(_id, _rev);
		}
	}
}
