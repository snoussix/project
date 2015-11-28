package com.sdzee.bdd;

import java.net.UnknownHostException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.mongodb.*;
import com.mongodb.client.MongoDatabase;

import org.bson.*;

public class TestMongo {

	public List<String> executerTests(HttpServletRequest request) {

		List<String> dbs=null;
		try {
			MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
			MongoDatabase database = mongoClient.getDatabase("mydddb");
			database.getCollection("restaurants").insertOne(new Document("name", "MongoDB")
		               .append("type", "database")
		               .append("count", 1)
		               .append("info", new Document("x", 203).append("y", 102)));
			dbs = mongoClient.getDatabaseNames();
			mongoClient.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbs.add("red");
		return dbs;
	}

}
