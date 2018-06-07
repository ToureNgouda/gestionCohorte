package sn.edacy.business;

import java.util.List;

import javax.ejb.Remote;

import sn.edacy.model.Cohort;
@Remote
public interface CohortServiceR {
	public void addCohort(Cohort c);
	public  List<Cohort> getAllCohort();

}
