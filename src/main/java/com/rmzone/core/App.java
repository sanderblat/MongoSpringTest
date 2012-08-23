/*
 *  MongoSpringTest - http://www.rmzone.com
 *
 *  Copyright (c) 2012 Raffaele Magliocco jr.
 *
 *  MongoSpringTest is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  MongoSpringTest is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with MongoSpringTest.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.rmzone.core;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.document.mongodb.MongoOperations;
import org.springframework.data.document.mongodb.query.Criteria;
import org.springframework.data.document.mongodb.query.Query;
import org.springframework.data.document.mongodb.query.Update;
import com.rmzone.config.SpringMongoConfig;
import com.rmzone.domain.Car;
import com.rmzone.domain.DocumentMaster;
import com.rmzone.domain.Engine;
import com.rmzone.domain.Tire;
import com.rmzone.domain.User;

public class App
{
    public static void main( String[] args )
    {
    	// set up mongo
    	ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);    	    	
    	MongoOperations mongoOperation = (MongoOperations)ctx.getBean("mongoTemplate");
    	
    	// create and save some users
    	List<User> users = new ArrayList<User>();
        users.add( new User("1001", "foo", "bar") );
        users.add( new User("1002", "mickey", "mouse") );               
        
        for (User user : users)
        	mongoOperation.save("users", user);  
        
        // create and save some documents
        Tire tire = new Tire("Michelin", "Alpine", 1, users.get(0), Calendar.getInstance().getTime(), 14, 12, 3);                 
    	mongoOperation.save("documents", tire); 
    	
    	Engine engine = new Engine("Model T", "Wow", 1, users.get(0), Calendar.getInstance().getTime());                 
    	engine.setHorsePower(16.4f);
    	mongoOperation.save("documents", engine); 
    	
    	Car car = new Car("Pinto", "don't touch me!", 1, users.get(0), Calendar.getInstance().getTime());   
    	car.setMake("Ford");
    	car.setColor("Blue");
    	car.setEngine(engine);
    	
    	// sorry not very elegant
    	car.setTires(new ArrayList<Tire>());
    	for (int i=0; i<4; i++)
    		car.getTires().add(tire);
    	mongoOperation.save("documents", car); 
        
        // dump all the data        
        List<User> listUser =  mongoOperation.getCollection("users", User.class);
        System.out.println("Number of users = " + listUser.size());
        for (User user : listUser)
        	System.out.println(user.toString()); 
        
        List<DocumentMaster> listDocument =  mongoOperation.getCollection("documents", DocumentMaster.class);
        System.out.println("Number of documents = " + listDocument.size());
        for (DocumentMaster document1 : listDocument)
        	System.out.println(document1.toString()); 
        
        // delete everything
        mongoOperation.dropCollection("users");
        mongoOperation.dropCollection("documents");
    }
    
}