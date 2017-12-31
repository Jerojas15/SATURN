package view;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import model.LogIn;

@Path("/login")
public class LogInServlet {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createCareer(LogIn logIn) {

		JSONObject object = new JSONObject();
		try {
			object.put("status", "OK");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return Response.status(200).entity(object.toString()).build();
	}
}
