package betting.main.data;

public enum BettingPickPoints {

	RICHTIGES_SPIELERGEBNIS(1), RICHTIGE_TORDIFFERENZ(2), RICHTIGES_ERGEBNIS(3);

	int bettingPickPoints;

	BettingPickPoints(int bettingPickPoints) {
		this.bettingPickPoints = bettingPickPoints;
	}

	public int getBettingPickPoints() {
		return bettingPickPoints;
	}

}
