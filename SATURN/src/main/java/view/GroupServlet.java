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

import model.Group;
import model.Session;

@Path("/groups")
public class GroupServlet {

    @GET
    @Path("/careerId/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public static List<Group> getGroups(@PathParam("id") String idStr) throws SQLException, ClassNotFoundException {
        DatabaseController d = new DatabaseController();
        List<Group> l = d.getGroupsByCareerId(Integer.parseInt(idStr));
        return l;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public static Group getGroup(@PathParam("id") int id) throws SQLException, ClassNotFoundException {
        DatabaseController d = new DatabaseController();
        Group l = d.getGroupById(id);
        return l;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createGroup(Group group) {

        String status;
        JSONObject object;
        DatabaseController d;
        try {
            d = new DatabaseController();
            if (d.insertNewGroup(group)) {
                status = "OK";
            } else {
                status = "ALREADY_EXISTS";
            }
        } catch (ClassNotFoundException | SQLException e1) {
            return Response.status(500).entity(e1.toString()).build();
        }

        object = new JSONObject();
        try {
            object.put("status", status); //object.put("status", "ALREADY_EXISTS");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return Response.status(200).entity(object.toString()).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateGroup(@PathParam("id") int id, Group group) throws SQLException, ClassNotFoundException {

        String status;
        JSONObject object;

        status = "FAIL";

        object = new JSONObject();
        try {
            DatabaseController d = new DatabaseController();
            if (d.updateGroup(group, id) && d.updateSessions(id, group.getSessions())) {
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
    public Response deleteGroup(@PathParam("id") int id) throws SQLException, ClassNotFoundException {

        String status;
        JSONObject object;
        status = "WRONG";

        object = new JSONObject();

        try {
            DatabaseController d = new DatabaseController();
            if (d.deleteGroup(id)) {
                status = "OK";

            }
            object.put("status", status);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return Response.status(200).entity(object).build();
    }

    @GET
    @Path("/sessions/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public static List<Session> getSessionsGroups(@PathParam("id") String idStr) throws SQLException, ClassNotFoundException {
        DatabaseController d = new DatabaseController();
        List<Session> l = d.getSessions(Integer.parseInt(idStr));
        return l;
    }
}
