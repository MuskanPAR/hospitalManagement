package com.hospitalmanagement.hospitalmanagement.service.patientservice;

import com.hospitalmanagement.hospitalmanagement.entity.Patient;
import com.hospitalmanagement.hospitalmanagement.responsemodel.ResponseModal;

public interface PatientService {
    void admitPatient(Patient patient, ResponseModal responseModal);

    void getAllAdmittedPatients(ResponseModal responseModal);

    void dischargePatient(Long patientId, ResponseModal responseModal);
}
