package sn.edacy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="talents")
public class Talent {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="id")
	private long id;
	@Column(name="full_Name")
	private String fullName;
	@Column(name="age")
	private int age;
	@ManyToOne
	@JoinColumn(name="cohort_id")
	private Cohort cohort;
	
	
	public Talent() {
		super();
	}

	public Talent(String fullName, int age) {
		super();
		this.fullName = fullName;
		this.age = age;
	}

	public Talent(String fullName, int age, Cohort cohort) {
		super();
		this.fullName = fullName;
		this.age = age;
		this.cohort = cohort;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Cohort getCohort() {
		return cohort;
	}

	public void setCohort(Cohort cohort) {
		this.cohort = cohort;
	}

	

	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
