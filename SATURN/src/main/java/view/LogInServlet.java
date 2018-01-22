package view;

import controller.DatabaseController;
import java.sql.SQLException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import model.LogIn;
import model.User;

@Path("/login")
public class LogInServlet {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Login(LogIn logIn) throws SQLException, ClassNotFoundException {
		JSONObject object = new JSONObject();

		DatabaseController d = new DatabaseController();
		int userType;
		try {
			userType = d.login(logIn);
                        System.out.println(userType);
			if(userType != -1){
				object.put("status", "OK");
				object.put("userType", userType);
				object.put("userId", d.getUserId(logIn.getEmail()));  //Se debe completar
                                object.put("careerId", d.getCareerId(d.getUserId(logIn.getEmail())));
                                object.put("name", d.getUserName(d.getUserId(logIn.getEmail())));
			}else{
				object.put("status", "WRONG_DATA");
			}


		} catch (JSONException e) {
			e.printStackTrace();
		}
		return Response.status(200).entity(object.toString()).build();
	}
}
