package db.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import db.entity.Tournament;

@Stateless
@LocalBean
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
