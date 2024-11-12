CREATE TABLE patients ( 
  patient_id INT PRIMARY KEY, 
  name VARCHAR(50), 
  age INT, 
  address VARCHAR(100), 
  contact_number VARCHAR(20) 
);

CREATE TABLE doctors ( 
  doctor_id INT PRIMARY KEY, 
  name VARCHAR(50), 
  specialization VARCHAR(50), 
  experience INT, 
  room_number INT 
);

CREATE TABLE appointments ( 
  appointment_id INT PRIMARY KEY, 
  patient_id INT, 
  doctor_id INT, 
  appointment_date DATE, 
  appointment_time TIMESTAMP,  
  FOREIGN KEY (patient_id) REFERENCES patients(patient_id), 
  FOREIGN KEY (doctor_id) REFERENCES doctors(doctor_id) 
);

INSERT INTO patients (patient_id, name, age, address, contact_number) 
VALUES (1, 'John Doe', 34, '143 Main St', '123-456-1111');

INSERT INTO patients (patient_id, name, age, address, contact_number) 
VALUES (2, 'Savara Khan', 22, '256 Elm St', '987-654-2222');

INSERT INTO patients (patient_id, name, age, address, contact_number) 
VALUES (3, 'Bob Ham', 60, '799 Oak St', '555-123-3333');

INSERT INTO patients (patient_id, name, age, address, contact_number) 
VALUES (4, 'Sam Brown', 35, '371 Maple St', '901-234-4444');

INSERT INTO patients (patient_id, name, age, address, contact_number) 
VALUES (5, 'Alice Doe' , 28, '991 Fine St', '111-222-5555');

INSERT INTO doctors (doctor_id, name, specialization, experience, room_number) 
VALUES (1, 'Dr. Smith', 'Cardiology', 100, 101);

INSERT INTO doctors (doctor_id, name, specialization, experience, room_number) 
VALUES (2, 'Dr. John', 'Neurology', 88, 202);

INSERT INTO doctors (doctor_id, name, specialization, experience, room_number) 
VALUES (3, 'Dr. Brown', 'Pediatrics', 54, 303);

INSERT INTO doctors (doctor_id, name, specialization, experience, room_number) 
VALUES (4, 'Dr. Davis', 'Orthopedics', 112, 404);

INSERT INTO doctors (doctor_id, name, specialization, experience, room_number) 
VALUES (5, 'Dr. Lee', 'Dermatology', 235, 505);

INSERT INTO appointments (appointment_id, patient_id, doctor_id, appointment_date, appointment_time) 
VALUES (1, 1, 1, DATE '2023-02-15', TIMESTAMP '2023-02-15 10:00:00');

INSERT INTO appointments (appointment_id, patient_id, doctor_id, appointment_date, appointment_time) 
VALUES (2, 2, 2, DATE '2023-02-16', TIMESTAMP '2023-02-16 14:00:00');

INSERT INTO appointments (appointment_id, patient_id, doctor_id, appointment_date, appointment_time) 
VALUES (3, 3, 3, DATE '2023-02-17', TIMESTAMP '2023-02-17 11:00:00');

INSERT INTO appointments (appointment_id, patient_id, doctor_id, appointment_date, appointment_time) 
VALUES (4, 4, 4, DATE '2023-02-18', TIMESTAMP '2023-02-18 16:00:00');

INSERT INTO appointments (appointment_id, patient_id, doctor_id, appointment_date, appointment_time) 
VALUES (5, 5, 5, DATE '2023-02-19', TIMESTAMP '2023-02-19 09:00:00');

INSERT INTO patients (patient_id, name, age, address, contact_number) 
VALUES (8, 'Sam Smith', 65, '545 Penny St', '777-888-6666');

INSERT INTO doctors (doctor_id, name, specialization, experience, room_number) 
VALUES (6, 'Dr. Pat', 'Oncology', 200, 606);

INSERT INTO appointments (appointment_id, patient_id, doctor_id, appointment_date, appointment_time) 
VALUES (6, 6, 6, DATE '2023-02-20', TIMESTAMP '2023-02-20 13:30:00');

SELECT p.name, d.name 
FROM patients p 
JOIN appointments a ON p.patient_id = a.patient_id 
JOIN doctors d ON a.doctor_id = d.doctor_id;

SELECT d.name, COUNT(a.patient_id) AS num_patients 
FROM doctors d 
JOIN appointments a ON d.doctor_id = a.doctor_id 
GROUP BY d.name;

SELECT p.name, a.appointment_date, a.appointment_time 
FROM patients p 
JOIN appointments a ON p.patient_id = a.patient_id;

