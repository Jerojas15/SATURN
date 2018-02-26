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
import model.Classroom;
import model.ClassroomType;
import model.User;

@Path("/classrooms")
public class ClassroomServlet {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Classroom> getClassrooms() throws SQLException, ClassNotFoundException {
        DatabaseController d = new DatabaseController();
        List<Classroom> l = d.getClassrooms();
        return l;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Classroom getClassroom(@PathParam("id") int id) throws SQLException, ClassNotFoundException {
        DatabaseController d = new DatabaseController();
        Classroom c = d.getClassroom(id);
        return c;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createClassroom(Classroom classroom) {

        String status;
        JSONObject object;
        DatabaseController d;
        try {
            d = new DatabaseController();
            if (d.insertNewClassroom(classroom)) {
                status = "OK";
            } else {
                status = "ALREADY_EXISTS";
            }
        } catch (ClassNotFoundException | SQLException e1) {
            return Response.status(500).entity(e1.toString()).build();
        }

        object = new JSONObject();
        try {
            object.put("status", status);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return Response.status(200).entity(object.toString()).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateClassroom(@PathParam("id") int id, Classroom classroom) {

        String status;
        JSONObject object;
        DatabaseController d;
        status = "FAIL";
        try {
            d = new DatabaseController();
            if (d.updateClassroom(id, classroom)) {
                status = "OK";
            }
        } catch (ClassNotFoundException | SQLException e1) {
            return Response.status(500).entity(e1.toString()).build();
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
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteClassroom(@PathParam("id") int id) throws SQLException, ClassNotFoundException {
        String status;
        JSONObject object;
        DatabaseController d;
        status = "FAIL";
        try {
            d = new DatabaseController();
            if (d.deleteClassroom(id)) {
                status = "OK";
            }
        } catch (ClassNotFoundException | SQLException e1) {
            return Response.status(500).entity(e1.toString()).build();
        }

        object = new JSONObject();
        try {
            object.put("status", status);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return Response.status(200).entity(object.toString()).build();
    }

    @GET
    @Path("/types")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ClassroomType> getClassroomTypes() throws SQLException, ClassNotFoundException {
        DatabaseController d = new DatabaseController();
        List<ClassroomType> l = d.getClassroomTypes();
        return l;
    }

    @GET
    @Path("/types/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ClassroomType getClassroomType(@PathParam("id") int id) throws SQLException, ClassNotFoundException {
        DatabaseController d = new DatabaseController();
        ClassroomType c = d.getClassroomType(id);
        return c;
    }

    @POST
    @Path("/types")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createClassroomType(ClassroomType classroomType) {

        String status;
        JSONObject object;
        DatabaseController d;
        try {
            d = new DatabaseController();
            if (d.insertNewClassroomType(classroomType)) {
                status = "OK";
            } else {
                status = "ALREADY_EXISTS";
            }
        } catch (ClassNotFoundException | SQLException e1) {
            return Response.status(500).entity(e1.toString()).build();
        }

        object = new JSONObject();
        try {
            object.put("status", status);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return Response.status(200).entity(object.toString()).build();
    }

    @PUT
    @Path("/types/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateClassroomType(@PathParam("id") int id, ClassroomType classroomType) {

        String status;
        JSONObject object;
        DatabaseController d;
        status = "FAIL";
        try {
            d = new DatabaseController();
            if (d.updateClassroomType(id, classroomType)) {
                status = "OK";
            }
        } catch (ClassNotFoundException | SQLException e1) {
            return Response.status(500).entity(e1.toString()).build();
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
    @Path("/types/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteClassroomType(@PathParam("id") int id) throws SQLException, ClassNotFoundException {
        String status;
        JSONObject object;
        DatabaseController d;
        status = "FAIL";
        try {
            d = new DatabaseController();
            if (d.deleteClassroomType(id)) {
                status = "OK";
            }
        } catch (ClassNotFoundException | SQLException e1) {
            return Response.status(500).entity(e1.toString()).build();
        }

        object = new JSONObject();
        try {
            object.put("status", status);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return Response.status(200).entity(object.toString()).build();
    }
}
