package com.hospitalmanagement.hospitalmanagement.controller;

import com.hospitalmanagement.hospitalmanagement.entity.Patient;
import com.hospitalmanagement.hospitalmanagement.responsemodel.ResponseModal;
import com.hospitalmanagement.hospitalmanagement.service.patientservice.PatientService;
import com.hospitalmanagement.hospitalmanagement.utils.ErrorResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    @Autowired
    PatientService patientService;
    @Autowired
    ErrorResponse errorResponse;
    public static final Logger log = LogManager.getLogger(PatientController.class);
    @PostMapping("/admit")
    public ResponseModal admitPatient(@RequestBody Patient patient) {
        log.info("Patient admitting request");
        ResponseModal responseModal = new ResponseModal();
        try {
            patientService.admitPatient(patient, responseModal);
        }catch (NullPointerException e) {
            log.info("NullPointerException while admitting patient: {} {} {}",patient.getName(),e.getMessage(),e);
            errorResponse.setResponse(responseModal);
        }catch (Exception e) {
            log.info("Exception while admitting patient: {} {} ",patient.getName(),e.getMessage());
            errorResponse.setResponse(responseModal);
        }
        return responseModal;
    }

    @GetMapping("/patients")
    public ResponseModal getAllAdmittedPatients() {
        log.info("Fetch admitted patients request");
        ResponseModal responseModal = new ResponseModal();
        try {
            patientService.getAllAdmittedPatients(responseModal);
        }catch (NullPointerException e) {
            log.info("NullPointerException while fetching admitted patients: {} {}",e.getMessage(),e);
            errorResponse.setResponse(responseModal);
        }catch (Exception e) {
            log.info("Exception while fetching admitted patients: {}",e.getMessage());
            errorResponse.setResponse(responseModal);
        }
        return responseModal;
    }

    @PutMapping("/discharge/{patientId}")
    public ResponseModal dischargePatient(@PathVariable Long patientId) {
        log.info("Patient Discharge request");
        ResponseModal responseModal = new ResponseModal();
        try {
            patientService.dischargePatient(patientId, responseModal);
        }catch (NullPointerException e) {
            log.info("NullPointerException for discharge patient with id: {} {} {}",patientId,e.getMessage(),e);
            errorResponse.setResponse(responseModal);
        }catch (Exception e) {
            log.info("Exception for discharge patient with id: {} {}",patientId,e.getMessage());
            errorResponse.setResponse(responseModal);
        }
        return responseModal;
    }
}
