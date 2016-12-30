package org.ap.jerseyservlet.rest;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.ap.jerseyservlet.dto.Student;
import org.ap.jerseyservlet.exception.UncaughtException;


@Path("/services")
public class RESTfulHelloWorld {
	@GET
	@Path("/hello")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response hello(@QueryParam("name") String name) {
		String output = "Hello " + name;
		
		return Response.status(HttpServletResponse.SC_OK).entity(output).build();
	}

	@GET
	@Path("/hi/{name}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response hi(@PathParam("name") String name) throws UncaughtException {
		if( (name+"").trim().length()==0 ){
			throw new UncaughtException();
		}
		String output = "Hi " + name;
		return Response.status(HttpServletResponse.SC_OK).entity(output).build();
	}

	@GET
	@Path("/dob/{year}/{month}/{day}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response dob(@PathParam("year") int year, @PathParam("month") int month, @PathParam("day") int day) {
		String date = year + "/" + month + "/" + day;
		return Response.status(HttpServletResponse.SC_OK).entity("getUserHistory is called, year/month/day : " + date).build();

	}

	@GET
	@Path("/student")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response student() {
		Student s = new Student("Arvind", "Basna");
		return Response.status(HttpServletResponse.SC_OK).entity(s).build();

	}
	@POST
	@Path("/student")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response modifyStudent(Student student) {
		student.setAddress(student.getAddress()+"  "+"  Modified");
		return Response.status(HttpServletResponse.SC_OK).entity(student).build();

	}
	
	
}