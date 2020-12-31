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
	@Column(name="user_id")
	private Long userId;

	private Integer enabled;

	@Column(name="encrypted_password")
	private String encryptedPassword;

	@Column(name="user_name")
	private String userName;

	//bi-directional many-to-one association to UserRole
	@OneToMany(mappedBy="appUser")
	private List<UserRole> userRoles;

	//bi-directional many-to-one association to BettingPick
	@OneToMany(mappedBy="appUser")
	private List<BettingPick> bettingPicks;

	public AppUser() {
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public UserRole addUserRole(UserRole userRole) {
		getUserRoles().add(userRole);
		userRole.setAppUser(this);

		return userRole;
	}

	public UserRole removeUserRole(UserRole userRole) {
		getUserRoles().remove(userRole);
		userRole.setAppUser(null);

		return userRole;
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