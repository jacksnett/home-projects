package jackob.basicORM.Repositories;

import jackob.basicORM.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    List<Employee> findByDepartmentNumber_departmentName(String departmentName);
}
