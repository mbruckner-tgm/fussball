package betting.main.webapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import betting.main.data.AppUserDTO;
import db.service.AppUsersRepository;

@Component("appUsersService")
public class AppUsersService {

	@Autowired
	AppUsersRepository appUsersRepository;

	public List<AppUserDTO> getListOfAppUsers() {
		List<AppUserDTO> listOfAppUserDTOs = new ArrayList<>();
		// new
		// MapperClass().mappeAppUsersToListOfAppUserDTOs(appUsersRepository.findUserAccount(),
		// listOfAppUserDTOs);
		return listOfAppUserDTOs;
	}

}
