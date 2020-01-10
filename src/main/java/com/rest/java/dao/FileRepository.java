package com.rest.java.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.java.entity.Doctor;
@Repository
public interface FileRepository extends JpaRepository<Doctor, Integer>{

}
