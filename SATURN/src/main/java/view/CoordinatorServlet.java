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
		DatabaseController d = new DatabaseController();
		List<User> l = d.getUserbyType(2,1);

		
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
	public Response updateCoordinator(@PathParam("id") String idStr, User usr) throws SQLException, ClassNotFoundException {
		//System.out.println(idStr);
		
		String status;
		JSONObject object;
		
		//System.out.println(idStr);
		status = "WRONG";
		
		object = new JSONObject();
		try {
                    DatabaseController d = new DatabaseController();
                    if(d.updateUser(usr, Integer.parseInt(idStr))){
                        status = "OK";
                        
                    }
			object.put("status", status);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return Response.status(200).entity(object.toString()).build();
	}

	@DELETE
        @Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteCoordinator(@PathParam("id") String idStr) throws SQLException, ClassNotFoundException {
		String status;
		JSONObject object;
		status = "WRONG";
		
		object = new JSONObject();
		try {
                    DatabaseController d = new DatabaseController();
                    if(d.deleteUser(Integer.parseInt(idStr))){
                        status = "OK";
                        
                    }
			object.put("status", status);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return Response.status(200).entity(object.toString()).build();
	}
}
