package db.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import db.entity.Player;
import db.entity.Team;


@Stateless
public class TeamsRepository {

	@PersistenceContext(unitName = "betting-db")
	private EntityManager entityManager;

	public List<Team> selectAllTeams() {
		return entityManager.createNamedQuery("findAll", Team.class).getResultList();
	}
	
	
	public void insertNewTeam(Team newTeam) {
		entityManager.persist(newTeam);
	}
	

}
