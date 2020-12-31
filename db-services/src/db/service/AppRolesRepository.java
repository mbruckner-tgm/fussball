package db.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import db.entity.UserRole;

@Transactional
@Repository("appRolesRepository")
public class AppRolesRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<String> getRoleNames(Long userId) {
		String sql = "Select ur.appRole.roleName from " + UserRole.class.getName() + " ur " //
				+ " where ur.appUser.userId = :userId ";

		Query query = this.entityManager.createQuery(sql, String.class);
		query.setParameter("userId", userId);
		return query.getResultList();
	}
}