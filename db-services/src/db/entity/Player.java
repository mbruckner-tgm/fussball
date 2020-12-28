package db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the players database table.
 * 
 */
@Entity
@Table(name="players")
@NamedQuery(name="Player.findAll", query="SELECT p FROM Player p")
public class Player implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="player_id")
	private Integer playerId;

	@Column(name="player_name")
	private String playerName;

	//bi-directional many-to-one association to BettingPick
	@OneToMany(mappedBy="player")
	private List<BettingPick> bettingPicks;

	public Player() {
	}

	public Integer getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return this.playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public List<BettingPick> getBettingPicks() {
		return this.bettingPicks;
	}

	public void setBettingPicks(List<BettingPick> bettingPicks) {
		this.bettingPicks = bettingPicks;
	}

	public BettingPick addBettingPick(BettingPick bettingPick) {
		getBettingPicks().add(bettingPick);
		bettingPick.setPlayer(this);

		return bettingPick;
	}

	public BettingPick removeBettingPick(BettingPick bettingPick) {
		getBettingPicks().remove(bettingPick);
		bettingPick.setPlayer(null);

		return bettingPick;
	}

}