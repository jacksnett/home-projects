package LessonExample.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_PEOPLE")
public class Person {

    @Id
    @Column(name="ID")
    @JsonProperty
    private int id;

    @Column(name="FIRSTNAME")
    @JsonProperty
    private String firstname;

    @Column(name="LASTNAME")
    @JsonProperty
    private String lastname;
}
