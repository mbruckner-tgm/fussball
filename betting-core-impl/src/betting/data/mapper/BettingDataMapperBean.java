package betting.data.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import betting.data.PlayerDTO;
import db.entity.Player;

@LocalBean
@Stateless
public class BettingDataMapperBean {

	public Player createPlayerFromPlayerDTO(betting.service.Player playerDTO) {
		Player newPlayer = new Player();
		
		newPlayer.setPlayerId(UUID.randomUUID().toString());
		newPlayer.setPlayerName(playerDTO.getPlayerName());
		
		return newPlayer;
	}
	
	public List<betting.service.Player> getAllPlayerAsPlayerDTOList(List<Player> playerList) {
		List<betting.service.Player> listOfPlayerDTO = new ArrayList<>();
		playerList.forEach(entry -> listOfPlayerDTO.add(createPlayerDTOFromPlayer(entry)));
		
		return listOfPlayerDTO;
	}

	private betting.service.Player createPlayerDTOFromPlayer(Player player) {
		betting.service.Player playerDTO = new PlayerDTO();
		
		playerDTO.setPlayerId(player.getPlayerId());
		playerDTO.setPlayerName(player.getPlayerName());
		
		return playerDTO;
	}
	
	
}
