package db.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import db.entity.Player;

@Stateless
public class PlayersRepository {

	@PersistenceContext(unitName = "betting-db")
	private EntityManager entityManager;

	public List<Player> selectAllPlayers() {
		return entityManager.createNamedQuery("findAll", Player.class).getResultList();
	}

	public void insertNewPlayer(Player newPlayer) {
		entityManager.persist(newPlayer);
	}
	
}
