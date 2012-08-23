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
 */
public abstract class DocumentMaster {
	private String id;
	private String number;
	private String description;
	private int revision;
	private User createdBy;
	private Date createdDate;
	
	/**
	 * 
	 */
	public DocumentMaster() { }

}
