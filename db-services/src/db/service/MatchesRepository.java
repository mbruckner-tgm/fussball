package db.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import db.entity.Match;
import db.entity.Player;
import db.entity.Tournament;


@Stateless
public class MatchesRepository {

	@PersistenceContext(unitName = "betting-db")
	private EntityManager entityManager;

	public List<Match> selectAllMatches() {
		return entityManager.createNamedQuery("findAll", Match.class).getResultList();
	}
	
	public void insertNewMatch(Match newMatch) {
		entityManager.persist(newMatch);
	}

}
