package com.smart.cloudantDB;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.FindByIndexOptions;
import com.cloudant.client.api.model.IndexField;
import com.cloudant.client.api.model.IndexField.SortOrder;

public class testCloudantClient {

	@Test
	public void test() {
		String account = "aca81918-9362-42f5-b167-48ea5023836b-bluemix";
		String username = "thelfitheartakedallamete";
		String password = "73c0a8271a374b63e89245c4e853c80480c9a0e1";
		CloudantClient client = ClientBuilder.account(account)
                .username(username)
                .password(password)
                .build();
		System.out.println("Server Version: " + client.serverVersion());
		//System.out.println("Server Version: ");
		
//		List<String> databases = client.getAllDbs();
//		System.out.println("All my databases : ");
//		for ( String db : databases ) {
//		    System.out.println(db);
//		}
		
//		client.createDB("smart-cloudant-db");
		ArrayList<Customer_Information> customer_array = new ArrayList<Customer_Information>();
		Database db = client.database("user-info-database", false);
		Customer_Information cf0 = new Customer_Information("John Brown", "95123", "657 Okland Road", 100000);
		Customer_Information cf1 = new Customer_Information("Henry White", "95115", "364 Brow Road", 300000);
		Customer_Information cf2 = new Customer_Information("Kite Green", "95178", "7869 Red Road", 809872);
		Customer_Information cf3 = new Customer_Information("John Brown", "95178", "2031 Green Road", 768903);
		Customer_Information cf4 = new Customer_Information("Jerry White", "95123", "482 King Street", 200000);
		db.save(cf0);
		db.save(cf1);
		db.save(cf2);
		db.save(cf3);
		db.save(cf4);
		System.out.println("You have inserted the document");
		
		String search_zipcode = "95178";
		String indexString = "{\n" +
                "  \"index\": {\n" +
                "    \"fields\": [\n" +
                "      \"zipcode\"\n" +
                "    ]\n" +
                "  },\n" +
                "  \"type\": \"json\"\n" +
                "}";
		db.createIndex(indexString);
		
//		String selectorJson = "{\n" +
//                "  \"selector\": {\n" +
//                "    \"zipcode\": {\n" +
//                "      \"$eq\": " + search_zipcode + "\n" +
//                "    }\n" +
//                "  },\n" +
//                "  \"fields\": [\n" +
//                "    \"zipcode\",\n" +
//                "    \"income\",\n" +
//                "    \"name\"\n" +
//                "  ],\n" +
//                "  \"sort\": [\n" +
//                "    {\n" +
//                "      \"zipcode\": \"asc\"\n" +
//                "    }\n" +
//                "  ]\n" +
//                "}\n";
		String selectorJson = "\"selector\": { \"zipcode\": {\"$eq\": \"" + search_zipcode + "\"}}";                  
//        FindByIndexOptions findOptions = new FindByIndexOptions();
//        findOptions.sort(new IndexField("zipcode", SortOrder.asc));
        String field0 = "name";
        String field1 = "zipcode";
        String field2 = "address";
        String field3 = "income";
        String id = "_id";
//        String selectorJson = "	\"selector\": { \"zipcode\": \"" + search_zipcode + "\"}"; 
		List<Customer_Information> resultCustomer = 
				db.findByIndex(selectorJson, Customer_Information.class, new FindByIndexOptions()
						.sort(new IndexField("zipcode", SortOrder.asc))
						.fields(id).fields(field0).fields(field1).fields(field2).fields(field3));
//		List<Customer_Information> resultCustomerTemp = 
//				db.findByIndex(selectorJson, Customer_Information.class);
//		assert(resultCustomer.size() > 0); 
		
		System.out.println("Selecting results: ");
		for(Customer_Information c : resultCustomer) {
			System.out.println(c);
		}
		
//		CloudantClient client;
//		try {
//			client = ClientBuilder.url(new URL("http://127.0.0.1:5984.smart-ads-database"))
//						.username("henrywan16")
//						.password("76543210")
//						.build();
//			System.out.println("Server Version: " + client.serverVersion());
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
	}
}


