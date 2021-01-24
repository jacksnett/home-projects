package jackobs.NoBugs.Services;

import jackobs.NoBugs.Modules.Employee;
import jackobs.NoBugs.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAll() {
        return this.employeeRepository.findAll();
    }

    public Optional<Employee> getById(String id) {
        return this.employeeRepository.findById(id);
    }

    public  void deleteById(String employeeId) {
        this.employeeRepository.deleteById(employeeId);
    }

    public void add(Employee employee) {
        this.employeeRepository.save(employee);
    }

    public void update(Employee employee) {
        Employee oldEmployee = this.employeeRepository.findById(employee.getEmpno()).get();
        this.employeeRepository.delete(oldEmployee);
        this.employeeRepository.save(employee);
    }
}
