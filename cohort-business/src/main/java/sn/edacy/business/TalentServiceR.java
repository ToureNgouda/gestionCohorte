package sn.edacy.business;

import java.util.List;

import javax.ejb.Remote;

import sn.edacy.model.Talent;
import utils.SearchTalent;
@Remote
public interface TalentServiceR {
	public void addTalent(Talent t);
	public Talent getTalent(Long idTalent);
	public void updateTalent(Talent t);
	public void DeleteTalent(Long idTalent);
	public List<Talent> searchTalents(SearchTalent searchTalent);
}
