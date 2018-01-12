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

import model.Career;
import model.User;

@Path("/assistants")
public class AssistantServlet {


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public static List<User> getAssistants() throws SQLException, ClassNotFoundException {
		DatabaseController d = new DatabaseController();
		List<User> l = d.getUserbyType(User.TYPE.ASSISTANT.ordinal(), 1);
		/*
		ArrayList<User> l = new ArrayList<>();
		l.add(new User(0, "jyock1997@gmail.com", "Jose Paulo", "Yock Fuentes", 0));
		l.add(new User(1, "je@hotmail.com", "Julio Esteban", "Rojas", 0));
		l.add(new User(2, "sjenkins@siua.ac.cr", "Scarlet", "Jenkins", 0));
		l.add(new User(3, "jmiguelh@gmail.com", "Jose Miguel", "Hernandez", 0));
		 */

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

		String status;
		JSONObject object;		
		DatabaseController d;

		try {
			d = new DatabaseController();
			if (d.insertNewUser(usr))
				status = "OK";
			else
				status = "ALREADY_EXISTS";
		} catch (ClassNotFoundException | SQLException e1) {
			return Response.status(500).entity(e1.toString()).build();
		}

		object = new JSONObject();
		try {
			object.put("status", status);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return Response.status(200).entity(object.toString()).build();
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
	public Response deleteAssistant(@PathParam("id") String idStr) {


		String result = "Resultado.......";

		return Response.status(200).entity(result).build();
	}
}
