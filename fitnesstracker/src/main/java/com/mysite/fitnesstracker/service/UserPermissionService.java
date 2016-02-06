package com.mysite.fitnesstracker.service;

public interface UserPermissionService {

	long getPermissionCount(String username, String target, String permission);

}