package org.anurag.javabrains.messenger1.resources;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.anurag.javabrains.messenger1.service.MessageService;
import org.anurag.javabrains.messenger1.model.message;

@Path("/messages")
public class MessageResource {
	MessageService messageService= new MessageService();
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<message> getMessage() {
		return messageService.getAllMessage();
	}

/*public class MessageResource {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessage() {
		return "hello world";
	}*/

}
