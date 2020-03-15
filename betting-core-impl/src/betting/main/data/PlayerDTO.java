package betting.main.data;

public class PlayerDTO {

	private String playerName;
	private String playerId;

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	@Override
	public String toString() {
		return "PlayerDTO [playerName=" + playerName + ", playerId=" + playerId + "]";
	}

}
