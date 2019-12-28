package db.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import db.entity.Player;
import db.entity.Team;
import db.entity.Tournament;


@Stateless
public class TournamentsRepository {

	@PersistenceContext(unitName = "betting-db")
	private EntityManager entityManager;

	public List<Tournament> selectAllTournaments() {
		return entityManager.createNamedQuery("findAll", Tournament.class).getResultList();
	}
	
	public void insertNewTournament(Tournament newTournament) {
		entityManager.persist(newTournament);
	}

}
