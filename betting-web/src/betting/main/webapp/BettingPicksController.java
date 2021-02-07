package betting.main.webapp;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController("wetten")
public class BettingPicksController {

	private static final Logger LOGGER = Logger.getLogger(BettingPicksController.class.getName());

	@Autowired
	private BettingPicksService bettingPicksService;

	@RequestMapping(value = "/wetten/wettenDetail", method = RequestMethod.GET)
	public ModelAndView wetten(@RequestParam(required = false) String bettingPickCollectionId,
			@RequestParam(required = false) String bettingPickId) {
		
		return new ModelAndView("wetten");
	}


}
