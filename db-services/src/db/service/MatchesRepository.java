package db.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import db.dtos.MatchesSuchparameter;
import db.entity.Match;


@Transactional
@Repository("MatchesRepository")
public class MatchesRepository {

	
	@PersistenceContext
	private EntityManager entityManager;


	@SuppressWarnings("unchecked")
	public List<Match> findeMatchesZuSuchparametern(MatchesSuchparameter suchparameter){
		if(suchparameter.getGesuchterSpieltag().isPresent()) {
			entityManager.createNamedQuery("Matches.findAllMatchesToMatchday").setParameter("matchDay", suchparameter.getGesuchterSpieltag().get()).getResultList();
		}
		if(suchparameter.getGesuchtesTeam().isPresent()) {
			entityManager.createNamedQuery("Matches.findAllMatchesToTeamId").setParameter("team", suchparameter.getGesuchtesTeam().get()).getResultList();
		}
		if(suchparameter.getGesuchtesTurnier().isPresent()) {
			entityManager.createNamedQuery("Matches.findAllMatchesToTurnier").setParameter("turnier", suchparameter.getGesuchtesTurnier().get()).getResultList();
		}
		if(suchparameter.getGesuchterSpieltag().isPresent() && suchparameter.getGesuchtesTeam().isPresent()){
			entityManager.createNamedQuery("Matches.findAllMatchesToMatchDayAndTeam").setParameter("matchDay", suchparameter.getGesuchterSpieltag().get()).setParameter("team", suchparameter.getGesuchtesTeam().get()).getResultList();
		}
		if(suchparameter.getGesuchterSpieltag().isPresent() && suchparameter.getGesuchtesTurnier().isPresent()){
			entityManager.createNamedQuery("Matches.findAllMatchesToMatchDayAndTournament").setParameter("matchDay", suchparameter.getGesuchterSpieltag().get()).setParameter("turnier", suchparameter.getGesuchtesTurnier().get()).getResultList();
		}
		if(suchparameter.getGesuchtesTurnier().isPresent() && suchparameter.getGesuchtesTeam().isPresent()){
			entityManager.createNamedQuery("Matches.findAllMatchesToTournamentAndTeam").setParameter("turnier", suchparameter.getGesuchtesTurnier().get()).setParameter("team", suchparameter.getGesuchtesTeam().get()).getResultList();
		}
		return entityManager.createNamedQuery("Matches.findAll").getResultList();
	}
	
	
	public void insertMatch(Match matchDB) {
		entityManager.persist(matchDB);
	}

}
