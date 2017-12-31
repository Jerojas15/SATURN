package view;

import controller.DatabaseController;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
import javax.ws.rs.core.Response;

import model.User;

@Path("/assistants")
public class AssistantServlet {
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public static List<User> getAssistants() throws SQLException, ClassNotFoundException {
                DatabaseController d = new DatabaseController();
		List<User> l = d.getUser();
		return l;
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public static User getAssistant(@PathParam("id") String idStr) {
		User c =  new User();
		return c;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createAssistant(User usr) {
		
		String result = "Resultado.......";
		
		return Response.status(200).entity(result).build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateAssistant(@PathParam("id") String idStr) {
		
		String result = "Resultado.......";
		
		return Response.status(200).entity(result).build();
	}

	@DELETE
    @Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteAssistant(@PathParam("id") String idStr) {
		
		String result = "Resultado.......";
		
		return Response.status(200).entity(result).build();
	}
}
