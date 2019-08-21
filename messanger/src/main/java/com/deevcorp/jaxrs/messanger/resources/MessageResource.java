package com.deevcorp.jaxrs.messanger.resources;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.deevcorp.jaxrs.messanger.model.Message;
import com.deevcorp.jaxrs.messanger.service.MessageService;

@Path("/messages")
public class MessageResource {
	
	private MessageService messageService;
	
	public MessageResource() {
		this.messageService = new MessageService();
	}
	
    @GET 
    @Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages() {
    	return this.messageService.getAllMessages();
	}
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{messageId}")
    public Message getMessage(@PathParam("messageId") String messageId) {
    	return this.messageService.getMessage(Long.parseLong(messageId));
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message addMessage(Message message) {
    	return this.messageService.addMessage(message);	
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{messageId}")
    public Message updateMessage(@PathParam("messageId") long messageId,  Message message) {
    	message.setId(messageId);
    	return this.messageService.updateMessage(message);
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{messageId}")
    public Message deleteMessage(@PathParam("messageId") long messageId) {
    	return this.messageService.removeMessage(messageId);
    }
}
