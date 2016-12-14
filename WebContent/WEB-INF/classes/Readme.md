# How to use DatabaseOperation Interface
## Test Case 1:

+ DatabaseSparkOperation dbOperation = new DatabaseSparkOperation();
+ dbOperation.createIndex("The-Property-For-Index");

+ ArrayList<String> list = new ArrayList<String>();
+ list.add("95123");
+ list.add("100000");
+ list.add("30");
+ list.add("male");
+ list.add("Online");
+ list.add("milk powder");
+ dbOperation.insert(list);

+ ArrayList<String> resultQuary = dbOperation.select("Property1", "eq", "Value of Property1");

