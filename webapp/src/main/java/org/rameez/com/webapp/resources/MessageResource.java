package org.rameez.com.webapp.resources;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.rameez.com.webapp.model.Message;
import org.rameez.com.webapp.service.MessageService;

@Path("/corpusData")

public class MessageResource {
	MessageService messageservice = new MessageService();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(){
		return messageservice.getAllMessages();
	}
	@POST
	@Path("/corpusUpdate")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message){
		return messageservice.addMessage(message);
	}
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") long id) {	
		return messageservice.getMessage(id);
	}
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long id, Message message) {
		message.setId(id);
		return messageservice.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") long id) {
		messageservice.removeMessage(id);
	}
}
