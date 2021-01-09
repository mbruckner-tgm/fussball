package betting.main.data;

import java.sql.Timestamp;
import java.util.Date;

public class MatchDTO {

	private Date spielTag;
	private String heimTeamId;
	private String auswaertsTeamId;
	private String turnierId;
	private int heimTeamTore;
	private int auswaertsTeamTore;
	private String matchresult;
	private String anlageUser;
	private Timestamp anlageZeitpunkt;
	private String updateUser;
	private Timestamp updateZeitpunkt;

	public MatchDTO() {
		super();
	}

	public Date getSpielTag() {
		return spielTag;
	}

	public void setSpielTag(Date spielTag) {
		this.spielTag = spielTag;
	}

	public String getHeimTeamId() {
		return heimTeamId;
	}

	public void setHeimTeamId(String heimTeamId) {
		this.heimTeamId = heimTeamId;
	}

	public String getAuswaertsTeamId() {
		return auswaertsTeamId;
	}

	public void setAuswaertsTeamId(String auswaertsTeamId) {
		this.auswaertsTeamId = auswaertsTeamId;
	}

	public String getTurnierId() {
		return turnierId;
	}

	public void setTurnierId(String turnierId) {
		this.turnierId = turnierId;
	}

	public int getHeimTeamTore() {
		return heimTeamTore;
	}

	public void setHeimTeamTore(int heimTeamTore) {
		this.heimTeamTore = heimTeamTore;
	}

	public int getAuswaertsTeamTore() {
		return auswaertsTeamTore;
	}

	public void setAuswaertsTeamTore(int auswaertsTeamTore) {
		this.auswaertsTeamTore = auswaertsTeamTore;
	}

	public String getMatchresult() {
		return matchresult;
	}

	public void setMatchresult(String matchresult) {
		this.matchresult = matchresult;
	}

	public String getAnlageUser() {
		return anlageUser;
	}

	public void setAnlageUser(String anlageUser) {
		this.anlageUser = anlageUser;
	}

	public Timestamp getAnlageZeitpunkt() {
		return anlageZeitpunkt;
	}

	public void setAnlageZeitpunkt(Timestamp anlageZeitpunkt) {
		this.anlageZeitpunkt = anlageZeitpunkt;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Timestamp getUpdateZeitpunkt() {
		return updateZeitpunkt;
	}

	public void setUpdateZeitpunkt(Timestamp updateZeitpunkt) {
		this.updateZeitpunkt = updateZeitpunkt;
	}

	@Override
	public String toString() {
		return "MatchDTO [spielTag=" + spielTag + ", heimTeamId=" + heimTeamId + ", auswaertsTeamId=" + auswaertsTeamId
				+ ", turnierId=" + turnierId + ", heimTeamTore=" + heimTeamTore + ", auswaertsTeamTore="
				+ auswaertsTeamTore + ", matchresult=" + matchresult + ", anlageUser=" + anlageUser
				+ ", anlageZeitpunkt=" + anlageZeitpunkt + ", updateUser=" + updateUser + ", updateZeitpunkt="
				+ updateZeitpunkt + "]";
	}

}
