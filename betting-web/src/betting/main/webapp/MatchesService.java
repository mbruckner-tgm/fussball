package betting.main.webapp;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import betting.main.data.MatchDTO;
import db.dtos.MatchesSuchparameter;
import db.entity.Match;
import db.entity.MatchPK;
import db.service.MatchesRepository;

@Component("matchesService")
public class MatchesService {

	@Autowired
	private MatchesRepository matchesRepo;

	/**
	 * Matchdetails suchen und mapppen -> fuer UPDATE und SELECT
	 */
	public MatchDTO getMatch() {
		return null;

	}

	/**
	 * Alle Matches zu einem bestimmten Suchparameter oder alle Matches
	 * @throws ParseException 
	 */
	public Map<Date, Map<String, List<MatchDTO>>> getMatches(String matchDaySuche, String teamSuche,
			String turnierSuche,String stichtagSuche) throws ParseException {
		Map<Date, Map<String, List<MatchDTO>>> spieleZumSpieltag = new TreeMap<>();
		MatchesSuchparameter suchparameter = new MatchesSuchparameter(matchDaySuche,teamSuche, turnierSuche, stichtagSuche);		
		List<Match> alleSpiele = matchesRepo.findeMatchesZuSuchparametern(suchparameter);
		befuelleMapMitSpielDaten(spieleZumSpieltag, alleSpiele);
		return spieleZumSpieltag;
	}

	void befuelleMapMitSpielDaten(Map<Date, Map<String, List<MatchDTO>>> spieleZumSpieltag, List<Match> alleSpiele) {
		for (Match match : alleSpiele) {
			if (spieleZumSpieltag.isEmpty()) {
				neuerSpieltag(spieleZumSpieltag, match);
			} else {
				turnierZuSpieltagHinzufuegen(spieleZumSpieltag, match);
			}
		}
	}

	void turnierZuSpieltagHinzufuegen(Map<Date, Map<String, List<MatchDTO>>> spielTage, Match match) {
		if (spielTage.containsKey(match.getId().getMatchDay()))
			for (Entry<Date, Map<String, List<MatchDTO>>> spieltag : spielTage.entrySet()) {
				if (match.getId().getMatchDay().equals(spieltag.getKey())) {
					spielZuTurnierHinzufuegen(match, spieltag.getValue());
				}
			}
		else {
			neuerSpieltag(spielTage, match);
		}
	}

	void spielZuTurnierHinzufuegen(Match match, Map<String, List<MatchDTO>> turniere) {
		if (turniere.containsKey(match.getTournamentId())) {
			for (Entry<String, List<MatchDTO>> turnier : turniere.entrySet()) {
				if (match.getTournamentId().equalsIgnoreCase(turnier.getKey())) {
					turnier.getValue().add(createMatchDTO(match));
				}
			}
		} else {
			neuesTurnier(turniere, match);
		}
	}

	void neuerSpieltag(Map<Date, Map<String, List<MatchDTO>>> spielTage, Match match) {
		Map<String, List<MatchDTO>> turniere = new TreeMap<>();
		neuesTurnier(turniere, match);
		spielTage.put(match.getId().getMatchDay(), turniere);
	}

	void neuesTurnier(Map<String, List<MatchDTO>> turniere, Match match) {
		List<MatchDTO> spiele = new ArrayList<>();
		spiele.add(createMatchDTO(match));
		turniere.put(match.getTournamentId(), spiele);
	}

	private MatchDTO createMatchDTO(Match match) {
		MatchDTO matchDTO = new MatchDTO();
		matchDTO.setAnlageUser(match.getAnlageUser());
		matchDTO.setAnlageZeitpunkt(match.getAnlageZeitpunkt());
		matchDTO.setAuswaertsTeamId(match.getId().getOpponentTeamId());
		matchDTO.setHeimTeamId(match.getId().getHomeTeamId());
		matchDTO.setSpielTag(match.getId().getMatchDay());
		matchDTO.setAuswaertsTeamTore(match.getOpponentTeamGoals());
		matchDTO.setMatchresult(match.getMatchresult());
		matchDTO.setTurnierId(match.getTournamentId());
		matchDTO.setUpdateUser(match.getUpdateUser());
		matchDTO.setUpdateZeitpunkt(match.getUpdateZeitpunkt());
		return matchDTO;
	}

	public void insertMatch(MatchDTO matchDTO) {
		Match matchDB = new Match();
		mappeMatchDBToMatchDTO(matchDB, matchDTO);
		matchesRepo.insertMatch(matchDB);
	}

	private void mappeMatchDBToMatchDTO(Match matchDB, MatchDTO matchDTO) {
		matchDB.setId(erstelleMatchId(matchDTO));
		matchDB.setAnlageUser(matchDTO.getAnlageUser());
		matchDB.setAnlageZeitpunkt(matchDTO.getAnlageZeitpunkt());
		matchDB.setHomeTeamGoals(Integer.valueOf(matchDTO.getHeimTeamTore()));
		matchDB.setOpponentTeamGoals(matchDTO.getHeimTeamTore());
		matchDB.setTournamentId(matchDTO.getTurnierId());
		matchDB.setMatchresult(matchDTO.getMatchresult());
		matchDB.setUpdateUser(matchDTO.getUpdateUser());
		matchDB.setUpdateZeitpunkt(matchDTO.getUpdateZeitpunkt());
	}

	private MatchPK erstelleMatchId(MatchDTO matchDTO) {
		MatchPK matchPrimaryKey = new MatchPK();
		matchPrimaryKey.setHomeTeamId(matchDTO.getHeimTeamId());
		matchPrimaryKey.setOpponentTeamId(matchDTO.getAuswaertsTeamId());
		matchPrimaryKey.setMatchDay(matchDTO.getSpielTag());
		return matchPrimaryKey;
	}

}
