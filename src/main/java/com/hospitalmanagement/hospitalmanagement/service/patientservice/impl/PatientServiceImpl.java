package com.hospitalmanagement.hospitalmanagement.service.patientservice.impl;

import com.hospitalmanagement.hospitalmanagement.entity.Patient;
import com.hospitalmanagement.hospitalmanagement.repository.PatientRepository;
import com.hospitalmanagement.hospitalmanagement.responsemodel.ResponseModal;
import com.hospitalmanagement.hospitalmanagement.service.patientservice.PatientService;
import com.hospitalmanagement.hospitalmanagement.utils.Constants;
import com.hospitalmanagement.hospitalmanagement.utils.ErrorResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    ErrorResponse errorResponse;

    public static final Logger log = LogManager.getLogger(PatientServiceImpl.class);

    // Admit New Patient
    @Override
    public void admitPatient(Patient patient, ResponseModal responseModal) {
        log.info("Admitting patient: {}",patient.getName());
        try {
            patient.setAdmitdate(new Date());
            patient.setStatus("admitted");
            patientRepository.save(patient);
            log.info("Successfully admitted patient: {}",patient.getName());
            responseModal.setResponseCode(Constants.SUCCESS_RESPONSE_CODE.value);
            responseModal.setResponseMessage("Admitted successfully");
            responseModal.setResponseData(patient.getId());
        }catch (NullPointerException e) {
            log.info("NullPointerException while admitting patient: {} {} {}",patient.getName(),e.getMessage(),e);
            errorResponse.setResponse(responseModal);
        }catch (Exception e) {
            log.info("Exception while admitting patient: {} {} ",patient.getName(),e.getMessage());
            errorResponse.setResponse(responseModal);
        }
    }

    // Fetch All Admitted Patients
    @Override
    public void getAllAdmittedPatients(ResponseModal responseModal) {
        log.info("Fetching admitted patients");
        try {
            List<Patient> patients = patientRepository.findByStatus("admitted");
            if (patients.size() > 0) {
                log.info("Admitted patients count: {}",patients.size());
                responseModal.setResponseCode(Constants.SUCCESS_RESPONSE_CODE.value);
                responseModal.setResponseMessage(Constants.SUCCESS_RESPONSE_MESSAGE.value);
                responseModal.setResponseData(patients);
            }else{
                log.info("No patient is admitted");
                responseModal.setResponseCode(Constants.SUCCESS_RESPONSE_CODE.value);
                responseModal.setResponseMessage("Zero patient admitted");
                responseModal.setResponseData("{}");
            }
        }catch (NullPointerException e) {
            log.info("NullPointerException while fetching admitted patients: {} {}",e.getMessage(),e);
            errorResponse.setResponse(responseModal);
        }catch (Exception e) {
            log.info("Exception while fetching admitted patients: {}",e.getMessage());
            errorResponse.setResponse(responseModal);
        }
    }

    // Discharge Patient
    @Override
    public void dischargePatient(Long patientId, ResponseModal responseModal) {
        log.info("Discharging patient with id: {}",patientId);
        try {
            Patient patient = patientRepository.findById(patientId).orElse(null);
            if (patient != null) {
                patient.setStatus("discharged");
                patientRepository.save(patient);
                log.info("Discharged patient with id: {} successfully",patientId);
                responseModal.setResponseCode(Constants.SUCCESS_RESPONSE_CODE.value);
                responseModal.setResponseMessage(Constants.SUCCESS_RESPONSE_MESSAGE.value);
                responseModal.setResponseData("Patient discharged successfully");
            }else{
                log.info("Patient not found with id: {}",patientId);
                responseModal.setResponseCode(Constants.SUCCESS_RESPONSE_CODE.value);
                responseModal.setResponseMessage("Patient not found");
                responseModal.setResponseData("{}");
            }

            /* Alternatively, we can execute update query

            int rowsUpdated = patientRepository.updatePatientStatus(patientId, "discharged");
            if (rowsUpdated > 0) {
                log.info("Patient with id: {} discharged successfully",patientId);
                responseModal.setResponseCode(Constants.SUCCESS_RESPONSE_CODE.value);
                responseModal.setResponseMessage(Constants.SUCCESS_RESPONSE_MESSAGE.value);
                responseModal.setResponseData("Patient discharged successfully");
            } else {
                log.info("Patient not found with id: {}",patientId);
                responseModal.setResponseCode(Constants.SUCCESS_RESPONSE_CODE.value);
                responseModal.setResponseMessage("Patient not found");
                responseModal.setResponseData("{}");
            }

             */
        }catch (NullPointerException e) {
            log.info("NullPointerException while discharging patient with id: {} {} {}",patientId,e.getMessage(),e);
            errorResponse.setResponse(responseModal);
        }catch (Exception e) {
            log.info("NullPointerException while discharging patient with id: {} {} {}",patientId,e.getMessage(),e);
            errorResponse.setResponse(responseModal);
        }

    }
}
