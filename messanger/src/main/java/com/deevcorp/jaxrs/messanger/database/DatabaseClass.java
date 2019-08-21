package com.deevcorp.jaxrs.messanger.database;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.deevcorp.jaxrs.messanger.model.Message;
import com.deevcorp.jaxrs.messanger.model.Profile;

public class DatabaseClass {
	private static Map<Long, Message> messages = new HashMap<Long, Message>();
	private static Map<Long, Profile> profiles = new HashMap<Long, Profile>();
	
	static {
		messages.put((long) 1, new Message((long) 001, "Hello World", "DeevCorp", new Date()));
		messages.put((long) 2, new Message((long) 002, "This is working", "DeevCorp", new Date()));
		messages.put((long) 3, new Message((long) 003, "Yes it works", "DeevCorp", new Date()));
	}
	
	public  DatabaseClass() {
		
	}
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	
	public static Map<Long, Profile> getProfiles() {
		return profiles;
	}
			
}
