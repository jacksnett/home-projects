package jackob.basicORM.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="t_proj")
public class Project {

    @Id
    @Column(name = "projno")
    @JsonProperty
    private String projNo;

    @Column(name = "projname")
    @JsonProperty
    private String projName;

    @Column(name = "deptno")
    @JsonProperty
    private String deptNo;

    @OneToOne
    @JoinColumn(name = "respemp")
    @JsonProperty
    private Employee respEmp;

    @Column(name = "prstaff")
    @JsonProperty
    private int prStaff;

    @Column(name = "prstdate")
    @JsonProperty
    private Date prStartDate;

    @Column(name = "prendate")
    @JsonProperty
    private Date prEndDate;

    @Column(name = "majproj")
    @JsonProperty
    private String majorProject;

    public Employee getRespEmp() {
        return this.respEmp;
    }
}
