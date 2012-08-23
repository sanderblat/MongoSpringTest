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

import org.springframework.data.annotation.Id;
import org.springframework.data.document.mongodb.index.Indexed;
import org.springframework.data.document.mongodb.mapping.DBRef;
import org.springframework.data.document.mongodb.mapping.Document;

/** 
 * @author Raffaele Magliocco jr.
 */
@Document
public class DocumentMaster {
	
	@Id
	protected String id;
	
	@Indexed
	protected String number;
	
	protected String description;
	
	protected int revision;
	
	@DBRef
	protected User createdBy;
	
	protected Date createdDate;
	
	protected String type = "Document";
	
	public DocumentMaster() { }

	/**
	 * @param number
	 * @param description
	 * @param revision
	 * @param createdBy
	 * @param createdDate
	 */
	public DocumentMaster(String number, String description, int revision,
			User createdBy, Date createdDate) {
		this.number = number;
		this.description = description;
		this.revision = revision;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}
	
	@Override
	public String toString() {
		return String.format("Document [id=%s, type=%s, number=%s, description=%s, revision=%d, createdBy=%s, createdDate=%s]", id, type, number, description, revision, createdBy.getUserName(), createdDate.toString());
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
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the revision
	 */
	public int getRevision() {
		return revision;
	}

	/**
	 * @param revision the revision to set
	 */
	public void setRevision(int revision) {
		this.revision = revision;
	}

	/**
	 * @return the createdBy
	 */
	public User getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
}
