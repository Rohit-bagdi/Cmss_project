package in.cmss.icici.uotm.core.redis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.cmss.icici.uotm.core.redis.service.EmployeeService;
import in.cmss.icici.uotm.identity.vo.Employee;

@RestController
@RequestMapping("/uotm/redis/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	private Employee addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
		return employeeService.getEmployee(employee.getId());
	}

	@GetMapping
	private List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	private Employee getEmployee(@PathVariable("id") int id) {
		return employeeService.getEmployee(id);
	}
}
