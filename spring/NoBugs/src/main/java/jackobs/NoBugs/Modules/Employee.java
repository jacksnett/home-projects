package jackobs.NoBugs.Modules;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_empl")
public class Employee {
	@Id
	@Column(name="EMPNO")
    private String empno;
	
	@Column(name="FIRSTNAME")
	@JsonProperty
	private String firstname;
	
	@Column(name="LASTNAME")
	@JsonProperty
	private String lastname;
	
	@Column(name="DEPTNO")
	@JsonProperty
	private String deptno;
	
	@Column(name="HIREDATE")
	@JsonProperty
	private Date hiredate;
	
	@Column(name="JOB")
	@JsonProperty
	private String job;
	
	@Column(name="EDLEVEL")
	@JsonProperty
	private int edLevel;
	
	@Column(name="SEX")
	@JsonProperty
	private String sex;
	
	@Column(name="birthdate")
	@JsonProperty
	private Date birthdate;
	
	@Column(name="SALARY")
	@JsonProperty
	private int salary;
	
	@Column(name="BONUS")
	@JsonProperty
	private int bonus;

	@Column(name="COMM")
	@JsonProperty
	private int comm;

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDeptno() {
		return deptno;
	}

	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getEdlevel() {
		return edLevel;
	}

	public void setEdlevel(int edlevel) {
		this.edLevel = edlevel;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}
}
