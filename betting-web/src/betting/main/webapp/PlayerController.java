package betting.main.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import betting.main.data.PlayerDTO;

@Controller
public class PlayerController {

	@Autowired
	PlayerService playerService;

	@RequestMapping(value = "/players", method = RequestMethod.GET)
	@ResponseBody
	public String getAllPlayers() {
		StringBuilder builder = new StringBuilder("Wettspieler:\n\t");

		for (PlayerDTO player : playerService.getListOfPlayers()) {
			builder.append("\n\t");
			builder.append("PlayerId: " + player.getPlayerId() + " - PlayerName: " + player.getPlayerName() + "\n\t");
		}

		return builder.toString();
	}

}
