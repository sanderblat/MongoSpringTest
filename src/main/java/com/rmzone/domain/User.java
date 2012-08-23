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
package com.rmzone.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.document.mongodb.mapping.Document;

/** 
 * Hold our users information.
 */
@Document
public class User {
	
	@Id
	private String id;
	private String userName;
	private String firstName;
	private String lastName;
	
	public User() { }

	/**
	 * @param userName
	 * @param firstName
	 * @param lastName
	 */
	public User(String userName, String firstName, String lastName) {
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return String.format("User [id=%s, userName=%s, firstName=%s, lastName=%s]", id, userName, firstName, lastName);
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
