package betting.main.webapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import betting.main.data.SpielerStatistikDTO;
import betting.main.data.TurnierStatisitkDTO;
import db.dtos.SpielerStatisitkDB;
import db.entity.AppUser;
import db.entity.Tournament;
import db.service.AppUsersRepository;
import db.service.SpielerTabelleRepository;

@Component("spielerTabelleService")
public class SpielerTabelleService {

	@Autowired
	private AppUsersRepository appUsersRepository;

	@Autowired
	private SpielerTabelleRepository spielerTabelleRepository;

	public List<SpielerStatistikDTO> getSpielerStatisitken() {
		List<SpielerStatistikDTO> spielerStatistiken = new ArrayList<>();
		for(AppUser spieler : appUsersRepository.findAllUsers()) {
			SpielerStatistikDTO spielerStatistik = new SpielerStatistikDTO(spieler.getUserName());
			SpielerStatisitkDB spielerStatistikDB = spielerTabelleRepository.findeSpielerStatisitikenZuUsername(spieler.getUserName());
			mappeSpielerStatistik(spielerStatistik,spielerStatistikDB);
			spielerStatistiken.add(spielerStatistik);
		}
		return spielerStatistiken;
	}

	private void mappeSpielerStatistik(SpielerStatistikDTO spielerStatistik, SpielerStatisitkDB spielerStatistikDB) {
		spielerStatistik.setAnzahlErhaltenePunkte(spielerStatistikDB.getAnzahlErhaltenePunkte());
		spielerStatistik.setAnzahlGespielteWetten(spielerStatistikDB.getAnzahlGespielteWetten());	
	}
	
	public List<TurnierStatisitkDTO> getTurnierStatistiken(){
		List<TurnierStatisitkDTO> turnierStats= new ArrayList<>();
		
		for (Tournament tournament : spielerTabelleRepository.findAllTournaments()) {
			TurnierStatisitkDTO turnier = new TurnierStatisitkDTO();
			turnier.setTurnierNamen(tournament.getTournamentName());
			turnier.setSpielerStatsZuTurnier(getSpielerStatisitken());
			turnierStats.add(turnier);
		}
		
		return turnierStats;
		
	}

}
