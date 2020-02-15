# Jersey-Rest-Grizzly
this project is simple rest example using Jersey and Girzzly 

To start the application, import the attached project to any IDE and run using mvn clean compile exec:java
Note: implemented the project using concurrent HashMap not Data base, so that it can be executed anywhere, we can change the Dao layer by configuring the to the database. 
3)	This project contains 4 rest end points for managing employee. 
a.	Add a New employee. 
Endpoint: http://localhost:8080/myapp/employee/addEmployee
Which is required following employee JSON 
{
	"name":"Lokesh",
	"age":"31",
	"sal":"5000",
	"location":"USA"
}
Which will add the employee record to a Map, we can add any no of employee records a unique random id will get generated. 

b.	Get all Employees 
Endpoint: http://localhost:8080/myapp/employee/getAllEmployees
Which will get all the employees. 

c.	Get Employee by employee id:
Endpoint: http://localhost:8080/myapp/employee/geEmployeeById/{id}
Pass the id to the path param so that we’ll get the employee record. 

d.	Delete the employee 
Endpoint: http://localhost:8080/myapp/employee/deleteEmployee/{id}
Pass the employee id to the path Param so that it will delete the employee. 
