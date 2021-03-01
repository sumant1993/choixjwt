package com.order.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.Entity.AuthEvent;

public interface AuthEventRepo extends JpaRepository<AuthEvent, Long>
{

}
