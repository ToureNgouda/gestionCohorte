package sn.edacy.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name="cohorts")
public class Cohort {
    
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="id")
	private long id;
	@Column(name="name_cohort")
	private  String nom;
	@OneToMany(mappedBy ="cohort")
	private List<Talent> talents;
	@OneToOne(mappedBy="cohortPhase")
	private Phase phase;

	public String getNom() {
		return nom;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
    @XmlTransient
	public Phase getPhase() {
		return phase;
	}

	public void setPhase(Phase phase) {
		this.phase = phase;
	}

	public Cohort(String nom) {
		super();
		this.nom = nom;
	}
	public Cohort() {
		super();
		
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
    @XmlTransient //masquer la liste des talents quand je consulte un cohort
	public List<Talent> getTalents() {
		return talents;
	}

	public void setTalents(List<Talent> talents) {
		this.talents = talents;
	}
	 

}

