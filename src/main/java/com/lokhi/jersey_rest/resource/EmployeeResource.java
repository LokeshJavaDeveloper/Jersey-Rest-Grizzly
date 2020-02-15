package com.lokhi.jersey_rest.resource;

import java.util.Collection;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.lokhi.jersey_rest.dao.EmployeeDao;
import com.lokhi.jersey_rest.exception.EmployeeException;
import com.lokhi.jersey_rest.model.Employee;

@Path("employee")
public class EmployeeResource {

	  @Context EmployeeDao employeeDao;
	 
	@Path("/getAllEmployees")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();

	}

	@Path("/geEmployeeById/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Employee geEmployeeById(@PathParam("id") String id) throws EmployeeException {
		return (employeeDao.getEmployee(id));
	}
	
	@Path("/addEmployee")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Employee addEmployee(@Valid @NotNull Employee employee) {
		return employeeDao.addEmployee(employee);
	}
	
	@Path("/deleteEmployee/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteEmployee(@PathParam("id") String id) throws EmployeeException {
		return employeeDao.deleteEmployee(id);
	}
	

}
