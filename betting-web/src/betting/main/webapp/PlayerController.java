package betting.main.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import betting.main.data.AppUserDTO;

@Controller
public class PlayerController {

	@Autowired
	AppUsersService playerService;

	@RequestMapping(value = "/players", method = RequestMethod.GET)
	@ResponseBody
	public String getAllPlayers() {
		StringBuilder builder = new StringBuilder("Wettspieler:\n\t");

		for (AppUserDTO appUserDTO : playerService.getListOfAppUsers()) {
			builder.append("\n\t");
			builder.append(
					"PlayerId: " + appUserDTO.getUserId() + " - PlayerName: " + appUserDTO.getUserName() + "\n\t");
		}

		return builder.toString();
	}

}
