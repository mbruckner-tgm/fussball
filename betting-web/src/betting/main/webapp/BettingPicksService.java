package betting.main.webapp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import betting.main.data.BettingPickDTO;
import betting.main.data.BettingPickPoints;
import db.entity.BettingPick;
import db.entity.BettingPickPK;
import db.entity.Match;
import db.service.BettingRepository;

@Component("bettingPicksService")
public class BettingPicksService {

	@Autowired
	BettingRepository bettingRepo;

	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	public BettingPickDTO getBettingPickDTO(String bettingPickCollectionId, String bettingPickId) {
		BettingPickDTO bettingPickDTO = new BettingPickDTO();
		BettingPick bettingPickDB = bettingRepo.getBettingPickByCollectionAndId(bettingPickCollectionId, bettingPickId);
		mappeBettingPickDBToBettingPickDTO(bettingPickDTO, bettingPickDB);
		return bettingPickDTO;
	}

	public void createBettingPick(BettingPickDTO bettingPickDTO) {
		BettingPick bettingPickDB = new BettingPick();
		mappeBettingPickDTOToBettingPickDB(bettingPickDB, bettingPickDTO);
		bettingRepo.createBettingPick(bettingPickDB);
	}

	public Map<String, List<BettingPickDTO>> createNewBettingPickCollection(String bettingPickCollectionId) {
		Map<String, List<BettingPickDTO>> bettingPickCollection = new TreeMap<>();
		bettingPickCollection.put(createBettingPickCollectionId(bettingPickCollectionId), new ArrayList<>());
		return bettingPickCollection;
	}

	public Map<String, List<BettingPickDTO>> getBettingPickCollection(String bettingPickCollectionId) {
		Map<String, List<BettingPickDTO>> bettingPickCollection = new TreeMap<>();
		List<BettingPickDTO> bettingsPicksDTOCollection = new ArrayList<>();
		List<BettingPick> bettingPicksByCollectionId = bettingRepo
				.getBettingPicksByCollectionId(bettingPickCollectionId);
		mappeBettingPicksToBettingPicksDTO(bettingPicksByCollectionId, bettingsPicksDTOCollection);
		bettingPickCollection.put(bettingPickCollectionId, bettingsPicksDTOCollection);
		return bettingPickCollection;
	}

	private void mappeBettingPickDTOToBettingPickDB(BettingPick bettingPickDB, BettingPickDTO bettingPickDTO) {
		bettingPickDB.setId(createBettingPickPK(bettingPickDTO));
		bettingPickDB.setBettingPickResult(bettingPickDTO.getBettingPickResult());
		bettingPickDB.setTeam1Goals(bettingPickDTO.getHomeGoals());
		bettingPickDB.setTeam2Goals(bettingPickDTO.getOpponentGoals());
		bettingPickDB.setMatchresult(bettingPickDTO.getMatchresult());
		bettingPickDB.setMatchId(bettingPickDTO.getMatchId());
	}

	private BettingPickPK createBettingPickPK(BettingPickDTO bettingPickDTO) {
		BettingPickPK bettingPickPK = new BettingPickPK();
		bettingPickPK.setBettingPickId(bettingPickDTO.getBettingPickId());
		bettingPickPK.setBettingPicksCollectionId(bettingPickDTO.getBettingPicksCollectionId());
		bettingPickPK.setUserName(bettingPickDTO.getBettingPlayer());
		return bettingPickPK;
	}

	private void mappeBettingPickDBToBettingPickDTO(BettingPickDTO bettingPickDTO, BettingPick bettingPickDB) {
		bettingPickDTO.setBettingPickId(bettingPickDB.getId().getBettingPickId());
		bettingPickDTO.setBettingPicksCollectionId(bettingPickDB.getId().getBettingPicksCollectionId());
		bettingPickDTO.setBettingPlayer(bettingPickDB.getId().getUserName());
		bettingPickDTO.setBettingPickResult(bettingPickDB.getBettingPickResult());
		bettingPickDTO.setHomeGoals(bettingPickDB.getTeam1Goals());
		bettingPickDTO.setOpponentGoals(bettingPickDB.getTeam2Goals());
		bettingPickDTO.setMatchresult(bettingPickDB.getMatchresult());
		bettingPickDTO.setMatchId(bettingPickDB.getMatchId());
	}

	public void mappeBettingPicksToBettingPicksDTO(List<BettingPick> bettingPicksByCollectionId,
			List<BettingPickDTO> bettingsPicksDTOCollection) {
		for (BettingPick bettingPickDB : bettingPicksByCollectionId) {
			BettingPickDTO bettingPickDTO = new BettingPickDTO();
			mappeBettingPickDBToBettingPickDTO(bettingPickDTO, bettingPickDB);
			bettingsPicksDTOCollection.add(bettingPickDTO);
		}
	}

	public String createBettingPickCollectionId(String collectionId) {
		StringBuilder bettingPickCollectionBuilder = new StringBuilder();
		if (collectionId.isEmpty()) {
			bettingPickCollectionBuilder.append(dateFormat.format(new Date(System.currentTimeMillis())));
			bettingPickCollectionBuilder.append("_");
			bettingPickCollectionBuilder.append("000");
		} else {
			String[] collectionIdSplitted = collectionId.split("_");
			bettingPickCollectionBuilder.append(collectionIdSplitted[0]);
			bettingPickCollectionBuilder.append("_");
			int collectionIdLaufendeNr = Integer.valueOf(collectionIdSplitted[1]).intValue() + 1;
			String newCollectionId = String.format("%03d", collectionIdLaufendeNr);
			bettingPickCollectionBuilder.append(newCollectionId);
		}
		return bettingPickCollectionBuilder.toString();
	}

	public int getBettingPointsForBettingPick(BettingPick bettingPickDB, Match matchDB) {
		int bettingPickPoints = 0;
		if (isMatchresultPickedForBetting(bettingPickDB) && isMatchResultCorrect(bettingPickDB, matchDB)) {
			bettingPickPoints += BettingPickPoints.RICHTIGES_SPIELERGEBNIS.getBettingPickPoints();
		}
		if (areGoalsPickedForBetting(bettingPickDB)) {
			if (areHomeGoalsCorrect(bettingPickDB, matchDB) && areOpponentGoalsCorrect(bettingPickDB, matchDB)) {
				bettingPickPoints += BettingPickPoints.RICHTIGES_ERGEBNIS.getBettingPickPoints();
			} else if (isGoalDifferenceCorrect(bettingPickDB, matchDB)) {
				bettingPickPoints += BettingPickPoints.RICHTIGE_TORDIFFERENZ.getBettingPickPoints();
			}
		}
		return bettingPickPoints;
	}

	public boolean isGoalDifferenceCorrect(BettingPick bettingPickDB, Match matchDB) {
		return checkIfIntegersEquals(
				getDifferenceByGivenIntegers(bettingPickDB.getTeam1Goals().intValue(),
						matchDB.getHomeTeamGoals().intValue()),
				getDifferenceByGivenIntegers(bettingPickDB.getTeam2Goals().intValue(),
						matchDB.getOpponentTeamGoals().intValue()));
	}

	int getDifferenceByGivenIntegers(int int1, int int2) {
		return int1 - int2;
	}

	public boolean isMatchresultPickedForBetting(BettingPick bettingPickDB) {
		return checkIfStringHasTextNotNull(bettingPickDB.getMatchresult());
	}

	public boolean areGoalsPickedForBetting(BettingPick bettingPickDB) {
		return bettingPickDB.getTeam1Goals() != null && bettingPickDB.getTeam2Goals() != null;
	}

	public boolean isMatchResultCorrect(BettingPick bettingPickDB, Match matchDB) {
		return checkIfStringsEquals(bettingPickDB.getMatchresult(), matchDB.getMatchresult());
	}

	public boolean areHomeGoalsCorrect(BettingPick bettingPickDB, Match matchDB) {
		return matchDB.getHomeTeamGoals() != null && checkIfIntegersEquals(bettingPickDB.getTeam1Goals().intValue(),
				matchDB.getHomeTeamGoals().intValue());
	}

	public boolean areOpponentGoalsCorrect(BettingPick bettingPickDB, Match matchDB) {
		return matchDB.getOpponentTeamGoals() != null && checkIfIntegersEquals(bettingPickDB.getTeam2Goals().intValue(),
				matchDB.getOpponentTeamGoals().intValue());
	}

	boolean checkIfIntegersEquals(int int1, Integer int2) {
		return int1 == int2;
	}

	boolean checkIfStringsEquals(String string1, String string2) {
		if (string1 == null || string2 == null) {
			return false;
		} else if (string1.isEmpty()) {
			return false;
		} else if (string2.isEmpty()) {
			return false;
		}
		return string1.trim().equalsIgnoreCase(string2.trim());
	}

	boolean checkIfStringHasTextNotNull(String stringToCheck) {
		if (stringToCheck == null) {
			return false;
		} else if (stringToCheck.isEmpty()) {
			return false;
		}
		return true;
	}
}
