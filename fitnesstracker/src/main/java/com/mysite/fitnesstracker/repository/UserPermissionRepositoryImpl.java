package com.mysite.fitnesstracker.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class UserPermissionRepositoryImpl implements UserPermissionRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see com.mysite.fitnesstracker.repository.UserPermissionRepository#getPermissionCount(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public long getPermissionCount(String username, String target, String permission) {
		String userPermissionQueryStr = "select count(*) from UserPermission p where p.user.username=:username and p.target=:target "
				+ "and p.permission=:permission";
		Query userPermissionQuery = entityManager.createQuery(userPermissionQueryStr);
		userPermissionQuery.setParameter("username", username);
		userPermissionQuery.setParameter("target", target);
		userPermissionQuery.setParameter("permission", permission);
		
		return (long) userPermissionQuery.getSingleResult();
	}

}
