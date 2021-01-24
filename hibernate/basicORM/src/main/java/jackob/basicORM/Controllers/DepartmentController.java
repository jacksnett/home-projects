package jackob.basicORM.Controllers;

import jackob.basicORM.Models.Department;
import jackob.basicORM.Models.Employee;
import jackob.basicORM.Services.DepartmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    DepartmentServices departmentServices;

    @GetMapping("")
    public List<Department> getDepartments() {
        return this.departmentServices.getAll();
    }

    @GetMapping("/{departmentNumber}/employees")
    public List<Employee> getEmployees(@PathVariable String departmentNumber) {
        return this.departmentServices.getEmployees(departmentNumber);
    }
}
