package jackob.basicORM.Repositories;

import jackob.basicORM.Models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {
    List<Project> findByProjNo(String projno);
    List<Project> findByProjName(String projname);
    List<Project> findByDeptNo(String deptno);
    List<Project> findByPrEndDateBeforeAndPrStaffLessThan(Date prEndDate, int prStaff);
    List<Project> findByMajorProjectIsNullOrPrStaffGreaterThan(int prsStaff);
    List<Project> findByProjNameStartingWith(String startWith);
}
