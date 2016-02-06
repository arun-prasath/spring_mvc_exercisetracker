package com.mysite.fitnesstracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.fitnesstracker.repository.UserPermissionRepository;

@Service
public class UserPermissionServiceImpl implements UserPermissionService {
	
	@Autowired
	private UserPermissionRepository userPermissionRepository;
	
	/* (non-Javadoc)
	 * @see com.mysite.fitnesstracker.service.UserPermissionService#getPermissionCount(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public long getPermissionCount(String username, String target, String permission) {
		return userPermissionRepository.getPermissionCount(username, target, permission);
	}
}
