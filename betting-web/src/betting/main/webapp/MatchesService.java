package betting.main.webapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import betting.main.data.MatchDTO;
import db.entity.Match;
import db.entity.MatchPK;
import db.service.MatchesRepository;

@Component("matchesService")
public class MatchesService {
	
	@Autowired
	private MatchesRepository matchesRepo;
	
	/**
	 * Matchdetails suchen und mapppen -> fuer UPDATE und SELECT 
	 * */
	public MatchDTO getMatch() {
		return null;
		
	}
	/**
	 * Alle Matches zu einem bestimmten Suchparameter oder alle Matches
	 * */
	public List<MatchDTO> getMatches(String matchDay, String heimTeamId, String auswaertsTeamId, String turnierId){
		List<MatchDTO> matches = new ArrayList<>();
		
		return matches;
	}

	public void insertMatch(MatchDTO matchDTO) {
		Match matchDB = new Match();
		mappeMatchDTOToMatchDB(matchDB, matchDTO);
		matchesRepo.insertMatch(matchDB);
	}
	
	// TODO: mapping der DTO Daten zu DB Daten
	private void mappeMatchDTOToMatchDB(Match matchDB, MatchDTO matchDTO) {
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
