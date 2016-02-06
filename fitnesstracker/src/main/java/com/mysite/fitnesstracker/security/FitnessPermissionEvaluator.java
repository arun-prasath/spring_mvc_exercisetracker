package com.mysite.fitnesstracker.security;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

import com.mysite.fitnesstracker.model.MyUserDetails;
import com.mysite.fitnesstracker.service.UserPermissionService;

public class FitnessPermissionEvaluator implements PermissionEvaluator {

	@Autowired
	private UserPermissionService userPermissionService;
	
	@Override
	public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
		long userPermissionCount = userPermissionService.getPermissionCount(((MyUserDetails)authentication.getPrincipal()).getUsername(), 
				targetDomainObject.getClass().getName(), permission.toString());
		
		return userPermissionCount == 1 ? true : false; 
	}

	@Override
	public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType,
			Object permission) {
		return false;
	}

}
