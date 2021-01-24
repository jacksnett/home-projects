package jackob.basicORM.Services;

import jackob.basicORM.Models.Employee;
import jackob.basicORM.Models.Project;
import jackob.basicORM.Repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class ProjectServices {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAll() {
        return this.projectRepository.findAll();
    }

    public List<Project> getByID(String id) {
        return this.projectRepository.findByProjNo(id);
    }

    public List<Project> getByName(String name) {
        return this.projectRepository.findByProjName(name);
    }

    public List<Project> getByDeptNo(String deptNo) {
        return this.projectRepository.findByDeptNo(deptNo);
    }

    public List<Project> prEndBeforeAndStaffLessThan(int year, int staffNo) {
        Date date = new GregorianCalendar(year, 1, 1).getTime();
        return this.projectRepository.findByPrEndDateBeforeAndPrStaffLessThan(date, staffNo);
    }

    public List<Project> noMajOrMoreThan(int moreThan) {
        return this.projectRepository.findByMajorProjectIsNullOrPrStaffGreaterThan(moreThan);
    }

    public List<Project> startsWith(String character) {
        return this.projectRepository.findByProjNameStartingWith(character);
    }

    public Employee getRespEmp(String projNo) {
        return this.projectRepository.findById(projNo).get().getRespEmp();
    }
}
