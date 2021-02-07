package betting.main.webapp;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import betting.main.data.MatchDTO;

@RestController("matches")
public class MatchController {

	@Autowired
	private MatchesService matchesService;

	@RequestMapping(value = "/matches", method = RequestMethod.GET)
	public ModelAndView matches(@RequestParam(required = false) String matchDaySuche,
			@RequestParam(required = false) String teamSuche, @RequestParam(required = false) String turnierSuche,
			@RequestParam(required = false) String stichtagSuche) {
		ModelAndView model = new ModelAndView("matches");
		Map<Date, Map<String, List<MatchDTO>>> spieltage = new TreeMap<>();
		if (matchDaySuche != null || teamSuche != null || turnierSuche != null || stichtagSuche != null) {
			try {
				spieltage = matchesService.getMatches(matchDaySuche, teamSuche, turnierSuche, stichtagSuche);
				model.addObject("spieltage", spieltage);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		model.addObject("spieltage", spieltage);
		return new ModelAndView("matches");
	}

	@RequestMapping(value = "/matches/matchDetail", method = RequestMethod.GET)
	public ModelAndView matchDetail() {
		ModelAndView model = new ModelAndView("matchDetail");
		model.addObject("newMatchDTO", new MatchDTO());
		return model;
	}

}
