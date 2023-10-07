package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{

}
