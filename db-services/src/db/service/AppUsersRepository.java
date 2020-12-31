package db.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import db.entity.Player;

@Repository("playersRepository")
public class PlayersRepository {

	@PersistenceContext
	EntityManager entityManager;

	public List<Player> selectAllPlayers() {
		Query query = entityManager.createNamedQuery("Player.findAll");
		return query.getResultList();
	}

	public void insertNewPlayer(Player newPlayer) {
		entityManager.persist(newPlayer);
	}

}
