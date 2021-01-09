package betting.main.data;

import java.util.List;

public class TurnierStatisitkDTO {

	private String turnierNamen;
	private List<SpielerStatistikDTO> spielerStatsZuTurnier;
	
	public TurnierStatisitkDTO() {
		super();
	}

	public String getTurnierNamen() {
		return turnierNamen;
	}

	public void setTurnierNamen(String turnierNamen) {
		this.turnierNamen = turnierNamen;
	}

	public List<SpielerStatistikDTO> getSpielerStatsZuTurnier() {
		return spielerStatsZuTurnier;
	}

	public void setSpielerStatsZuTurnier(List<SpielerStatistikDTO> spielerStatsZuTurnier) {
		this.spielerStatsZuTurnier = spielerStatsZuTurnier;
	}
	
	
}
