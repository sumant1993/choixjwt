package com.order.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.Entity.UserInfo;

public interface UserInfoRepo extends JpaRepository<UserInfo, Long>
{

	UserInfo findByUserName(String userName);
}
