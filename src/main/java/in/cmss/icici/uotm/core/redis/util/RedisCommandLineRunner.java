package in.cmss.icici.uotm.core.redis.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import in.cmss.icici.uotm.core.redis.service.EmployeeService;
import in.cmss.icici.uotm.identity.vo.Employee;
import lombok.extern.slf4j.Slf4j;
import redis.embedded.RedisServer;

@Profile("dev")
@Component
@Slf4j
public class RedisCommandLineRunner implements CommandLineRunner {
	
	@Autowired
	EmployeeService employeeService;
	private RedisServer redisServer = new RedisServer();
	
	public void run(String... args) throws Exception {
		redisServer.start();
		log.info("RedisCommandLineRunner starts");
		log.info("Saving employees in cache.");
		// Add to cache
		Employee e1 = Employee.builder().id(1111).userID("joshua.amaral.1111").name("Joshua Amaral").build();
		Employee e2 = Employee.builder().id(2222).userID("joshua.amaral.2222").name("Joshua Amaral").build();
		Employee e3 = Employee.builder().id(3333).userID("joshua.amaral.3333").name("Joshua Amaral").build();
		employeeService.addEmployee(e1);
		employeeService.addEmployee(e2);
		employeeService.addEmployee(e3);
		// Get all from cache
		List<Employee> employeeList = employeeService.getAllEmployees();
		// Print all
		log.info("All employees from cache");
		for (Employee employee : employeeList) {
			log.info(employee.toString());
		}
		// Get from cache
		Employee retrievedEmployee = employeeService.getEmployee(3333);
		log.info("Retrived : " + retrievedEmployee);
		// Update to cache
		retrievedEmployee.setName("joshua3333");
		employeeService.updateEmployee(retrievedEmployee);
		// Delete from cache
		employeeService.deleteEmployee(2222);
		// Get all from cache after delete
		log.info("All employees from cache after delete");
		employeeList.clear();
		employeeList = employeeService.getAllEmployees();
		// Print all
		for (Employee employee : employeeList) {
			log.info(employee.toString());
		}
		redisServer.stop();
	}

}
