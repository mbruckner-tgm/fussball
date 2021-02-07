package betting.main.data;

public class BettingPickDTO {

	private String bettingPicksCollectionId;
	private String bettingPickId;
	private String bettingPlayer;
	private String matchId;

	private Integer homeGoals;
	private Integer opponentGoals;
	private Integer bettingPickResult;
	private String matchresult;

	public String getBettingPicksCollectionId() {
		return bettingPicksCollectionId;
	}

	public void setBettingPicksCollectionId(String bettingPicksCollectionId) {
		this.bettingPicksCollectionId = bettingPicksCollectionId;
	}

	public String getBettingPickId() {
		return bettingPickId;
	}

	public void setBettingPickId(String bettingPickId) {
		this.bettingPickId = bettingPickId;
	}

	public String getBettingPlayer() {
		return bettingPlayer;
	}

	public void setBettingPlayer(String bettingPlayer) {
		this.bettingPlayer = bettingPlayer;
	}

	public String getMatchId() {
		return matchId;
	}

	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}

	public Integer getHomeGoals() {
		return homeGoals;
	}

	public void setHomeGoals(Integer homeGoals) {
		this.homeGoals = homeGoals;
	}

	public Integer getOpponentGoals() {
		return opponentGoals;
	}

	public void setOpponentGoals(Integer opponentGoals) {
		this.opponentGoals = opponentGoals;
	}

	public Integer getBettingPickResult() {
		return bettingPickResult;
	}

	public void setBettingPickResult(Integer bettingPickResult) {
		this.bettingPickResult = bettingPickResult;
	}

	public String getMatchresult() {
		return matchresult;
	}

	public void setMatchresult(String matchresult) {
		this.matchresult = matchresult;
	}

	@Override
	public String toString() {
		return "BettingPickDTO [bettingPicksCollectionId=" + bettingPicksCollectionId + ", bettingPickId="
				+ bettingPickId + ", bettingPlayer=" + bettingPlayer + ", matchId=" + matchId + ", homeGoals="
				+ homeGoals + ", opponentGoals=" + opponentGoals + ", bettingPickResult=" + bettingPickResult
				+ ", matchresult=" + matchresult + "]";
	}

}
