package betting.main.mapper;

import java.util.List;

import betting.main.data.PlayerDTO;
import db.entity.Player;

public class MapperClass {

	public void mappePlayersToListOfPlayerDTOs(List<Player> players, List<PlayerDTO> listOfPlayerDTOs) {
		players.forEach(player -> listOfPlayerDTOs.add(createPlayerDTOFromPlayer(player)));
	}

	private PlayerDTO createPlayerDTOFromPlayer(Player player) {
		PlayerDTO playerDTO = new PlayerDTO();
		playerDTO.setPlayerId(player.getPlayerId());
		playerDTO.setPlayerName(player.getPlayerName());
		
		return playerDTO;
	}

	
}
