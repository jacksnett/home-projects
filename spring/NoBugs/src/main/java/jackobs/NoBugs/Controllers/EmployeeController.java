package jackobs.NoBugs.Controllers;

import jackobs.NoBugs.Modules.Employee;
import jackobs.NoBugs.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("")
    public List<Employee> getAll() {
        return this.employeeService.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable String id) {
        this.employeeService.deleteById(id);
    }

    @PostMapping("")
    public void addEmployee(@RequestBody Employee employee) {
        this.employeeService.add(employee);
    }

    @GetMapping("/{id}")
    public Optional<Employee> getById(@PathVariable String id) {
        return this.employeeService.getById(id);
    }

    @PutMapping("/Employees")
    public void updateEmployee(@RequestBody Employee employee) {
        this.employeeService.update(employee);
    }
}
