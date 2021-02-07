package betting.main.webapp;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import betting.main.data.MatchDTO;
import db.entity.Match;
import db.entity.MatchPK;
import db.service.MatchesRepository;

@RunWith(MockitoJUnitRunner.class)
public class MatchesServicesTest {
	
	@InjectMocks
	MatchesService matchesService;
	
	@Mock
	MatchesRepository matchesRepo;

	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	private Map<Date, Map<String,List<MatchDTO>>> spielTage;
	private List<Match> alleSpiele;
	
	@Before
	public void startUp() {
		alleSpiele = new ArrayList<>();
		spielTage = new TreeMap<>();
		befuelleListeMitFuenfMatches();
	}

	/**
	 * Die Map wird nicht richtig befüllt .. debuggen ist notwendig
	 * */
	
	
	@Test
	public void testeBefuelleMapMitSpielDaten() {
		matchesService.befuelleMapMitSpielDaten(spielTage, alleSpiele);
		assertFalse(spielTage.isEmpty());
		assertTrue(spielTage.size() == 2);
		
		for(Entry<Date, Map<String,List<MatchDTO>>> spieltag : spielTage.entrySet()) {
			System.out.println("Spieltag: " + dateFormat.format(spieltag.getKey()));
			for(Entry<String,List<MatchDTO>> turnier : spieltag.getValue().entrySet()) {
				System.out.println("Turnier: " + turnier.getKey());
				turnier.getValue().forEach(spiel -> System.out.println("Spiel: " + spiel));
			}
		}
	}

	private void befuelleListeMitFuenfMatches() {
		alleSpiele.add(createMatch("2021-01-07", "EM21", "AUT","GER"));
		alleSpiele.add(createMatch("2021-01-07", "WM21", "FRA","ITA"));
		alleSpiele.add(createMatch("2021-01-08", "EM21", "FIN","ENG"));
		alleSpiele.add(createMatch("2021-01-08", "EM21", "EST","GIB"));
		alleSpiele.add(createMatch("2021-01-08", "WM21", "ISL","LIE"));
		
	}

	private Match createMatch(String datum, String turnier, String home, String opponent) {
		Match match = new Match();
		match.setId(createPK(datum,home,opponent));
		match.setTournamentId(turnier);
		match.setAnlageUser("dbadmin1");
		match.setUpdateUser("dbadmin1");
		match.setAnlageZeitpunkt(new Timestamp(System.currentTimeMillis()));
		match.setUpdateZeitpunkt(new Timestamp(System.currentTimeMillis()));
		match.setHomeTeamGoals(new Integer(0));
		match.setOpponentTeamGoals(new Integer(0));
		match.setMatchresult("");
		match.setKickoff("12:00");
		return match;
	}
	
	private MatchPK createPK(String datum, String home, String opponent) {
		MatchPK pk = new MatchPK();
		pk.setHomeTeamId(home);
		pk.setOpponentTeamId(opponent);
		try {
			pk.setMatchDay(dateFormat.parse(datum));
		} catch (ParseException e) {
			System.out.println("Datumsformat stimmt nicht!! " + datum);
		}
		return pk;
	}

}
