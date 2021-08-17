package com.pandemic.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pandemic.apirest.models.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {

}
