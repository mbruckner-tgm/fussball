package betting.main.webapp;

import java.util.List;

import javax.ejb.EJB;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import betting.main.data.PlayerDTO;

@Controller
public class PlayerController {

	@EJB
	PlayerService playerService;
	
	@GetMapping("/players")
	public List<PlayerDTO> getAllPlayers() {
		return playerService.getListOfPlayers();
	}

}

