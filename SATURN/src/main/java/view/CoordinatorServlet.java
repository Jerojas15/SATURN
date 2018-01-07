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

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import model.User;

@Path("/coordinators")
public class CoordinatorServlet {
        

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public static List<User> getCoordinators() throws SQLException, ClassNotFoundException {
		//DatabaseController d = new DatabaseController();
		//List<User> l = d.getUser();
		ArrayList<User> l = new ArrayList<>();
		l.add(new User(0, "jyock1997@gmail.com", null, "Jose Paulo", "Yock Fuentes", 0, 0));
		l.add(new User(1, "je@hotmail.com", null, "Julio Esteban", "Rojas", 0, 1));
		l.add(new User(2, "sjenkins@siua.ac.cr", null, "Scarlet", "Jenkins", 0, 2));
		l.add(new User(3, "jmiguelh@gmail.com", null, "Jose Miguel", "Hernandez", 0, 3));
		
		return l;
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public static User getCoordinator(@PathParam("id") String idStr) {
		User c =  new User();
		return c;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createCoordinator(User usr) {
		
		System.out.println(usr.getUserName());
		System.out.println(usr.getName());
		System.out.println(usr.getLastName());
                System.out.println(usr.getCareerId());
		
		JSONObject object = new JSONObject();
		try {
			object.put("status", "OK"); //object.put("status", "ALREADY_EXISTS");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return Response.status(200).entity(object.toString()).build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCoordinator(@PathParam("id") String idStr) {
		
		String result = "Resultado.......";
		
		return Response.status(200).entity(result).build();
	}

	@DELETE
        @Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteCoordinator(@PathParam("id") String idStr) {
		
		String result = "Resultado.......";
		
		return Response.status(200).entity(result).build();
	}
}
