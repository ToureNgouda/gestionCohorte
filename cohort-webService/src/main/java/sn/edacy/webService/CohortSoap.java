package sn.edacy.webService;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService; 

import sn.edacy.business.CohortServiceL; 
import sn.edacy.business.TalentServiceL;
import sn.edacy.model.Cohort;
import sn.edacy.model.Talent;
@Stateless
@WebService
public class CohortSoap {
	@EJB
	private CohortServiceL cohortServiceL;
	@EJB
	private TalentServiceL talentServiceL;
	
	@WebMethod
	public String addTalent(
			@WebParam(name="nom-prenom") String fullName,
			@WebParam(name="age-talent") int age,
			@WebParam(name="cohort") Cohort cohort){
		Talent t = new Talent(fullName, age, cohort);
		talentServiceL.addTalent(t);
		return "Message: Talent Created";
	}
	@WebMethod
	public Talent getTalent(@WebParam(name="idTalent") Long idTalent) {
		return talentServiceL.getTalent(idTalent);
	}
	@WebMethod
	public String updateTalent( Talent t) {
		talentServiceL.updateTalent(t);
		return "Message: Talent Updated";
	}
	@WebMethod
	public String DeleteTalent(@WebParam(name="idTalent") Long idTalent) {
		talentServiceL.DeleteTalent(idTalent);
		return "Message: Talent deleted";
	}
	@WebMethod
    public Cohort getCohort(@WebParam(name="idCohort") Long idCohort) {
		return cohortServiceL.getCohort(idCohort);
	}
	@WebMethod
	public String deleteCohort(@WebParam(name="idCohort") Long idCohort) {
		cohortServiceL.deleteCohort(idCohort);
		return "Message: cohort deleted";
	}
	@WebMethod
	public String updateCohort(Cohort cohort) {
		cohortServiceL.updateCohort(cohort);
		return "message: cohort updated";
	}
	@WebMethod
	public String addCohort(@WebParam(name="nomCohort") String nom) {
		Cohort c = new Cohort(nom);
		cohortServiceL.addCohort(c);
		return "message: cohort created";
	}
    @WebMethod
	public List<Cohort> getAllCohort() {
		return cohortServiceL.getAllCohort();
	}

}
