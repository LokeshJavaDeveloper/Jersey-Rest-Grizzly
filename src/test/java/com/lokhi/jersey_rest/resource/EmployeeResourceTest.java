package com.lokhi.jersey_rest.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Collection;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Before;
import org.junit.Test;

import com.lokhi.jersey_rest.EmployeeApplication;
import com.lokhi.jersey_rest.dao.EmployeeDao;
import com.lokhi.jersey_rest.model.Employee;

public class EmployeeResourceTest extends JerseyTest {

	String emp_id1, emp_id2;

	protected Application configure() {
		final EmployeeDao dao = new EmployeeDao();
		return new EmployeeApplication(dao);

	}

	protected Response addBook(String name, int age, float sal, String location) {
		Employee emp1 = new Employee();
		emp1.setName(name);
		emp1.setAge(age);
		emp1.setSalary(sal);
		emp1.setLocation(location);
		Entity<Employee> employeeEntity = Entity.entity(emp1, MediaType.APPLICATION_JSON_TYPE);
		return target("employee/addEmployee").request().post(employeeEntity);
	}

	@Before
	public void setUpEmployees() {
		emp_id1 = addBook("Sam", 30, 5000, "USA").readEntity(Employee.class).getId();
		emp_id2 = addBook("Jai", 39, 50000, "INDIA").readEntity(Employee.class).getId();
	}

	@Test
	public void testaddEmployee() {

		Response response = addBook("Sam", 30, 5000, "USA");
		assertEquals(200, response.getStatus());

		Employee resEmployee = response.readEntity(Employee.class);
		assertEquals("Sam", resEmployee.getName());
	}

	@Test
	public void testGetBook() {
		Employee response = target("employee/geEmployeeById").path(emp_id1).request().get(Employee.class);
		assertNotNull(response);

	}

	@Test
	public void testGetBooks() {
		Collection<Employee> response = target("employee/getAllEmployees").request().get(new GenericType<Collection<Employee>>() {
		});
		assertEquals(2, response.size());

	}

	@Test
	public void testGetBookException() {
		Response response = target("employee/geEmployeeById").path("1").request().get();
		assertEquals(404,response.getStatus());

	}

	@Test
	public void testDeleteEmployee() {
		
		Response response= target("employee/deleteEmployee").path(emp_id1).request().delete();
		assertEquals(200, response.getStatus());
	}
	
	@Test
	public void testDeleteEmployeeException() {
		Response response= target("employee/deleteEmployee").path("1").request().delete();
		assertEquals(404, response.getStatus());
	}
}
