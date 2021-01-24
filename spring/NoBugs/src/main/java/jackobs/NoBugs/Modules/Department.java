package jackobs.NoBugs.Modules;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name="t_depart")
public class Department {
	@Id
	@Column(name="DEPTNO")
	@JsonProperty
	public String id;
	
	@Column(name="DEPTNAME")
	@JsonProperty
	public String name;
	
	@Column(name="MGRNO")
	@JsonProperty
	public String managerNumber;
	
	@Column(name="ADMRDEPT")
	@JsonProperty
	public String administrativeDept;
}
