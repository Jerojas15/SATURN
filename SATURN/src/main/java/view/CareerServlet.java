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
		DatabaseController d = new DatabaseController();
		List<Career> l = d.getCareers();
		
		return l;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public static Career getCareer(@PathParam("id") String idStr) {
		//Career c =  new Career(0, "TEC", "Ing. Computación");
		//return c;
                return null;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createCareer(Career career) throws SQLException, ClassNotFoundException {
            
		JSONObject object = new JSONObject();
		try {
                        DatabaseController d = new DatabaseController();
                        d.insertNewCareer(career);
			object.put("status", "OK"); //object.put("status", "ALREADY_EXISTS");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return Response.status(200).entity(object.toString()).build();
	}
        
        @PUT
        @Path("/{id}")
        @Consumes(MediaType.APPLICATION_JSON)
        public Response updateCareer(@PathParam("id") String idStr, Career career) throws SQLException, ClassNotFoundException {
            String status;
            JSONObject object;
            
            status = "WRONG";
            object = new JSONObject();
            try {
                    DatabaseController d = new DatabaseController();
                    if(d.updateCareer(career, Integer.parseInt(idStr))){ 
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
	public Response deleteCareer(@PathParam("id") String idStr, Career career) throws SQLException, ClassNotFoundException {

		String status;
		JSONObject object;
                
                status = "WRONG";
                object = new JSONObject();
                
                try {
                        DatabaseController d = new DatabaseController();
                        if(d.deleteCareer(career)){ 
                            status = "OK";
                        }
                            object.put("status", status);
                        
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return Response.status(200).entity(object.toString()).build();
              
	}

}
