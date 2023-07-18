# hospitalManagement
Hospital Management for staff signup, login &amp; patients admit &amp; discharge


Spring Boot web application that provides REST APIs for hospital staff to signup/login, admit new patients, fetch all admitted patients, and discharge patients from the hospital. 

Test the api's by importing below collection in Postman - 
https://api.postman.com/collections/21017757-1d2f3ff4-c958-4079-bbee-7fdbc391d6f6?access_key=PMAT-01H5M1AQ0ZK3D029AFJDS1DMF9

Make sure to connect postgreSQL, create database hospital_db, following by creation of tables - staff & patient.

Under Staff Controller -
/staff/signup - Signs up the staff with username & password
/staff/login - logins staff when provided staff id.

Under Patient Controller - 
/patient/admit - admits patient with name, age, doctorname, expenses, admitdate & status in database.
/patient/patients - fetches list of patients which are admitted in hospital
/patient/discharge/{patientId} - discharges patient & set it's status to discharged in database.
