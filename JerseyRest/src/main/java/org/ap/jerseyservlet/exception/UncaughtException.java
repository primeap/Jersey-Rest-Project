package org.ap.jerseyservlet.exception;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class UncaughtException extends Throwable implements ExceptionMapper<Throwable> {
	private static final long serialVersionUID = 1L;

	
	
	@Override
	public Response toResponse(Throwable exception) {
		return Response.status(HttpServletResponse.SC_BAD_REQUEST).entity("Something bad happened. Please try again !!").type("text/plain").build();
	}
	public static void main(String[] args) {
		System.out.println(HttpServletResponse.SC_BAD_REQUEST);
	}
}
