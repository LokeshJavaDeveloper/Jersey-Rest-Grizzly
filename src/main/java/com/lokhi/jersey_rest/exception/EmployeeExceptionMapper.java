package com.lokhi.jersey_rest.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class EmployeeExceptionMapper implements ExceptionMapper<EmployeeException> {

	@Override
	public Response toResponse(EmployeeException exception) {
		return Response.status(404).entity(exception.getMessage()).type("text/plan").build();
	}

}
