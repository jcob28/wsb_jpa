-- Insert data into ADDRESS table
INSERT INTO ADDRESS (city, address_line1, address_line2, postal_code)
VALUES
    ('Little Whinging', '4 Privet Drive', NULL, 'CR3 0AA'),
    ('Hampstead', '9 Heathgate', NULL, 'NW3 7TP'),
    ('Ottery St Catchpole', 'The Burrow', NULL, 'EX11 1RQ'),
    ('Hogsmeade', 'Hogwarts School of Witchcraft and Wizardry', NULL, 'HS2 3ZZ'),
    ('Hogsmeade', 'Snape’s Cottage', 'Spinner’s End', 'HS2 2AA'),
    ('Ottery St Catchpole', 'Lovegood House', NULL, 'EX11 1RQ'),
    ('Hogsmeade', 'Pomfrey’s House', 'NULL', 'HS2 2AB'),
    ('Warsaw', 'Hoza 1', NULL, '00-500');


-- Insert data into PATIENT table
INSERT INTO PATIENT (first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id, gender, version)
VALUES
    ('Harry', 'Potter', '123456789', 'harry.potter@hogwarts.com', 'P001', '1980-07-31', 1, 'MALE', 0),
    ('Hermione', 'Granger', '987654321', 'hermione.granger@hogwarts.com', 'P002', '1979-09-19', 2, 'FEMALE', 0),
    ('Ronald', 'Weasley', '456789123', 'ronald.weasley@hogwarts.com', 'P003', '1980-03-01', 3, 'MALE',0 ),
    ('Neville', 'Longbottom', '111222333', 'neville.longbottom@hogwarts.com', 'P005', '1980-07-30', 4, 'MALE',0 ),
    ('Luna', 'Lovegood', '987123654', 'luna.lovegood@hogwarts.com', 'P006', '1981-02-13', 6, 'FEMALE',0 ),
    ('Jan', 'Kowalski', '1112213432', 'jan.lovegood@hogwarts.com', 'P007', '1981-02-13', 8, 'MALE', 0);

-- Insert data into DOCTOR table
INSERT INTO DOCTOR (first_name, last_name, telephone_number, email, doctor_number, specialization, address_id)
VALUES
    ('Poppy', 'Pomfrey', '222333444', 'poppy.pomfrey@hogwarts.com', 'D001', 'MAGIC', 7),
    ('Albus', 'Dumbledore', '111222333', 'albus.dumbledore@hogwarts.com', 'D002', 'MAGIC', 4),
    ('Severus', 'Snape', '444555666', 'severus.snape@hogwarts.com', 'D003', 'MAGIC', 5);

-- Insert data into VISIT table
INSERT INTO VISIT (description, time, doctor_id, patient_id)
VALUES
    ('Treatment for cursed wound', '2024-01-10 09:00:00', 1, 1),
    ('Follow-up after Polyjuice mishap', '2024-01-15 11:00:00', 2, 2),
    ('Burn healing from a magical fire', '2024-01-20 14:00:00', 1, 3),
    ('Concussion from Quidditch accident', '2024-02-05 10:00:00', 1, 4),
    ('Allergic reaction to Mandrake leaves', '2024-02-15 13:00:00', 3, 5),
    ('Headache from Wrackspurt infestation', '2024-03-01 12:00:00', 1, 5),
    ('Headache from Wrackspurt infestation - Continuation', '2024-04-01 09:00:00', 2, 5);


-- Insert data into MEDICAL_TREATMENT table
INSERT INTO MEDICAL_TREATMENT (description, type)
VALUES
    ('Application of Dittany for wound healing', 'Potion'),
    ('Potion for reversing Polyjuice effects', 'Potion'),
    ('Burn-soothing salve treatment', 'Salve'),
    ('Concussion-recovery potion', 'Potion'),
    ('Mandrake extract antidote', 'Potion'),
    ('Therapy for Wrackspurt removal', 'Therapy');

-- Link data between VISIT and MEDICAL_TREATMENT tables
INSERT INTO visit_treatment (visit_id, treatment_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5),
    (6, 6);
