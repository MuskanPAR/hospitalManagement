package com.hospitalmanagement.hospitalmanagement.repository;

import com.hospitalmanagement.hospitalmanagement.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
    Staff findById(long id);
}
