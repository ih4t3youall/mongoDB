package com.mkyong.core;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

/**
 * Java + MongoDB Hello world Example
 * 
 */
public class Main {
	public static void main(String[] args) throws IOException {

		try {

			/**** Connect to MongoDB ****/
			// Since 2.10.0, uses MongoClient
			MongoClient mongo = new MongoClient("localhost", 27017);

			/**** Get database ****/
			// if database doesn't exists, MongoDB will create it for you
			DB db = mongo.getDB("martin");

			/**** Get collection / table from 'testdb' ****/
			// if collection doesn't exists, MongoDB will create it for you
			DBCollection table = db.getCollection("person");

			ObjectMapper om = new ObjectMapper();
			/**** Insert 
			// create a document to store key and value
			Person person = new Person();
			person.setName("Martin");
			person.setLastName("Lequerica");
			BasicDBObject document = new BasicDBObject();
//			document.put("name", "something");
//			document.put("object", om.writeValueAsString(person));
			table.insert(document);

			/**** Find and display ****/
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("name", "something");

			DBCursor cursor = table.find(searchQuery);

			while (cursor.hasNext()) {
				String object =(String) cursor.next().get("name");
				Person person = om.readValue(object, Person.class);
				System.out.println(person.getName());
				System.out.println(person.getLastName());
			}

			/**** Update ****/
			// search document where name="mkyong" and update it with new values
			BasicDBObject query = new BasicDBObject();
			query.put("name", "mkyong");

			BasicDBObject newDocument = new BasicDBObject();
			newDocument.put("name", "mkyong-updated");

			BasicDBObject updateObj = new BasicDBObject();
			updateObj.put("$set", newDocument);

			table.update(query, updateObj);

			/**** Find and display ****/
			BasicDBObject searchQuery2 
				= new BasicDBObject().append("name", "mkyong-updated");

			DBCursor cursor2 = table.find(searchQuery2);

			while (cursor2.hasNext()) {
				System.out.println(cursor2.next());
			}

			/**** Done ****/
			System.out.println("Done");

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MongoException e) {
			e.printStackTrace();
		}

	}
}
