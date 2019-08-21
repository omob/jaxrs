package com.deevcorp.jaxrs.messanger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	private long id;
	private String author;
	private Date created;
	private String message;
	
	public Message() { }
	
	public Message(Long id, String message, String author, Date created) {
		this.id = id;
		this.message = message;
		this.author = author;
		this.created = created;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
