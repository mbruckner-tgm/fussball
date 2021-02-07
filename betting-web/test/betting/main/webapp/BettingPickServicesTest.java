package betting.main.webapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import db.entity.BettingPick;
import db.entity.Match;
import db.service.BettingRepository;

@RunWith(MockitoJUnitRunner.class)
public class BettingPickServicesTest {

	@InjectMocks
	BettingPicksService bettingPickService;
	
	@Mock
	BettingRepository bettingRepo;
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	@Test
	public void testNewCollectionIdErstellung() {
		String bettingCollectionId = bettingPickService.createBettingPickCollectionId("");
		String[] splittedCollectionId = bettingCollectionId.split("_");
		assertEquals(dateFormat.format(new Date(System.currentTimeMillis())), splittedCollectionId[0]);
		assertEquals("000", splittedCollectionId[1]);
	}
	
	@Test
	public void testThirdCollectionIdErstellung() {
		String bettingCollectionId = bettingPickService.createBettingPickCollectionId("2021-01-17_001");
		String[] splittedCollectionId = bettingCollectionId.split("_");
		assertEquals("2021-01-17", splittedCollectionId[0]);
		assertEquals("002", splittedCollectionId[1]);
	}
	
	@Test
	public void testXCollectionIdErstellung() {
		String bettingCollectionId = bettingPickService.createBettingPickCollectionId("2021-01-17_037");
		String[] splittedCollectionId = bettingCollectionId.split("_");
		assertEquals("2021-01-17", splittedCollectionId[0]);
		assertEquals("038", splittedCollectionId[1]);
	}
	
	@Test
	public void vergleicheToreHeimTeamGleicheTore() {
		BettingPick bettingPickDB = new BettingPick();
		bettingPickDB.setTeam1Goals(new Integer("1"));
		Match matchDB = new Match();
		matchDB.setHomeTeamGoals(new Integer("1"));
		assertTrue(bettingPickService.areHomeGoalsCorrect(bettingPickDB, matchDB));
	}
	
	@Test
	public void vergleicheToreHeimTeamVerschiedeneTore() {
		BettingPick bettingPickDB = new BettingPick();
		bettingPickDB.setTeam1Goals(new Integer("1"));
		Match matchDB = new Match();
		matchDB.setHomeTeamGoals(new Integer("2"));
		assertFalse(bettingPickService.areHomeGoalsCorrect(bettingPickDB, matchDB));
	}
	@Test
	public void vergleicheToreHeimTeamToreNochNichtEingetragen() {
		BettingPick bettingPickDB = new BettingPick();
		bettingPickDB.setTeam1Goals(new Integer("1"));
		Match matchDB = new Match();
		assertFalse(bettingPickService.areHomeGoalsCorrect(bettingPickDB, matchDB));
	}
	@Test
	public void vergleicheAuswaertsTeamGleicheTore() {
		BettingPick bettingPickDB = new BettingPick();
		bettingPickDB.setTeam2Goals(new Integer("1"));
		Match matchDB = new Match();
		matchDB.setOpponentTeamGoals(new Integer("1"));
		assertTrue(bettingPickService.areOpponentGoalsCorrect(bettingPickDB, matchDB));
	}
	
	@Test
	public void vergleicheToreAuswaertsTeamVerschiedeneTore() {
		BettingPick bettingPickDB = new BettingPick();
		bettingPickDB.setTeam2Goals(new Integer("1"));
		Match matchDB = new Match();
		matchDB.setOpponentTeamGoals(new Integer("2"));
		assertFalse(bettingPickService.areOpponentGoalsCorrect(bettingPickDB, matchDB));
	}
	@Test
	public void vergleicheToreAuswaertsTeamToreNochNichtEingetragen() {
		BettingPick bettingPickDB = new BettingPick();
		bettingPickDB.setTeam2Goals(new Integer("1"));
		Match matchDB = new Match();
		assertFalse(bettingPickService.areOpponentGoalsCorrect(bettingPickDB, matchDB));
	}
	
	@Test
	public void berechneWettpunkteWennTippKomplettKorrekt() {
		BettingPick bettingPickDB = new BettingPick();
		bettingPickDB.setTeam1Goals(new Integer("1"));
		bettingPickDB.setTeam2Goals(new Integer("2"));
		bettingPickDB.setMatchresult("2");
		Match matchDB = new Match();
		matchDB.setHomeTeamGoals(new Integer("1"));
		matchDB.setOpponentTeamGoals(new Integer("2"));
		matchDB.setMatchresult("2");
		int bettingPickPoints = bettingPickService.getBettingPointsForBettingPick(bettingPickDB, matchDB);
		assertEquals(4, bettingPickPoints);
	}
	@Test
	public void berechneWettpunkteWennNurSpielergebnisKorrekt() {
		BettingPick bettingPickDB = new BettingPick();
		bettingPickDB.setTeam1Goals(new Integer("2"));
		bettingPickDB.setTeam2Goals(new Integer("1"));
		bettingPickDB.setMatchresult("1");
		Match matchDB = new Match();
		matchDB.setHomeTeamGoals(new Integer("3"));
		matchDB.setOpponentTeamGoals(new Integer("0"));
		matchDB.setMatchresult("1");
		int bettingPickPoints = bettingPickService.getBettingPointsForBettingPick(bettingPickDB, matchDB);
		assertEquals(1, bettingPickPoints);
	}
	@Test
	public void berechneWettpunkteWennNichtsKorrekt() {
		BettingPick bettingPickDB = new BettingPick();
		bettingPickDB.setTeam1Goals(new Integer("2"));
		bettingPickDB.setTeam2Goals(new Integer("1"));
		bettingPickDB.setMatchresult("1");
		Match matchDB = new Match();
		matchDB.setHomeTeamGoals(new Integer("0"));
		matchDB.setOpponentTeamGoals(new Integer("1"));
		matchDB.setMatchresult("2");
		int bettingPickPoints = bettingPickService.getBettingPointsForBettingPick(bettingPickDB, matchDB);
		assertEquals(0, bettingPickPoints);
	}
	@Test
	public void berechneWettpunkteWennSpielergebnisUndTorDifferenzKorrekt() {
		BettingPick bettingPickDB = new BettingPick();
		bettingPickDB.setTeam1Goals(new Integer("3"));
		bettingPickDB.setTeam2Goals(new Integer("1"));
		bettingPickDB.setMatchresult("1");
		Match matchDB = new Match();
		matchDB.setHomeTeamGoals(new Integer("2"));
		matchDB.setOpponentTeamGoals(new Integer("0"));
		matchDB.setMatchresult("1");
		int bettingPickPoints = bettingPickService.getBettingPointsForBettingPick(bettingPickDB, matchDB);
		assertEquals(3, bettingPickPoints);
	}
	@Test
	public void berechneWettpunkteWennSpielergebnisUndTorDifferenzKorrektBeiUnentschieden() {
		BettingPick bettingPickDB = new BettingPick();
		bettingPickDB.setTeam1Goals(new Integer("1"));
		bettingPickDB.setTeam2Goals(new Integer("1"));
		bettingPickDB.setMatchresult("X");
		Match matchDB = new Match();
		matchDB.setHomeTeamGoals(new Integer("2"));
		matchDB.setOpponentTeamGoals(new Integer("2"));
		matchDB.setMatchresult("X");
		int bettingPickPoints = bettingPickService.getBettingPointsForBettingPick(bettingPickDB, matchDB);
		assertEquals(3, bettingPickPoints);
	}
	
	@Test
	public void berechneWettpunkteWennKomplettKorrektBeiUnentschieden() {
		BettingPick bettingPickDB = new BettingPick();
		bettingPickDB.setTeam1Goals(new Integer("1"));
		bettingPickDB.setTeam2Goals(new Integer("1"));
		bettingPickDB.setMatchresult("X");
		Match matchDB = new Match();
		matchDB.setHomeTeamGoals(new Integer("1"));
		matchDB.setOpponentTeamGoals(new Integer("1"));
		matchDB.setMatchresult("X");
		int bettingPickPoints = bettingPickService.getBettingPointsForBettingPick(bettingPickDB, matchDB);
		assertEquals(4, bettingPickPoints);
	}
	@Test
	public void berechneWettpunkteWennNurSpielergebnisGetipptUndKorrekt() {
		BettingPick bettingPickDB = new BettingPick();
		bettingPickDB.setMatchresult("1");
		Match matchDB = new Match();
		matchDB.setMatchresult("1");
		int bettingPickPoints = bettingPickService.getBettingPointsForBettingPick(bettingPickDB, matchDB);
		assertEquals(1, bettingPickPoints);
	}
}
