package com.jpacourse.mapper;
import com.jpacourse.dto.AddressTO;
import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistence.entity.AddressEntity;
import com.jpacourse.persistence.entity.MedicalTreatmentEntity;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;

import java.util.stream.Collectors;

public final class PatientMapper {

    public static PatientTO mapToTO(final PatientEntity patientEntity) {
        if (patientEntity == null) {
            return null;
        }
        final PatientTO patientTO = new PatientTO();
        patientTO.setId(patientEntity.getId());
        patientTO.setFirstName(patientEntity.getFirstName());
        patientTO.setLastName(patientEntity.getLastName());
        patientTO.setTelephoneNumber(patientEntity.getTelephoneNumber());
        patientTO.setEmail(patientEntity.getEmail());
        patientTO.setPatientNumber(patientEntity.getPatientNumber());
        patientTO.setDateOfBirth(patientEntity.getDateOfBirth());
        patientTO.setAddress(patientEntity.getAddressEntity());
        patientTO.setVisits(patientEntity.getVisits());
        patientTO.setGender(patientEntity.getGender());
        return patientTO;
    }

    /*
    public static PatientEntity mapToEntity(final PatientTO patientTO) {
        if (patientTO == null) {
            return null;
        }
        final PatientEntity patientEntity = new PatientEntity();
        patientTO.setId(patientTO.getId());
        patientTO.setFirstName(patientTO.getFirstName());
        patientTO.setLastName(patientTO.getLastName());
        patientTO.setTelephoneNumber(patientTO.getTelephoneNumber());
        patientTO.setEmail(patientTO.getEmail());
        patientTO.setPatientNumber(patientTO.getPatientNumber());
        patientTO.setDateOfBirth(patientTO.getDateOfBirth());
        patientTO.setAddress(patientTO.getAddress());
        patientTO.setVisits(patientTO.getVisits());
        patientTO.setGender(patientTO.getGender());
        return patientEntity;
    }*/

    private static VisitTO mapVisitToTO(final VisitEntity visitEntity) {
        VisitTO visitTO = new VisitTO();
        visitTO.setTime(visitEntity.getTime());
        visitTO.setDoctorName(visitEntity.getDoctorEntity().getFirstName() + " " + visitEntity.getDoctorEntity().getLastName());
        visitTO.setTreatments(visitEntity.getTreatments().stream().map(MedicalTreatmentEntity::getType).collect(Collectors.toList()));
        return visitTO;
    }
}
