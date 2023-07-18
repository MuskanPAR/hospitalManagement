package com.hospitalmanagement.hospitalmanagement.repository;

import com.hospitalmanagement.hospitalmanagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByStatus(String status);
//    @Modifying
//    @Query("UPDATE patient p SET p.status = :status WHERE p.id = :id")
//    int updatePatientStatus(@Param("id") Long patientId, @Param("status") String status);
}
