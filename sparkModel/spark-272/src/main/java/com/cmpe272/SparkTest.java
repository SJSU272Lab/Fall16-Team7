package com.cmpe272;
import org.apache.spark.ml.classification.MultilayerPerceptronClassificationModel;
import org.apache.spark.ml.classification.MultilayerPerceptronClassifier;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.mllib.regression.LabeledPoint;
import org.apache.spark.mllib.util.MLUtils;
import org.apache.spark.rdd.RDD;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.Row;

import scala.Tuple2;

public class SparkTest {
	
//	public static void main(String[] args) throws IOException {
//		DatabaseSparkOperation db = new DatabaseSparkOperation();
		
//		analyze(dataFilePath(db, "zipcode", "eq", "95112"), "result95112.txt");
//		analyze(dataFilePath(db, "zipcode", "eq", "95129"), "result95129.txt");
//		analyze(dataFilePath(db, "zipcode", "eq", "95133"), "result95133.txt");
//		analyze(dataFilePath(db, "zipcode", "eq", "95123"), "result95123.txt");
//		analyze(dataFilePath(db, "zipcode", "eq", "94027"), "result94027.txt");
//		analyze(dataFilePath(db, "zipcode", "eq", "92145"), "result92145.txt");
//		analyze(dataFilePath(db, "zipcode", "eq", "95119"), "result95119.txt");
//		analyze(dataFilePath(db, "zipcode", "eq", "93706"), "result93706.txt");
//		dataFilePath(db, "zipcode","gt", "00000");
//	}
	
	public static String fileGen() throws IOException
	{
		DatabaseSparkOperation db = new DatabaseSparkOperation();
		DatabaseResultOperation db1 = new DatabaseResultOperation();
		try{
			db1.delete("Tea");
			db1.delete("Apple MacPro");
			db1.delete("Badmin Racket");
			db1.delete("Cola");
		}
		catch(Exception e)
		{}
		dataFilePath(db, "zipcode", "gt", "00000");
		return dataFilePath_R(db, "zipcode", "gt", "00000");
		
	}
	
	public static void fileLinkInsert()
	{
		
	}
	
	public static String dataFilePath(DatabaseSparkOperation db, String sql, String op, String item) throws IOException
	{
		ArrayList<DataAnalysisInfo> items = db.select(sql, op, item);
		String path = item+"data.txt";
		File file = new File(path);
		BufferedWriter out = new BufferedWriter(new FileWriter(file));
		try {
			file.createNewFile();
		} catch (IOException e) {
//			 TODO Auto-generated catch block
			e.printStackTrace();
		}
		int index = 0;
		for(DataAnalysisInfo i: items)
		{
			
			Item iitem = new Item(i);
//			iitem.transform(out);
			out.append(index+"|"+iitem.toString());
			index++;
			System.out.println(i.getShopping_content()+i.getAgeInt()+i.getGender()+i.getIncome()+i.getShopping_way());
		}
		out.flush();
		out.close();
		return path;
	}
	
	public static String dataFilePath_R(DatabaseSparkOperation db, String sql, String op, String item) throws IOException
	{
		ArrayList<DataAnalysisInfo> items = db.select(sql, op, item);
		String path = item+"data3.txt";
		File file = new File(path);
		BufferedWriter out = new BufferedWriter(new FileWriter(file));
		try {
			file.createNewFile();
		} catch (IOException e) {
//			 TODO Auto-generated catch block
			e.printStackTrace();
		}
		int index = 0;
		for(DataAnalysisInfo i: items)
		{
			Item iitem = new Item(i);
//			iitem.transform(out);
			out.append(index+"|"+iitem.toString1());
			index++;
			System.out.println(i.getShopping_content()+i.getAgeInt()+i.getGender()+i.getIncome()+i.getShopping_way());
		}
		out.flush();
		out.close();
		return path;
	}
	
	public static void mapFile(String path) throws IOException
	{
		DatabaseResultOperation db = new DatabaseResultOperation();
//		db.delete("Tea");
//		db.delete("Apple MacPro");
//		db.delete("Badmin Racket");
//		db.delete("Cola");
//		db.dbInit(path);
//		try{
//			db.clean();
//		}catch(Exception e){}
		File file = new File(path);
		File outfile = new File(path+"out.txt");
		outfile.createNewFile();
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		BufferedWriter out = new BufferedWriter(new FileWriter(outfile));
		for(String line; (line = br.readLine()) != null; )
		{
	        line = line.substring(line.indexOf("(")+1, line.indexOf(")")-1);
			System.out.println(line.split(","));
			BufferedReader br1 = new BufferedReader(new FileReader(new File("00000data.txt")));
	        for(String line1; (line1 = br1.readLine()) != null; )
	        {
	        	System.out.println(line1.split("\\|"));
	        	if(line1.split("\\|")[0].toString().equals(line.split(",")[1].toString()))
	        	{
	        		String result = line1+"|most likely to buy because of suitable income";
	        		System.out.println(result);
	        		out.append(result+"\n");
	        		ArrayList<String> a = new ArrayList<>();
	        		a.add(result.split("\\|")[6].toString());
	        		a.add(result.split("\\|")[1].toString());
	        		a.add(result.split("\\|")[7].toString());
	        		out.append(a.get(0)+"...."+a.get(1)+"...."+a.get(2)+"\n");
	        		db.insert(a, Double.parseDouble(line.split(",")[2]));
	        	}
	        }
			br1.close();
		}
		out.flush();
		out.close();
		br.close();
	}
	
	public static void analyze( String path, String pathout) throws IOException
	{
		// Set application name
				String appName = "MultilayerPerceptronClassifier";
				
				// Initialize Spark configuration & context
				SparkConf conf = new SparkConf().setAppName(appName)
						.setMaster("local[1]").set("spark.executor.memory", "1g");
				SparkContext sc = new SparkContext(conf);
				SQLContext sqlContext = new SQLContext(sc);

				// Load training and test data file and parse.
				JavaRDD<LabeledPoint> data = MLUtils.loadLibSVMFile(sc, path)
						.toJavaRDD();

				// Obtain 10 sets of training and test data. 12345 is the seed used to randomly split data.
				Tuple2<RDD<LabeledPoint>,RDD<LabeledPoint>>[] myTuple = MLUtils.kFold(data.rdd(), 10, 12345, data.classTag());
				
				
				// Train/validate the algorithm once for each set.
				for(int i = 0; i < myTuple.length; i++){
					JavaRDD<LabeledPoint> trainingData = (new JavaRDD<LabeledPoint>(myTuple[i]._1,data.classTag())).cache();
					JavaRDD<LabeledPoint> testData = new JavaRDD<LabeledPoint>(myTuple[i]._2,data.classTag());
					kRun(trainingData,testData,sqlContext, pathout);
				}
				sc.stop();
	}

	private static final void displayConfusionMatrix(Row[] rows, String path) throws IOException{
		// #times label 0 correctly predicted
		int correctlyPredicted0 = 0;
		
		// #times label 1 correctly predicted
		int correctlyPredicted1 = 0;
		
		// #times label 1 wrongly predicted as label 0
		int wronglyPredicted0 = 0;
		
		// #times label 0 wrongly predicted as label 1
		int wronglyPredicted1 = 0;
		

		File fileR = new File(path);
		FileWriter f = new FileWriter(fileR);
		BufferedWriter out = new BufferedWriter(f);
		out.newLine();
		out.newLine();
		for(int i=0; i < rows.length; i++){
			Row row = rows[i];
			System.out.println(row);
			out.append(row.toString());
			out.newLine();
			double label = row.getDouble(1);
			double prediction = row.getDouble(2);
			
			if(label == prediction){
					correctlyPredicted0++;
			}else{
					wronglyPredicted0++;
			}
		}
		
		float fcorrectlyPredicted0 = correctlyPredicted0 * 1.0f;
		float fwronglyPredicted0 = wronglyPredicted0 * 1.0f;
		
		System.out.println("************");
		System.out.println(correctlyPredicted0 + "      " + wronglyPredicted1);
		System.out.println(wronglyPredicted0 + "      " + correctlyPredicted1);
		
		System.out.println("Class 0 precision: " + ((fcorrectlyPredicted0 == 0.0f)?0.0:(fcorrectlyPredicted0 / (fcorrectlyPredicted0 + fwronglyPredicted0))));
		System.out.println("************");	
		out.append("************");
		out.newLine();
		out.append(correctlyPredicted0 + "      " + wronglyPredicted1);
		out.newLine();
		out.append(wronglyPredicted0 + "      " + correctlyPredicted1);
		out.newLine();
		out.append("Class 0 precision: " + ((fcorrectlyPredicted0 == 0.0f)?0.0:(fcorrectlyPredicted0 / (fcorrectlyPredicted0 + fwronglyPredicted0))));
		out.newLine();
//		out.append("Class 0 recall: " + ((fcorrectlyPredicted0 == 0.0f)?0.0:(fcorrectlyPredicted0 / (fcorrectlyPredicted0 + fwronglyPredicted1))));
//		out.newLine();
//		out.append("Class 1 precision: " + ((fcorrectlyPredicted1 == 0.0f)?0.0:(fcorrectlyPredicted1 / (fcorrectlyPredicted1 + fwronglyPredicted1))));
//		out.newLine();
//		out.append("Class 1 recall: " + ((fcorrectlyPredicted1 == 0.0f)?0.0:(fcorrectlyPredicted1 / (fcorrectlyPredicted1 + fwronglyPredicted0))));
//		out.newLine();
		out.append("************");	
		out.flush();
		out.close();
	}
	
	private static final void kRun(JavaRDD<LabeledPoint> trainingData, JavaRDD<LabeledPoint> testData, SQLContext sqlContext, String path) throws IOException{
		DataFrame train = sqlContext.createDataFrame(trainingData, LabeledPoint.class);
		DataFrame test = sqlContext.createDataFrame(testData, LabeledPoint.class);

		// Input consists of 6 features; two hidden layers consist of 28, 25 computational units respectively;
		// Output is binary
		int[] layers = new int[] {5,  28, 25, 4};
		
		// Define the trainer.
		MultilayerPerceptronClassifier trainer = new MultilayerPerceptronClassifier()
		  .setLayers(layers)
		  .setBlockSize(128)
		  .setSeed(1234L)
		  .setMaxIter(150);
		// Obtain the trained model
		MultilayerPerceptronClassificationModel model = trainer.fit(train);	
		
		// Apply test data to model and obtain the output
		DataFrame testResult = model.transform(test);
		// Display performance metrics for the output
		displayConfusionMatrix(testResult.collect(), path);

	}
}
