package com.deevcorp.jaxrs.messanger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.deevcorp.jaxrs.messanger.database.DatabaseClass;
import com.deevcorp.jaxrs.messanger.model.Message;

public class MessageService {
	
//	private List<Message> messages = new ArrayList<Message>(DatabaseClass.getMessages().values());
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	
	public MessageService() {
	
	}
	
	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		
		return message;
	}
	
	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
	}
	
	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
	
	public List<Message> getMessagesByYear(int year) {
		List<Message> messagesForYear = new ArrayList<>();
		Calendar calender = Calendar.getInstance();
		
		for (Message message : messages.values()) {
			calender.setTime(message.getCreated());
			if (calender.get(Calendar.YEAR) == year) {
				messagesForYear.add(message);
			}
		}
		
		return messagesForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size) {
		List<Message> messagesCopy = new ArrayList<>(messages.values());
		if (start + size > messagesCopy.size())
			return new ArrayList<Message>();
		
		return messagesCopy.subList(start, start + size); 
	}
}
