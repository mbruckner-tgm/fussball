package db.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import db.entity.Player;

@Repository("playersRepository")
public class PlayersRepository {

	@Qualifier(value = "entityManager")
	private EntityManager entityManager;

	public List<Player> selectAllPlayers() {
		return entityManager.createNamedQuery("findAll", Player.class).getResultList();
	}

	public void insertNewPlayer(Player newPlayer) {
		entityManager.persist(newPlayer);
	}

}
