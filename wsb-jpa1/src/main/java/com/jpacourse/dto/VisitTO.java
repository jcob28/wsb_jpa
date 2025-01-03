package com.jpacourse.dto;

import com.jpacourse.persistence.enums.TreatmentType;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class VisitTO implements Serializable {

    private LocalDateTime time;

    private String doctorName;

    private List<TreatmentType> treatment;

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public List<TreatmentType> getTreatments() {
        return treatment;
    }

    public void setTreatments(List<TreatmentType> treatments) {
        this.treatment = treatments;
    }
}