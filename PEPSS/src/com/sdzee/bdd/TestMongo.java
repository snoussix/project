package com.sdzee.bdd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;

import org.bson.*;
import org.bson.json.JsonReader;

public class TestMongo {

	
	public List<String> executerTests(HttpServletRequest request, String str) {

		List<String> dbs=new ArrayList();
		String URL ="http://real-chart.finance.yahoo.com/";
		String Options = "table.csv?s="+str+"&a=00&b=2&c=2010&d=10&e=28&f=2015&g=d&ignore=.csv";
		URL website= null;
		try {
			website = new URL(URL+Options);
			 BufferedReader in = new BufferedReader(
				        new InputStreamReader(website.openStream()));

				        String inputLine;
				        while ((inputLine = in.readLine()) != null)
				            dbs.add(inputLine);
				        in.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
			MongoDatabase database = mongoClient.getDatabase("mydddb");

			
			database.getCollection("restaurants").insertOne(new Document("name", "MongoDB")
		               .append("type", "database")
		               .append("count", 1)
		               .append("info", new Document("x", 203).append("y", 102)));
		//	dbs = mongoClient.getDatabaseNames();
			mongoClient.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dbs;
	}

}
