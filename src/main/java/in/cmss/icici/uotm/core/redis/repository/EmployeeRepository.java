package in.cmss.icici.uotm.core.redis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.cmss.icici.uotm.identity.vo.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String> {
}
