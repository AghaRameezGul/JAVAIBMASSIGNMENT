package org.rameez.com.webapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.rameez.com.webapp.database.DatabaseClass;
import org.rameez.com.webapp.model.Message;


public class MessageService {
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	public MessageService() {
		messages.put(1L, new Message(1, "Record 1", 5));
		messages.put(2L, new Message(2, "Record 2", 10));
		messages.put(3L, new Message(3, "Record 3", 15));
		messages.put(4L, new Message(4, "Record 4", 20));
		messages.put(5L, new Message(5, "Record 5", 25));
		messages.put(6L, new Message(6, "Record 6", 30));
		messages.put(7L, new Message(7, "Record 7", 35));
		messages.put(8L, new Message(8, "Record 8", 40));
		messages.put(9L, new Message(9, "Record 9", 45));
		messages.put(10L, new Message(10, "Record 10", 50));
	}
	
	
	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values()); 
	}
	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
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
}
