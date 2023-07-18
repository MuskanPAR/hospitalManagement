package com.hospitalmanagement.hospitalmanagement.service.staffservice;

import com.hospitalmanagement.hospitalmanagement.entity.Staff;
import com.hospitalmanagement.hospitalmanagement.responsemodel.ResponseModal;

public interface StaffService {
    void signup(Staff staff, ResponseModal responseModal);
    void login(long staffId, ResponseModal responseModal);

}
