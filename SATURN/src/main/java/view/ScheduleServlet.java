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
import databaseConnector.ScheduleConnector;
import databaseConnector.SessionConnector;
import model.AlgorithmInput;
import model.Availability;
import model.Career;
import model.Classroom;
import model.User;
import model.ClassNow;
import model.ClassroomType;
import model.LeftClass;
@Path("/schedules")
public class ScheduleServlet {
    
        
        
        
        @GET
        @Path("/leftSession/{id}")
        @Produces(MediaType.APPLICATION_JSON)
        public static List<LeftClass> getLeftSession(@PathParam("id") Integer idStr) throws SQLException, ClassNotFoundException, JSONException {
		DatabaseController d = new DatabaseController();
		List<String> result = d.getLeftCourses(idStr) ;
                ArrayList<LeftClass> solution = new ArrayList<>();
                for(int i = 0;i<result.size();i++){
                    LeftClass l = new LeftClass();
                    l.setLeft(result.get(i));
                    solution.add(l);
                }
                for(int i = 0;i<result.size();i++){
                    System.out.println(solution.get(i));
                }
                List<LeftClass> aux = solution;
                return aux;
	}
        
        @GET
	@Path("/lastSchedules/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public static JSONObject getCreatedSchedules(@PathParam("id") Integer type) throws SQLException, ClassNotFoundException, JSONException {
		DatabaseController d = new DatabaseController();
		int result = d.getVersion(type);
                JSONObject object = new JSONObject();
                object.put("size", result);
                
                return object;
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
        @Path("/algorithm")
        @Consumes(MediaType.APPLICATION_JSON)
	public Response startAlgorithm(AlgorithmInput input) throws SQLException, ClassNotFoundException {
            DatabaseController controller = new DatabaseController();
            String status = "";
		JSONObject object;		
		List<Classroom> types = controller.getClassroomsTypes();
		
		          
		try {     
                    //for(int i = 1;i<=1/*types.size()*/;i++){
			AlgorithmController d = new AlgorithmController(input.getTimes(),input.getType());
                        
			if (d.start())
                            status = "OK";
			else
                            status = "ALREADY_EXISTS";
                    //}
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
