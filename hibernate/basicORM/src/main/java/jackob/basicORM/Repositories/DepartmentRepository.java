package jackob.basicORM.Repositories;

import jackob.basicORM.Models.Department;
import jackob.basicORM.Models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {
}
