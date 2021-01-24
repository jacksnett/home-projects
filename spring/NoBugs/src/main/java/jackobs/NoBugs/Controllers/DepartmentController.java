package jackobs.NoBugs.Controllers;

import jackobs.NoBugs.Modules.Department;
import jackobs.NoBugs.Services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("")
    public List<Department> getAll() {return this.departmentService.getAll(); }

    @GetMapping("/{id}")
    public Department getById(@PathVariable String id) {
        return this.departmentService.getById(id).get();
    }
}
