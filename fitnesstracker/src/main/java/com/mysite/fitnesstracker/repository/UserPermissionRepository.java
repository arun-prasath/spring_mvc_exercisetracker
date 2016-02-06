package com.mysite.fitnesstracker.repository;

public interface UserPermissionRepository {

	long getPermissionCount(String username, String target, String permission);

}