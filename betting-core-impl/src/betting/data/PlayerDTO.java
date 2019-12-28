package betting.data;

import betting.service.Player;

public class PlayerDTO implements Player {

	private String playerName;
	private String playerId;

	@Override
	public String getPlayerName() {
		return playerName;
	}

	@Override
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	@Override
	public String getPlayerId() {
		return playerId;
	}

	@Override
	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	@Override
	public String toString() {
		return "PlayerDTO [playerName=" + playerName + ", playerId=" + playerId + "]";
	}

}
