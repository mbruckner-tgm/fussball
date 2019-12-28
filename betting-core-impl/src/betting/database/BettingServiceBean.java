package betting.database;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import betting.data.mapper.BettingDataMapperBean;
import betting.service.BettingService;
import betting.service.Player;
import db.service.PlayersRepository;

@Stateless
public class BettingServiceBean implements BettingService {

	@EJB
	private PlayersRepository playersRepository;
	
	@EJB
	private BettingDataMapperBean bettingDataMapperBean;
	
	@Override
	public void createNewPlayer(Player player) {
		playersRepository.insertNewPlayer(bettingDataMapperBean.createPlayerFromPlayerDTO(player));
	}

	@Override
	public List<Player> getAllPlayer() {
		return bettingDataMapperBean.getAllPlayerAsPlayerDTOList(playersRepository.selectAllPlayers());
	}

	
	
}
