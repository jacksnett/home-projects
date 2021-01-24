package jackob.basicORM.Controllers;

import jackob.basicORM.Models.Employee;
import jackob.basicORM.Models.Project;
import jackob.basicORM.Services.ProjectServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectServices projectServices;

    @GetMapping("")
    public List<Project> getAll() {
        return projectServices.getAll();
    }

    @GetMapping("id/{id}")
    public List<Project> getById(@PathVariable String id) {
        return this.projectServices.getByID(id);
    }

    @GetMapping("/name/{name}")
    public List<Project> getByProjectName(@PathVariable String name) {
        return this.projectServices.getByName(name);
    }

    @GetMapping("/deptname/{deptno}")
    public List<Project> getByProjectDeptno(@PathVariable String deptno) {
        return this.projectServices.getByDeptNo(deptno);
    }

    @GetMapping("/startswith/{letter}")
    public List<Project> getProjectsThatStartWith(@PathVariable String letter) {
        return this.projectServices.startsWith(letter);
    }

    @GetMapping("/before/year/{year}/staff/below/{employees}")
    public List<Project> getByPrendateBeforeAndPrstaffLessThan(
            @PathVariable int year, @PathVariable int employees) {
        return this.projectServices.prEndBeforeAndStaffLessThan(year, employees);
    }

    @GetMapping("/major/none/staff/above/{employees}")
    public List<Project> getByMajprogIsNullOrPrstaffGreaterThan(@PathVariable int employees) {
        return this.projectServices.noMajOrMoreThan(employees);
    }

    @GetMapping("/{projectNumber}/responsible-employee")
    public Employee getResponsibleEmployee(@PathVariable String projectNumber) {
        return this.projectServices.getRespEmp(projectNumber);
    }
}
