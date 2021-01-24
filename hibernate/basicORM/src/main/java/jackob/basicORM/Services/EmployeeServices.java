package jackob.basicORM.Services;

import jackob.basicORM.Models.Employee;
import jackob.basicORM.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServices {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findByDepartmentNumber(String departmentName) {
        return this.employeeRepository.findByDepartmentNumber_departmentName(departmentName);
    }
}
