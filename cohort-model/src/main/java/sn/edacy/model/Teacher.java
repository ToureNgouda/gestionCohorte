package sn.edacy.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="teachers")
public class Teacher {
	public Teacher(String firstName, String lastName, String adresse) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.adresse = adresse;
	}
	public Teacher() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public String getAdresse() {
		return adresse;
	}
	public Teacher(String firstName, String lastName, String adresse, int numTel, List<Course> courses) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.adresse = adresse;
		this.numTel = numTel;
		this.courses = courses;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_teacher")
	private Long id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="adresse_teacher")
	private String adresse;
	@Column(name="numeroTel_Teacher")
	private int numTel;
	@OneToMany(mappedBy="teacher")
	@XmlTransient //masquer la liste des coures quand je consutle un prof
	private List<Course> courses;
	
	public int getNumTel() {
		return numTel;
	}
	public void setNumTel(int numTel) {
		this.numTel = numTel;
	}
	
}
