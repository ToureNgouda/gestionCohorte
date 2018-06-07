package sn.edacy.business;


import java.util.List;

import javax.ejb.Local;

import sn.edacy.model.Cohort;
import sn.edacy.model.Phase;
@Local
public interface CohortServiceL {
	public void addCohort(Cohort c);
	public  List<Cohort> getAllCohort();
    public void addPhase(Phase phase);
    public Phase getPhase(Long  idPhase);
    public Cohort getCohort(Long  idCohort);
    public void deletePhase(Long id);
    public void deleteCohort(Long idCohort);
    public void updatePhase(Phase phase);
    public void updateCohort(Cohort cohort);

}
