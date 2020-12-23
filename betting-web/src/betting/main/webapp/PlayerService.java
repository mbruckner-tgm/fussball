package betting.main.webapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import betting.main.data.PlayerDTO;
import betting.main.mapper.MapperClass;
import db.service.PlayersRepository;

@Component("playerService")
public class PlayerService {

	@Autowired
	PlayersRepository playersRepository;

	public List<PlayerDTO> getListOfPlayers() {
		List<PlayerDTO> listOfPlayerDTOs = new ArrayList<>();
		new MapperClass().mappePlayersToListOfPlayerDTOs(playersRepository.selectAllPlayers(), listOfPlayerDTOs);
		return listOfPlayerDTOs;
	}

}
