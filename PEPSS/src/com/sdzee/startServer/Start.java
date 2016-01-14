package com.sdzee.startServer;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;

public class Start implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		Timer timer = new Timer(true);
		TimerTask dailyTask = new TimerTask () {
		    @Override
		    public void run () {
		        Calendar c = Calendar.getInstance();
		    	if(c.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY||c.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)
		    		return;
				MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
				MongoDatabase database = mongoClient.getDatabase("PEPS");
				FindIterable<Document> iterable = database.getCollection("lastUpdate").find();
				iterable.first().get("date");
	            System.out.println(iterable.first().get("date"));
	            arg0.getServletContext().log("MyServletContextListener: " +iterable.first().get("date") );
				//BsonReader reader=new JsonReader(iterable.first().toJson());// Construct a BsonReader
				//		reader.readStartDocument();                           
				//		    reader.readName();      // read the name "a"      
				//		    reader.readString(); 
		    }
		};

		// schedule the task to run starting now and then every hour...
		timer.schedule (dailyTask, 0l, 24*1000*60*60);	
		
	}

}
