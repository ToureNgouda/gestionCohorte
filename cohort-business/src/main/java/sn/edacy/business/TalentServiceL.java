package sn.edacy.business;

import java.util.List;

import javax.ejb.Local;

import sn.edacy.model.Talent;
import utils.SearchTalent;

@Local
public interface TalentServiceL {
	public void addTalent(Talent t);
	public Talent getTalent(Long idTalent);
	public void updateTalent(Talent t);
	public void DeleteTalent(Long idTalent);
	public List<Talent> getTalents(); //recupere la liste des talents dans une cohorte
    public List<Talent> searchTalents(SearchTalent searchTalent);
}
