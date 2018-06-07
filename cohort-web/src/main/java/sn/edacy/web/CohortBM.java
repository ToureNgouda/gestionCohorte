package sn.edacy.web;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import sn.edacy.business.CohortServiceL;
import sn.edacy.model.Cohort;

@Model
public class CohortBM {
	 @Inject   //injection des dependences 
     private CohortServiceL cohortServiceL;
	 private Cohort cohort = new Cohort();
     //private List<Cohort> listCohorts = new ArrayList<Cohort>();
     
//    @PostConstruct
// 	public void init() {
// 			listCohorts = cohortServiceL.getAllCohort();
// 	} 
 	 	
	 public void addCohort() {
		cohortServiceL.addCohort(cohort);
		cohort.setNom(null);
	}
	 public List<Cohort> getAllCohort() {
			return cohortServiceL.getAllCohort();
		}

	public Cohort getCohort() {
		return cohort;
	}

	public void setCohort(Cohort cohort) {
		this.cohort = cohort;
	} 
//    public List<Cohort> getListCohorts() {
//		return listCohorts;
//	}
//
//	public void setListCohorts(List<Cohort> listCohorts) {
//		this.listCohorts = listCohorts;
//	}

	
	 
}
