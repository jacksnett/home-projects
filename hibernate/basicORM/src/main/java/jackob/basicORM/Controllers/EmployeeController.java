package jackob.basicORM.Controllers;

import jackob.basicORM.Models.Employee;
import jackob.basicORM.Services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeServices employeeServices;

    @GetMapping("/department-name/{department}")
    public List<Employee> getEmployeesOfDepartment(@PathVariable String department) {
        return this.employeeServices.findByDepartmentNumber(department);
    }
}
