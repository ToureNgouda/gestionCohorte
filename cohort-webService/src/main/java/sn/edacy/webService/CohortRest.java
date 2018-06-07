package sn.edacy.webService;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import sn.edacy.business.CohortServiceL;
import sn.edacy.business.TalentServiceL;
import sn.edacy.model.Cohort;
 
@Path("/") 
public class CohortRest {
	
	@Inject
	private CohortServiceL cohortServicel;
	@Inject
	private TalentServiceL talentServiceL;

	@POST
	@Path(value="cohorts")
	//@Produces(MediaType.APPLICATION_JSON)
	public String addCohort(@FormParam(value="nomCohort") String nom) {
		Cohort c = new Cohort();
		c.setNom(nom);
		cohortServicel.addCohort(c);
		return "message: Cohort created";
	}
	@GET
	@Path(value="cohorts")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cohort> getAllCohort() {
		return cohortServicel.getAllCohort();
	}
	@GET
	@Path(value="cohorts/{idCohort}")
	@Produces(MediaType.APPLICATION_JSON)
	public Cohort getCohort(@PathParam(value="idCohort") Long idCohort) {
		return cohortServicel.getCohort(idCohort);
	}
	@DELETE
	@Path(value="cohorts")
  // @Produces(MediaType.APPLICATION_JSON)
	public String deleteCohort(@FormParam(value="idCohort") Long idCohort) {
		cohortServicel.deleteCohort(idCohort);
		return "message: Cohort deleted";
	}
  
	@PUT
	@Path(value="cohorts")
	//@Produces(MediaType.APPLICATION_JSON)
	public String updateCohort( 
		@FormParam(value="idCohort")  Long id,
		@FormParam(value="nomCohort") String nom) {
		
		Cohort cohort = new Cohort();
		cohort.setId(id);
		cohort.setNom(nom);
		cohortServicel.updateCohort(cohort);
		return "message: Cohort updated";  
	}
	
}
