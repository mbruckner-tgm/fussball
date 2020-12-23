package betting.main.webapp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import db.entity.BettingPick;
import db.service.BettingPicksRepository;

@Stateless
@LocalBean
public class BettingPickService {

	@EJB
	BettingPicksRepository bettingPicksRepository;
	
	public List<BettingPick> getListOfBettingPicks(){
		return bettingPicksRepository.selectAllBettingPicks();
	}
	
}
