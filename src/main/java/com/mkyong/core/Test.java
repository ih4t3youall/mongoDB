package com.mkyong.core;

import com.google.gson.Gson;
import com.mongodb.Block;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Test {
	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient(); // Connect with default
														// settings i.e.
														// localhost:27017
DB db = mongoClient.getDB("test");
//		MongoDatabase db1 = mongoClient.getDatabase("test"); // Get database
															// "test". Creates
															// one if it doesn't
															// exist
		Employee employee = new Employee(); // Create java object
		employee.setNo(1L);
		employee.setName("yogesh");
		// Deserialize object to json string
		Gson gson = new Gson();
		String json = gson.toJson(employee);
		// Parse to bson document and insert
		Document doc = Document.parse(json);
		db.getCollection("NameColl").insert(arr);
		db.getCollection("NameColl").insert(doc);

		// Retrieve to ensure object was inserted
		FindIterable<Document> iterable = db.getCollection("NameColl").find();
		iterable.forEach(new Block<Document>() {
			@Override
			public void apply(final Document document) {
				System.out.println(document); // See below to convert document
												// back to Employee
			}
		});

	}
}