package sn.edacy.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.commons.lang3.math.NumberUtils;
import sn.edacy.model.Talent;
import utils.SearchTalent;

/*
 * ejb session accessible en local 
 * et a distance le nom publie dans le jndi est TalentS
 */
@Stateless(name="TalentS")   
public class TalentServiceImpl implements TalentServiceL, TalentServiceR {
	@PersistenceContext(unitName="UP_COHORT")  
	private EntityManager em; 

	public void addTalent(Talent t) {
		//if(t.getAge()!=0 & t.getFullName()!=null) {
		em.persist(t);    //permet d'enregistrer un talent dans la base de donnee
		 //throw new RuntimeException("veillez entrer tous les champs svp");
	}

	public Talent getTalent(Long idTalent) {
		Talent t=em.find(Talent.class, idTalent); //permet de charger un talent a partir de la base de donne en sachant sa clePIMAIRE
		if(t==null) throw new RuntimeException("Ce Talent n'existe pas");
		return t;
	}

	public void updateTalent(Talent t) {
		em.merge(t);  //mettre a jour un talent dans la base de donnee
		
	}

	public void DeleteTalent(Long idTalent) {
		em.remove(em.find(Talent.class, idTalent));    //supprime un talent dans la base 
		
	}
    //recupere la liste des talents 
	public List<Talent> getTalents() {
		Query query =  em.createQuery("select t from Talent t ");
		return query.getResultList();
	}
    /*
     * retourne la liste des talents dans une cohorte 
     * @param searchTalent "id du cohort"
     * 
     * */
	public List<Talent> searchTalents(SearchTalent searchTalent) {
		 Long idC = NumberUtils.toLong(searchTalent.getIdentifTalent());
		 Query query = em.createQuery("select t from Talent t where t.cohort.id= :ident");
		 query.setParameter("ident", idC);
		return query.getResultList();
	}

}
