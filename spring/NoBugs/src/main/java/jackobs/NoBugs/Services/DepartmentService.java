package jackobs.NoBugs.Services;

import jackobs.NoBugs.Modules.Department;
import jackobs.NoBugs.Repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Optional<Department> getById(String id) {
        return departmentRepository.findById(id);
    }

    public List<Department> getAll() {return  departmentRepository.findAll(); }
}
