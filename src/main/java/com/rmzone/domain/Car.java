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

import java.util.Date;
import java.util.List;

import org.springframework.data.document.mongodb.mapping.DBRef;

/** 
 * @author Raffaele Magliocco jr.
 */
public class Car extends DocumentMaster implements RevisionControlled {

	private String make;
	private String color;
	
	@DBRef
	private List<Tire> tires;
	
	@DBRef
	private Engine engine;
	
	public Car() { 
		this.type = "Car";
	}

	/**
	 * @param number
	 * @param description
	 * @param revision
	 * @param createdBy
	 * @param createdDate
	 */
	public Car(String number, String description, int revision, User createdBy,
			Date createdDate) {
		super(number, description, revision, createdBy, createdDate);
		this.type = "Car";
	}

	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}

	/**
	 * @param make the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the tires
	 */
	public List<Tire> getTires() {
		return tires;
	}

	/**
	 * @param tires the tires to set
	 */
	public void setTires(List<Tire> tires) {
		this.tires = tires;
	}

	/**
	 * @return the engine
	 */
	public Engine getEngine() {
		return engine;
	}

	/**
	 * @param engine the engine to set
	 */
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

}
