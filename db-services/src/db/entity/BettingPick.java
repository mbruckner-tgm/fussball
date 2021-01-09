package db.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the betting_picks database table.
 * 
 */
@Entity
@Table(name="betting_picks")
@NamedQuery(name="BettingPick.findAll", query="SELECT b FROM BettingPick b")
public class BettingPick implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BettingPickPK id;

	@Column(name="betting_pick_result")
	private Integer bettingPickResult;

	@Column(name="match_id")
	private String matchId;

	private String matchresult;

	@Column(name="team1_goals")
	private Integer team1Goals;

	@Column(name="team2_goals")
	private Integer team2Goals;

	//bi-directional many-to-one association to AppUser
	@ManyToOne
	@JoinColumn(name="user_name")
	private AppUser appUser;

	public BettingPick() {
	}

	public BettingPickPK getId() {
		return this.id;
	}

	public void setId(BettingPickPK id) {
		this.id = id;
	}

	public Integer getBettingPickResult() {
		return this.bettingPickResult;
	}

	public void setBettingPickResult(Integer bettingPickResult) {
		this.bettingPickResult = bettingPickResult;
	}

	public String getMatchId() {
		return this.matchId;
	}

	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}

	public String getMatchresult() {
		return this.matchresult;
	}

	public void setMatchresult(String matchresult) {
		this.matchresult = matchresult;
	}

	public Integer getTeam1Goals() {
		return this.team1Goals;
	}

	public void setTeam1Goals(Integer team1Goals) {
		this.team1Goals = team1Goals;
	}

	public Integer getTeam2Goals() {
		return this.team2Goals;
	}

	public void setTeam2Goals(Integer team2Goals) {
		this.team2Goals = team2Goals;
	}

	public AppUser getAppUser() {
		return this.appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

}