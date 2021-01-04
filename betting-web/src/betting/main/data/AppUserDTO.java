package betting.main.data;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class AppUserDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long userId;

	private String userRole;
	@NotEmpty(message = "Username can not be empty!")
	private String userName;

	@NotEmpty(message = "Password can not be empty!")
	private String realPassword;

	@NotEmpty(message = "ConfirmPassword can not be empty!")
	private String confirmPassword;

	public AppUserDTO() {

	}

	public AppUserDTO(Long userId, String userRole, @NotEmpty(message = "Username can not be empty!") String userName,
			@NotEmpty(message = "Password can not be empty!") String realPassword,
			@NotEmpty(message = "ConfirmPassword can not be empty!") String confirmPassword) {
		super();
		this.userId = userId;
		this.userRole = userRole;
		this.userName = userName;
		this.realPassword = realPassword;
		this.confirmPassword = confirmPassword;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealPassword() {
		return realPassword;
	}

	public void setRealPassword(String realPassword) {
		this.realPassword = realPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return this.userName + "/" + this.realPassword;
	}
}
