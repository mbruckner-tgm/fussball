package db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the app_user database table.
 * 
 */
@Entity
@Table(name="app_user")
@NamedQuery(name="AppUser.findAll", query="SELECT a FROM AppUser a")
public class AppUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="user_name")
	private String userName;

	private Integer enabled;

	@Column(name="encrypted_password")
	private String encryptedPassword;

	//bi-directional many-to-one association to AppRole
	@ManyToOne
	@JoinColumn(name="role_name")
	private AppRole appRole;

	//bi-directional many-to-one association to BettingPick
	@OneToMany(mappedBy="appUser")
	private List<BettingPick> bettingPicks;

	public AppUser() {
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public String getEncryptedPassword() {
		return this.encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public AppRole getAppRole() {
		return this.appRole;
	}

	public void setAppRole(AppRole appRole) {
		this.appRole = appRole;
	}

	public List<BettingPick> getBettingPicks() {
		return this.bettingPicks;
	}

	public void setBettingPicks(List<BettingPick> bettingPicks) {
		this.bettingPicks = bettingPicks;
	}

	public BettingPick addBettingPick(BettingPick bettingPick) {
		getBettingPicks().add(bettingPick);
		bettingPick.setAppUser(this);

		return bettingPick;
	}

	public BettingPick removeBettingPick(BettingPick bettingPick) {
		getBettingPicks().remove(bettingPick);
		bettingPick.setAppUser(null);

		return bettingPick;
	}

}