package com.hospitalmanagement.hospitalmanagement.service.staffservice.impl;

import com.hospitalmanagement.hospitalmanagement.entity.Staff;
import com.hospitalmanagement.hospitalmanagement.repository.StaffRepository;
import com.hospitalmanagement.hospitalmanagement.responsemodel.ResponseModal;
import com.hospitalmanagement.hospitalmanagement.service.staffservice.StaffService;
import com.hospitalmanagement.hospitalmanagement.utils.Constants;
import com.hospitalmanagement.hospitalmanagement.utils.ErrorResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    StaffRepository staffRepository;
    @Autowired
    ErrorResponse errorResponse;
    public static final Logger log = LogManager.getLogger(StaffServiceImpl.class);


    // Staff Signup
    @Override
    public void signup(Staff staff, ResponseModal responseModal) {
        log.info("Signing up staff with username:{}",staff.getUsername());
        try {
            staffRepository.save(staff);
            log.info("Successfully signed up staff with username: {}",staff.getUsername());
            responseModal.setResponseCode(Constants.SUCCESS_RESPONSE_CODE.value);
            responseModal.setResponseMessage("Sign up successful");
            responseModal.setResponseData(staff.getId());
        }catch (NullPointerException e) {
            log.info("NullPointerException for signing up staff with username:{} {} {}",staff.getUsername(),e.getMessage(),e);
            errorResponse.setResponse(responseModal);
        }catch (Exception e) {
            log.info("Exception for signing up staff with username:{} {}",staff.getUsername(),e.getMessage());
            errorResponse.setResponse(responseModal);
        }
    }

    // Staff Login
    @Override
    public void login(long id, ResponseModal responseModal) {
        log.info("Login staff with id: {}",id);
        try {
            Staff staff= staffRepository.findById(id);
            if (staff != null && staff.getId() == id) {
                log.info("Successfully login of staffId: {}",id);
                responseModal.setResponseCode(Constants.SUCCESS_RESPONSE_CODE.value);
                responseModal.setResponseMessage("Login Successful");
                responseModal.setResponseData(staff);
            }else{
                log.info("staff with id: {} unable to login",id);
                responseModal.setResponseCode(Constants.FAIL_RESPONSE_CODE.value);
                responseModal.setResponseMessage("Unable to login");
                responseModal.setResponseData("{}");
            }
        }catch (NullPointerException e) {
            log.info("NullPointerException while login staff: {} {} {}",id,e.getMessage(),e);
            errorResponse.setResponse(responseModal);
        }catch (Exception e) {
            log.info("Exception while login staff: {} {}",id,e.getMessage());
            errorResponse.setResponse(responseModal);
        }
    }
}
