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

@Path("/careers")
public class CareerServlet {


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public static List<Career> getCareers() throws SQLException, ClassNotFoundException {
		//DatabaseController d = new DatabaseController();
		//List<Career> l = d.getCareers();
		ArrayList<Career> l = new ArrayList<>();
		l.add(new Career(0, "TEC", "Ing. Computación"));
		l.add(new Career(1, "TEC", "Ing. Computación"));
		l.add(new Career(2, "TEC", "Ing. Computación"));
		l.add(new Career(3, "TEC", "Ing. Computación"));
		
		return l;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public static Career getCareer(@PathParam("id") String idStr) {
		Career c =  new Career(0, "TEC", "Ing. Computación");
		return c;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createCareer(Career career) {

		System.out.println(career.getUniversity());
		System.out.println(career.getCareerName());

		JSONObject object = new JSONObject();
		try {
			object.put("status", "OK"); //object.put("status", "ALREADY_EXISTS");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return Response.status(200).entity(object.toString()).build();
	}

	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteCareer(@PathParam("id") String idStr) {

		String result = "Resultado.......";

		return Response.status(200).entity(result).build();
	}
}
