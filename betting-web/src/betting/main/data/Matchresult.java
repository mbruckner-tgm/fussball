package betting.main.data;

public enum Matchresult {
	
	SIEG_HEIMTEAM("1"),
	UNENTSCHIEDEN("X"),
	SIEG_AUSWAERTSTEAM("2"),
	NOCH_KEIN_ERGEBNIS("");

	String matchresult;
	
	Matchresult(String matchresult) {
		this.matchresult = matchresult;
	}

	public String getMatchresult() {
		return matchresult;
	}
	
}
