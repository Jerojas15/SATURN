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

import model.Group;

@Path("/groups")
public class GroupServlet {
        @GET
	@Produces(MediaType.APPLICATION_JSON)
	public static List<Group> getGroups() throws SQLException, ClassNotFoundException {
		//DatabaseController d = new DatabaseController();
		//List<Course> l = d.getCourses();
		ArrayList<Group> l = new ArrayList<>();
		l.add(new Group(20, 0, 0, 1, 90));
		l.add(new Group(20, 1, 1, 1, 90));
		l.add(new Group(20, 2, 2, 2, 90));
		l.add(new Group(20, 3, 3, 2, 90));
		
		return l;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public static Group getGroup(@PathParam("id") String idStr) {
		Group c =  new Group(20, 0, 0, 1, 90);
		return c;
	}
        /*
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
        */

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createGroup(Group group) {

	
                String status;
		JSONObject object;		
		DatabaseController d;
                
                try {
			d = new DatabaseController();
			if (d.insertNewGroup(group))
				status = "OK";
			else
				status = "ALREADY_EXISTS";
		} catch (ClassNotFoundException | SQLException e1) {
			return Response.status(500).entity(e1.toString()).build();
		}

		object = new JSONObject();
		try {
			object.put("status", status); //object.put("status", "ALREADY_EXISTS");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return Response.status(200).entity(object.toString()).build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateGroup(@PathParam("id") String idStr) {

		String result = "Resultado.......";

		return Response.status(200).entity(result).build();
	}

	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteGroup(@PathParam("id") String idStr) throws SQLException, ClassNotFoundException {

		String status;
		JSONObject object;
		status = "WRONG";
		
		object = new JSONObject();
                
                try {
                    DatabaseController d = new DatabaseController();
                    if(d.deleteGroup(Integer.parseInt(idStr))){
                        status = "OK";
                        
                    }
			object.put("status", status);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return Response.status(200).entity(object).build();
	}
}