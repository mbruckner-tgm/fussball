package db.service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import db.entity.AppRole;
import db.entity.AppUser;

@Transactional
@Repository("appUsersRepository")
public class AppUsersRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public AppUser findUserAccount(String userName) throws NoResultException {
		String sql = "Select e from " + AppUser.class.getName() + " e " //
				+ " Where e.userName = :userName ";
		try {
			Query query = entityManager.createQuery(sql, AppUser.class);
			query.setParameter("userName", userName);

			return (AppUser) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public void insertUserAccount(String username, String encryptedPassword) throws EntityManagerException {
		try {
			AppUser newAppUser = new AppUser();
			newAppUser.setUserName(username);
			newAppUser.setEncryptedPassword(encryptedPassword);
			newAppUser.setEnabled(1);
			AppRole appRole = new AppRole();
			appRole.setRoleName("ROLE_USER");
			newAppUser.setAppRole(appRole);
			entityManager.persist(newAppUser);

		} catch (PersistenceException e) {
			throw new EntityManagerException(e, e.getMessage());
		}
	}

}