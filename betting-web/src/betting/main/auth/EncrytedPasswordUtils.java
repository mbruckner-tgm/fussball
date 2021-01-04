package betting.main.auth;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncrytedPasswordUtils {
	static BCryptPasswordEncoder encoder;

	public EncrytedPasswordUtils() {
		encoder = new BCryptPasswordEncoder();
	}

	// Encryte Password with BCryptPasswordEncoder
	public static String encrytePassword(String password) {

		return encoder.encode(password);
	}

	public static void main(String[] args) {
		String password = "tapsi1234";
		String encrytedPassword = encrytePassword(password);

		System.out.println("Encryted Password: " + encrytedPassword);
	}

}