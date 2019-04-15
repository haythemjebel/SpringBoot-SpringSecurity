package com.haythem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haythem.entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

}
