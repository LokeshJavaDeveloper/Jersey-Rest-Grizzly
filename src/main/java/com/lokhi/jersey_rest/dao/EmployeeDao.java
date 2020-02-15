package com.lokhi.jersey_rest.dao;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.ws.rs.core.Response;

import com.lokhi.jersey_rest.exception.EmployeeException;
import com.lokhi.jersey_rest.model.Employee;

public class EmployeeDao {

	public Map<String, Employee> employees;

	public EmployeeDao() {
		employees = new ConcurrentHashMap<String, Employee>();
	}

	public Collection<Employee> getAllEmployees() {
		return employees.values();
	}

	public Employee getEmployee(String id) throws EmployeeException{
		if(employees.containsKey(id)) {
			return employees.get(id);
		}else
			throw new EmployeeException("Employee::"+id+"::Not found !");
	}

	public Employee addEmployee(Employee employee) {
		employee.setId(UUID.randomUUID().toString());
		employees.put(employee.getId(), employee);
		return employee;
	}
	
	public Response deleteEmployee(String id) throws EmployeeException{
		if(!employees.containsKey(id)) {
			throw new EmployeeException("Employee::"+ id +":not found to delete!");
		}
		Employee emp=employees.remove(id);
			return Response.status(200).entity("Successfully deleted employe::"+emp.getId()).type("text/plan").build();
	}
}
