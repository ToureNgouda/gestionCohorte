package sn.edacy.web;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import sn.edacy.business.CohortServiceL;
import sn.edacy.business.TalentServiceL;
import sn.edacy.model.Cohort;
import sn.edacy.model.Talent;
import utils.SearchTalent;

@Model
public class TalentBM {
	@EJB
	private TalentServiceL talentServiceL;
	@EJB 
	private CohortServiceL cohortServiceL;  //INJECTION DES DEPENDENCES.
	private Cohort cohort = new Cohort();
	private List<Talent> listTalents=new ArrayList<Talent>();
	private Talent talent= new Talent();
	private List<Cohort> listCohorts =new ArrayList<Cohort>();
	private SearchTalent searchTalent = new SearchTalent();
	

	@PostConstruct
	public void init() {
		listTalents= talentServiceL.getTalents();
		listCohorts=cohortServiceL.getAllCohort();
	}
	
	
	public List<Talent> getListTalents() {
		return listTalents;
	}

	public void setListTalents(List<Talent> listTalents) {
		this.listTalents = listTalents;
	}

	public Cohort getCohort() {
		return cohort;
	}
	
	public void setCohort(Cohort cohort) {
		this.cohort = cohort;
	}
	
	public Talent getTalent() {
		return talent;
	}
	public void setTalent(Talent talent) {
		this.talent = talent;
	}
	public List<Cohort> getListCohorts() {
		return listCohorts;
	}
	public void setListCohorts(List<Cohort> listCohorts) {
		this.listCohorts = listCohorts;
	}
	
	public void setCohortBM(Cohort cohort) {
		this.cohort = cohort;
	}
	public SearchTalent getSearchTalent() {
		return searchTalent;
	}

	public void setSearchTalent(SearchTalent searchTalent) {
		this.searchTalent = searchTalent;
	}

	
	public void addTalent() {
		talent.setCohort(cohort);
		talent.setAge(talent.getAge());
		talent.setFullName(talent.getFullName());
		
		talentServiceL.addTalent(talent);
		
		talent.setCohort(null);
		talent.setAge(0);
		talent.setFullName(null);
	}
	
	public Talent getTalent(Long idTalent) {
		return talentServiceL.getTalent(idTalent);
	}
	public void updateTalent(Talent t) {
		talentServiceL.updateTalent(t);
	}
	public void DeleteTalent(Long idTalent) {
		talentServiceL.DeleteTalent(idTalent);
	}
	
	/*
	 * methode pour faire une recherche dans la liste des talents
	 * on fera une recherche sur l'id du cohort
	 * la methode retourne la liste des talents dans une cohort 
	 */
     public void searchTalents() {
    	 listTalents = talentServiceL.searchTalents(searchTalent);
     }

}
