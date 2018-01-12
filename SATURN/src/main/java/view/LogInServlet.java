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
			if(userType != -1){
				object.put("status", "OK");
				object.put("usrType", userType);
				object.put("userId", 0);  //Se debe completar
			}else{
				object.put("status", "WRONG_DATA");
			}


		} catch (JSONException e) {
			e.printStackTrace();
		}
		return Response.status(200).entity(object.toString()).build();
	}
}
