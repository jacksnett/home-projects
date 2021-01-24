package jackob.basicORM.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_depart")
public class Department {

    @Id
    @JsonProperty
    @Column(name = "deptno")
    private String departmentNumber;

    @JsonProperty
    @Column(name = "deptname")
    private String departmentName;

    @JsonProperty
    @Column(name = "mgrno")
    private String managerNumber;

    @JsonProperty
    @Column(name = "admrdept")
    private String adminDepartment;

    @OneToMany(targetEntity = Employee.class, mappedBy = "departmentNumber")
    public List<Employee> employees = new ArrayList<Employee>();

    public List<Employee> employees() {
        return this.employees;
    }
}
