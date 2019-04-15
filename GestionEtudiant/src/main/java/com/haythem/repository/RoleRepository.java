package com.haythem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.haythem.entities.Role;

public interface RoleRepository extends JpaRepository<Role, String> {
	@Query("select p from Role p where p.role = :x ")
	Role finddOne(@Param("x")String username);

}
