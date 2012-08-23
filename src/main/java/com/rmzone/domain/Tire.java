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

/** 
 * @author Raffaele Magliocco jr.
 *
 */
public class Tire extends DocumentMaster {
	private int radius;
	private int height;
	private int width;
	
	public Tire() { 
		this.type = "Tire";
	}

	/**
	 * @param number
	 * @param description
	 * @param revision
	 * @param createdBy
	 * @param createdDate
	 */
	public Tire(String number, String description, int revision,
			User createdBy, Date createdDate, int radius, int height, int width) {
		super(number, description, revision, createdBy, createdDate);
		
		this.type = "Tire";
		this.radius = radius;
		this.height = height;
		this.width = width;
	}
	
	

}
