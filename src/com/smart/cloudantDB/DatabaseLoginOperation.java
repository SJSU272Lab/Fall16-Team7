package com.smart.cloudantDB;

import java.util.ArrayList;
import java.util.List;

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.FindByIndexOptions;
import com.cloudant.client.api.model.IndexField;
import com.cloudant.client.api.model.IndexField.SortOrder;

public class DatabaseLoginOperation implements DatabaseOperation{
	private LoginInfo loginInfo;
	private Database db;
	
	public DatabaseLoginOperation() {
		this.loginInfo = new LoginInfo();
		dbInit();
	}
	
	public void dbInit() {
		String account = "aca81918-9362-42f5-b167-48ea5023836b-bluemix";
		String username = "thenterrindeforatednesee";
		String password = "fd6757652488df1f77ed689a5717efb6bc7cc5f9";
		CloudantClient client = ClientBuilder.account(account)
                .username(username)
                .password(password)
                .build();
		System.out.println("Server Version: " + client.serverVersion());
		this.db = client.database("user-login-database", false);
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
	 * list includes specific value of [name email username password]
	 * if the username is already in the system
	 * you can not insert your information into the system again.
	 * You must change your username.
	 */
	@Override
	public void insert(ArrayList list) {
		// TODO Auto-generated method stub
		if (containUserName((String) list.get(2))) {
			System.out.println("UserName has already exist in the system.");
			return;
		}
		
		String name = (String) list.get(0);
		String email = (String) list.get(1);
		String username = (String) list.get(2);
		String password = (String) list.get(3);
		
		loginInfo.setName(name);
		loginInfo.setEmail(email);
		loginInfo.setUsername(username);
		loginInfo.setPassword(password);
		
		System.out.println("name = " + name + " email = " + email + " username = " + username + " password = " + password);
		db.save(loginInfo);
	}
	
	/**
	 *  select the username = "YourUserName"
	 */
	@Override
	public ArrayList<LoginInfo> select(String property1, String operation, String property2) {
		// TODO Auto-generated method stub
		String field0 = "name";
        String field1 = "email";
        String field2 = "username";
        String field3 = "password";
        String id = "_id";
        ArrayList<LoginInfo> arrayList = new ArrayList<LoginInfo>();
        
		if (operation.equals("eq") == true) {
//			String selectorJson = "\"selector\": { \"" + property1 + "\": \"" + property2 + "\"}";
			String selectorJson = "\"selector\": { \"" + property1 + "\": {\"$eq\": \"" + property2 + "\"}}";
//			String selectorJson = "\"selector\": { \"zipcode\": {\"$eq\": \"" + property2 + "\"}}";                  
			List<LoginInfo> resultQuery = 
					db.findByIndex(selectorJson, LoginInfo.class, new FindByIndexOptions()
							.sort(new IndexField("username", SortOrder.asc))
							.fields(id).fields(field0).fields(field1).fields(field2).fields(field3));
			if (resultQuery.size() == 0 || resultQuery == null) {
				System.out.println("resultQuery is enpty!");
				return null;
			}
			else {
				for (LoginInfo info : resultQuery) {
					arrayList.add(info);
				}
				return arrayList;
			}
		}
		else if (operation.equals("gt") == true) {
			String selectorJson = "\"selector\": {\"" + property1 + "\": {\"$gt\": \"" + property2 + "\"}}";
			List<LoginInfo> resultQuery = 
					db.findByIndex(selectorJson, LoginInfo.class, new FindByIndexOptions()
							.sort(new IndexField("username", SortOrder.asc))
							.fields(id).fields(field0).fields(field1).fields(field2).fields(field3));
			if (resultQuery.size() == 0 || resultQuery == null) {
				System.out.println("resultQuery is enpty!");
				return null;
			}
			else {
				for (LoginInfo info : resultQuery) {
					arrayList.add(info);
				}
				return arrayList;
			}
		}
		else if (operation.equals("lt") == true) {
			String selectorJson = "\"selector\": {\"" + property1 + "\": {\"$lt\": \"" + property2 + "\"}}";
			List<LoginInfo> resultQuery = 
					db.findByIndex(selectorJson, LoginInfo.class, new FindByIndexOptions()
							.sort(new IndexField("username", SortOrder.asc))
							.fields(id).fields(field0).fields(field1).fields(field2).fields(field3));
			if (resultQuery.size() == 0 || resultQuery == null) {
				System.out.println("resultQuery is enpty!");
				return null;
			}
			else {
				for (LoginInfo info : resultQuery) {
					arrayList.add(info);
				}
				return arrayList;
			}
		}
		else if (operation.equals("gte") == true) {
			String selectorJson = "\"selector\": {\"" + property1 + "\": {\"$gte\": \"" + property2 + "\"}}";
			List<LoginInfo> resultQuery = 
					db.findByIndex(selectorJson, LoginInfo.class, new FindByIndexOptions()
							.sort(new IndexField("username", SortOrder.asc))
							.fields(id).fields(field0).fields(field1).fields(field2).fields(field3));
			if (resultQuery.size() == 0 || resultQuery == null) {
				System.out.println("resultQuery is enpty!");
				return null;
			}
			else {
				for (LoginInfo info : resultQuery) {
					arrayList.add(info);
				}
				return arrayList;
			}
		}
		else if (operation.equals("lte") == true) {
			String selectorJson = "\"selector\": {\"" + property1 + "\": {\"$lte\": \"" + property2 + "\"}}";
			List<LoginInfo> resultQuery = 
					db.findByIndex(selectorJson, LoginInfo.class, new FindByIndexOptions()
							.sort(new IndexField("username", SortOrder.asc))
							.fields(id).fields(field0).fields(field1).fields(field2).fields(field3));
			if (resultQuery.size() == 0 || resultQuery == null) {
				System.out.println("resultQuery is enpty!");
				return null;
			}
			else {
				for (LoginInfo info : resultQuery) {
					arrayList.add(info);
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
	
	/**
	 * Find whether the user input the right username and password
	 * @param login_username
	 * @param login_password
	 * @return true: correct username and password
	 */
	public boolean matchUserPassword(String login_username, String login_password) {
		ArrayList<LoginInfo> listInfo = select("username", "eq", login_username);
		if (listInfo.size() == 1 && listInfo.get(0).getPassword().equals(login_password)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Find whether the username is already in the database.
	 * @param signUp_username
	 * @return true: the username has already been used by others
	 */
	public boolean containUserName(String signUp_username) {
		ArrayList<LoginInfo> listInfo = select("username", "eq", signUp_username);
		if (listInfo == null || listInfo.size() == 0) {
			return false;
		}
		if (listInfo.size() == 1) {
			return true;
		}
		else {
			return false;
		}
	}
}
