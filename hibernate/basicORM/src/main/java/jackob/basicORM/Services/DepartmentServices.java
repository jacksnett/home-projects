package jackob.basicORM.Services;

import jackob.basicORM.Models.Department;
import jackob.basicORM.Models.Employee;
import jackob.basicORM.Repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServices {

    @Autowired
    DepartmentRepository departmentRepository;

    public List<Department> getAll () {
        return this.departmentRepository.findAll();
    }

    public List<Employee> getEmployees(String departmentNumber) {
    return this.departmentRepository.findById(departmentNumber).get().employees();
    }
}
