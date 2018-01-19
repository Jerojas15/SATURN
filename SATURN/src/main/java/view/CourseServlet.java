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

import model.Course;

@Path("/courses")
public class CourseServlet {


	@GET
	@Path("/careerId/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public static List<Course> getCourses(@PathParam("id") String idStr) throws SQLException, ClassNotFoundException {
		DatabaseController d = new DatabaseController();
		List<Course> l = d.getCourses(Integer.parseInt(idStr));
		return l;
	}
        
        @GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public static List<Course> getCourse(@PathParam("id") String idStr) throws SQLException, ClassNotFoundException {
		DatabaseController d = new DatabaseController();
		List<Course> l = d.getCourse(Integer.parseInt(idStr));
		return l;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createCourse(Course course) throws SQLException, ClassNotFoundException, JSONException {

		System.out.println(course.getName());
                System.out.println(course.getSemester());
		System.out.println(course.getCareerId());

		JSONObject object = new JSONObject();
                DatabaseController d = new DatabaseController();
                if(d.insertNewCourse(course)){
                    object.put("status", "OK"); 
                }
		
		return Response.status(200).entity(object.toString()).build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCourse(@PathParam("id") String idStr, Course c) throws SQLException, ClassNotFoundException {

		String status = "WRONG";
		JSONObject object;
                DatabaseController d = new DatabaseController();
                if(d.updateCourse(c, Integer.parseInt(idStr))){
                    status = "OK";
                }
		object = new JSONObject();
		try {
			object.put("status", status);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return Response.status(200).entity(object.toString()).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteCourse(@PathParam("id") String idStr) throws SQLException, ClassNotFoundException {
                String status;
		JSONObject object;
		status = "WRONG";
		
		object = new JSONObject();
		try {
                    DatabaseController d = new DatabaseController();
                    if(d.deleteCourse(Integer.parseInt(idStr))){
                        status = "OK";
                        
                    }
			object.put("status", status);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return Response.status(200).entity(object).build();
	}
}
