package betting.main.mapper;

import java.util.List;

import betting.main.data.AppUserDTO;
import db.entity.AppUser;

public class MapperClass {

	public void mappeAppUsersToListOfAppUserDTOs(List<AppUser> appUsers, List<AppUserDTO> listOfAppUserDTOs) {
		appUsers.forEach(appUserDB -> listOfAppUserDTOs.add(createAppUserDTOFromPlayer(appUserDB)));
	}

	private AppUserDTO createAppUserDTOFromPlayer(AppUser appUserDB) {
		AppUserDTO appUserDTO = new AppUserDTO();
		appUserDTO.setUserId(appUserDB.getUserId());
		appUserDTO.setUserName(appUserDB.getUserName());
		appUserDTO.setEncrytedPassword(appUserDB.getEncryptedPassword());
		return appUserDTO;
	}

}
