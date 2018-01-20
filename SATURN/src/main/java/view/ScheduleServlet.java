package view;

import controller.AlgorithmController;
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

import controller.DatabaseController;
import model.Availability;
import model.Career;
import model.Classroom;
import model.User;
import model.ClassNow;
@Path("/schedules")
public class ScheduleServlet {
    
        
        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public static List<Classroom> getTypes(@PathParam("id") String idStr) throws SQLException, ClassNotFoundException, JSONException {
		DatabaseController d = new DatabaseController();
		List<Classroom> result = d.getClassroomsTypes();
                JSONObject object = new JSONObject();
                
                return result;
	}
        
        @GET
	@Path("/length/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public static JSONObject getProfessor(@PathParam("id") String idStr) throws SQLException, ClassNotFoundException, JSONException {
		DatabaseController d = new DatabaseController();
		int result = d.getClassroomsQuantity(Integer.parseInt(idStr));
                JSONObject object = new JSONObject();
                object.put("len", result);
                
                return object;
	}
        
        @POST
        @Path("/timetables/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public static Response getSchedules(@PathParam("id") Integer idStr, ClassNow cl) throws SQLException, ClassNotFoundException, JSONException {
		DatabaseController d = new DatabaseController();
		JSONObject object = new JSONObject();
                String result2 = "";
                result2 = d.getClassNow(cl, idStr);
                object.put("name", result2);
                
                
		return Response.status(200).entity(object.toString()).build();
	}
        
        @POST
        @Path("/algorithm/{id}")
	public Response createTeacher(@PathParam("id") String idStr) {
		String status;
		JSONObject object;		
		AlgorithmController d;
		
		
		try {                  
			d = new AlgorithmController(Integer.parseInt(idStr));
			if (d.start())
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
		return Response.status(200).entity(object).build();
	}	
}
