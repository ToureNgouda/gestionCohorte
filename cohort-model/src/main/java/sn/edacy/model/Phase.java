package sn.edacy.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="phases")
public class Phase {
	 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Phase(Date dateD, Date dateF, Cohort cohortPhase) {
		super();
		this.dateD = dateD;
		this.dateF = dateF;
		this.cohortPhase = cohortPhase;
	}

	public Date getDateD() {
		return dateD;
	}

	public void setDateD(Date dateD) {
		this.dateD = dateD;
	}

	public Date getDateF() {
		return dateF;
	}

	public void setDateF(Date dateF) {
		this.dateF = dateF;
	}

	public Cohort getCohortPhase() {
		return cohortPhase;
	}

	public void setCohortPhase(Cohort cohortPhase) {
		this.cohortPhase = cohortPhase;
	}

	
	public Phase() {
		super();
	}

	public Phase(String name, Date dateD, Date dateF, Cohort cohortPhase) {
		super();
		this.name = name;
		this.dateD = dateD;
		this.dateF = dateF;
		this.cohortPhase = cohortPhase;
	}

	@Id
	@Column(name="id_phase")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name="name_phase")
	private String name;
	@Column(name="date_debut")
	private Date dateD;
	@Column(name="date_fin")
	private Date dateF;
	@OneToOne
	@JoinColumn(name="id_cohort")
	private Cohort cohortPhase;


}
