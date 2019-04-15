package com.haythem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.haythem.entities.User;

public interface UserRepository extends JpaRepository<User, String> {
	@Query("select p from User p where p.username = :x ")
	User finddOne(@Param("x")String username);

}
