package db.service;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import db.entity.BettingPick;

@Transactional
@Repository("BettingRepository")
public class BettingRepository {

	public BettingPick getBettingPickByCollectionAndId(String bettingPickCollectionId, String bettingPickId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void createBettingPick(BettingPick bettingPickDB) {
		// TODO Auto-generated method stub
		
	}
	
	public List<BettingPick> getBettingPicksByCollectionId(String bettingPickCollectionId){
		return null;
	}

}
