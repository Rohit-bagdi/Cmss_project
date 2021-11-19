package in.cmss.icici.uotm.core.redis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import in.cmss.icici.uotm.core.redis.repository.EmployeeRepository;
import in.cmss.icici.uotm.identity.vo.Employee;

@Component
@Service
public class EmployeeService {

	static EmployeeRepository employeeRepository;

	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	public List<Employee> getAllEmployees() {
		return (List<Employee>) employeeRepository.findAll();
	}

	public Employee getEmployee(int ID) {
		return employeeRepository.findById(String.valueOf(ID)).get();
	}

	public void updateEmployee(Employee employee) {
		addEmployee(employee);
	}

	public void deleteEmployee(int ID) {
		employeeRepository.deleteById(String.valueOf(ID));
	}

	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public EmployeeService() {
		this(employeeRepository);
	}

}
