package betting.service;

import java.util.List;

public interface BettingService {

	public void createNewPlayer(Player player);
	
	public List<Player> getAllPlayer();
	
}
