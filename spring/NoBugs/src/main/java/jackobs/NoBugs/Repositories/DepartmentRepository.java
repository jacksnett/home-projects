package jackobs.NoBugs.Repositories;

import jackobs.NoBugs.Modules.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, String> {

}
