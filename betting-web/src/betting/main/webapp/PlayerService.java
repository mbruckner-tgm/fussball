package betting.main.webapp;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import betting.main.data.PlayerDTO;
import betting.main.mapper.MapperClass;
import db.service.PlayersRepository;


@Stateless
@LocalBean
public class PlayerService {

	@EJB
	PlayersRepository playersRepository;
	
	public List<PlayerDTO> getListOfPlayers(){
		List<PlayerDTO> listOfPlayerDTOs = new ArrayList<>();
		new MapperClass().mappePlayersToListOfPlayerDTOs(playersRepository.selectAllPlayers(),listOfPlayerDTOs);
		return listOfPlayerDTOs;
	}
	
}
