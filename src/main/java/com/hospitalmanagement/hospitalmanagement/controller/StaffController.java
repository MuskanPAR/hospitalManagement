package com.hospitalmanagement.hospitalmanagement.controller;

import com.hospitalmanagement.hospitalmanagement.entity.Staff;
import com.hospitalmanagement.hospitalmanagement.responsemodel.ResponseModal;
import com.hospitalmanagement.hospitalmanagement.service.staffservice.StaffService;
import com.hospitalmanagement.hospitalmanagement.utils.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaffController {
    @Autowired
    private StaffService staffService;
    public static final Logger log = LogManager.getLogger(StaffController.class);

    @PostMapping("/signup")
    public ResponseModal signup(@RequestBody Staff staff) {
        ResponseModal responseModal = new ResponseModal();
        log.info("Staff signup request");
        try {
            staffService.signup(staff, responseModal);
        }catch (NullPointerException e) {
            log.info("NullPointerException for signing up staff with username:{} {} {}",staff.getUsername(),e.getMessage(),e);
            responseModal.setResponseCode(Constants.FAIL_RESPONSE_CODE.value);
            responseModal.setResponseMessage(Constants.FAIL_RESPONSE_MESSAGE.value);
            responseModal.setResponseData("{}");
        }catch (Exception e) {
            log.info("Exception for signing up staff with username:{} {}",staff.getUsername(),e.getMessage());
            responseModal.setResponseCode(Constants.FAIL_RESPONSE_CODE.value);
            responseModal.setResponseMessage(Constants.FAIL_RESPONSE_MESSAGE.value);
            responseModal.setResponseData("{}");
        }
        return responseModal;
    }

    @PostMapping("/login")
    public ResponseModal login(@RequestParam long id) {
        ResponseModal responseModal = new ResponseModal();
        log.info("Staff login request");
        try {
            staffService.login(id, responseModal);
        }catch (NullPointerException e) {
            log.info("NullPointerException while login staff: {} {} {}",id,e.getMessage(),e);
            responseModal.setResponseCode(Constants.FAIL_RESPONSE_CODE.value);
            responseModal.setResponseMessage(Constants.FAIL_RESPONSE_MESSAGE.value);
            responseModal.setResponseData("{}");
        }catch (Exception e) {
            log.info("Exception while login staff: {} {} {}",id,e.getMessage());
            responseModal.setResponseCode(Constants.FAIL_RESPONSE_CODE.value);
            responseModal.setResponseMessage(Constants.FAIL_RESPONSE_MESSAGE.value);
            responseModal.setResponseData("{}");
        }
        return responseModal;
    }
}
