package db.entity;

public class Player {

	private String playerId;
	private String playerName;
	public String getPlayerId() {
		return playerId;
	}
	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	@Override
	public String toString() {
		return "Players [playerId=" + playerId + ", playerName=" + playerName + "]";
	}
	
	
	
}
