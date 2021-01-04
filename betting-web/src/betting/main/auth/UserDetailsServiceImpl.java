package betting.main.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import betting.main.data.AppUserDTO;
import betting.main.exception.DbZugriffException;
import betting.main.exception.PasswordMissmatchException;
import betting.main.exception.UserAlreadyExistsException;
import db.entity.AppUser;
import db.service.AppUsersRepository;
import db.service.EntityManagerException;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private AppUsersRepository appUsersRepo;

	public void registerNewUser(AppUserDTO appUserDTO)
			throws DbZugriffException, PasswordMissmatchException, UserAlreadyExistsException {
		try {
			validateUserPassword(appUserDTO);

			if (userAlreadyExists(appUserDTO.getUserName()))
				throw new UserAlreadyExistsException();

			appUsersRepo.insertUserAccount(appUserDTO.getUserName(),
					new BCryptPasswordEncoder().encode(appUserDTO.getRealPassword()));
		} catch (EntityManagerException e) {
			throw new DbZugriffException(e.getException(), e.getExceptionMessage());
		}
	}

	private void validateUserPassword(AppUserDTO appUserDTO) throws PasswordMissmatchException {
		if (!appUserDTO.getRealPassword().equalsIgnoreCase(appUserDTO.getConfirmPassword()))
			throw new PasswordMissmatchException();
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		AppUser appUser = appUsersRepo.findUserAccount(userName);
		if (appUser == null) {
			System.out.println("User not found! " + userName);
			throw new UsernameNotFoundException("User " + userName + " was not found in the database");
		}
		System.out.println("Found User: " + appUser);

		// [ROLE_USER, ROLE_ADMIN,..]

		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		if (appUser.getAppRole().getRoleName() != null) {
			// ROLE_USER, ROLE_ADMIN,..
			GrantedAuthority authority = new SimpleGrantedAuthority(appUser.getAppRole().getRoleName());
			grantList.add(authority);
		}

		UserDetails userDetails = new User(appUser.getUserName(), //
				appUser.getEncryptedPassword(), grantList);

		return userDetails;
	}

	private boolean userAlreadyExists(String userName) throws UserAlreadyExistsException {
		return appUsersRepo.findUserAccount(userName) != null;
	}

}