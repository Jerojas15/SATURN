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
	@Produces(MediaType.APPLICATION_JSON)
	public static List<Course> getCourses() throws SQLException, ClassNotFoundException {
		//DatabaseController d = new DatabaseController();
		//List<Course> l = d.getCourses();
		ArrayList<Course> l = new ArrayList<>();
		l.add(new Course(0, "Introducción a la Programación", 1, 0));
		l.add(new Course(1, "Taller de Programación", 1, 1));
		l.add(new Course(2, "Estructuras de Datos", 2, 2));
		l.add(new Course(3, "Programación Orientada a Objetos", 2, 3));
		
		return l;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public static Course getCourse(@PathParam("id") String idStr) {
		Course c =  new Course(0, "Introducción a la Programación", 1, 0);
		return c;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createCourse(Course course) {

		System.out.println(course.getName());
                System.out.println(course.getSemester());
		System.out.println(course.getCareerId());

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
	public Response updateCourse(@PathParam("id") String idStr) {

		String result = "Resultado.......";

		return Response.status(200).entity(result).build();
	}

	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteCourse(@PathParam("id") String idStr) {

		String result = "Resultado.......";

		return Response.status(200).entity(result).build();
	}
}
