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
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.document.mongodb.MongoOperations;
import org.springframework.data.document.mongodb.query.Criteria;
import org.springframework.data.document.mongodb.query.Query;
import org.springframework.data.document.mongodb.query.Update;
import com.rmzone.config.SpringMongoConfig;
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
        	mongoOperation.save("user", user);       
        
        
//        //find
//        User savedUser = mongoOperation.findOne("userprofile",
//        		new Query(Criteria.where("id").is("1001")),
//				User.class);
//        
//        System.out.println("savedUser : " + savedUser);
//        
//        //update
//        mongoOperation.updateFirst("userprofile",
//        		new Query(Criteria.where("firstname").is("yong")), 
//        		Update.update("lastname", "new lastname"));
//        
//        //find
//        User updatedUser = mongoOperation.findOne(
//        		"userprofile",
//        		new Query(Criteria.where("id").is("1001")),
//				User.class);
//        
//        System.out.println("updatedUser : " + updatedUser);
        
        //delete
        //mongoOperation.remove("user",
        //		new Query(Criteria.where("id").is("1001")),
        //		User.class);
        
        //List
        List<User> listUser =  
        	mongoOperation.getCollection("user", User.class);
        System.out.println("Number of user = " + listUser.size());
        
    }
    
}