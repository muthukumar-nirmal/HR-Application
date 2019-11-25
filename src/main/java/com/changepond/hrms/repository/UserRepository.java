package com.changepond.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.changepond.hrms.domain.User;

/**
 * 
 * @author muthukumar.m
 *
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

public User findOneByUsername(String username);
}
