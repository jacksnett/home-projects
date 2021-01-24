package jackob.basicORM.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_empl")
public class Employee {

    @Id
    @JsonProperty
    @Column(name = "empno")
    private String employeeNumber;

    @JsonProperty
    @Column(name = "firstname")
    private String firstName;

    @JsonProperty
    @Column(name = "lastname")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "deptno")
    @JsonProperty
    @JsonIgnoreProperties("employees")
    private Department departmentNumber;

    @JsonProperty
    @Column(name = "hiredate")
    private Date hireDate;

    @JsonProperty
    @Column(name = "job")
    private String job;

    @JsonProperty
    @Column(name = "edlevel")
    private int educationLevel;

    @JsonProperty
    @Column(name = "sex")
    private String sex;

    @JsonProperty
    @Column(name = "birthdate")
    private Date birthDate;

    @JsonProperty
    @Column(name = "salary")
    private int salary;

    @JsonProperty
    @Column(name = "bonus")
    private int bonus;

    @JsonProperty
    @Column(name = "comm")
    private int commission;
}
