package db.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import db.entity.BettingPick;


@Stateless
@LocalBean
public class BettingPicksRepository {

	@PersistenceContext(unitName = "betting-db")
	private EntityManager entityManager;

	public List<BettingPick> selectAllBettingPicks() {
		return entityManager.createNamedQuery("findAll", BettingPick.class).getResultList();
	}
	
	public void insertNewBettingPick(BettingPick newBettingPick) {
		entityManager.persist(newBettingPick);
	}

}
