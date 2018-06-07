package sn.edacy.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import sn.edacy.model.Cohort;
import sn.edacy.model.Phase;

 
@Stateless(name="CohortS")   //ejb session CohortS  nom publie dans le jndi
public class CohortServiceImpl implements CohortServiceL, CohortServiceR{
     @PersistenceContext(unitName="UP_COHORT")
	private EntityManager em;
	
	public void addCohort(Cohort c) {
		//if(c.getNom()==null) throw new RuntimeException("veillez entrer tous les champs svp");
		em.persist(c);
		
	}

	public List<Cohort> getAllCohort() {
		Query query=em.createQuery("select c from Cohort c ");  
		return query.getResultList();
	}

	public void addPhase(Phase phase) {
		em.persist(phase); //permet d'enregistrer une phase dans la base de donnee
		
	}

	public Phase getPhase(Long idPhase) {
		Phase phase =em.find(Phase.class, idPhase);
		return phase;
	}
	
	public Cohort getCohort(Long idCohort) {
		Cohort cohort =em.find(Cohort.class, idCohort);
		return cohort;
	}

	public void deletePhase(Long id) {
		Phase phase=getPhase(id);
	     em.remove(phase);
		
	}
     
	public void deleteCohort(Long idCohort) {
		
	     em.remove(em.find(Cohort.class, idCohort));
		
	}

	
	public void updatePhase(Phase phase) {
		em.merge(phase);
		
	}
	public void updateCohort(Cohort cohort) {
		em.merge(cohort);
		
	}

}
