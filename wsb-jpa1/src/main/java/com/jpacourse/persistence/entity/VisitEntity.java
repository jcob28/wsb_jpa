package com.jpacourse.persistence.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	@Column(nullable = false)
	private LocalDateTime time;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "PATIENT_ID", nullable = false)
	/* Relacja dwustronna z PatientEntity.
   Jedna wizyta jest powiązana z jednym pacjentem,
   ale pacjent może mieć wiele wizyt. Kontrola relacji jest po stronie VisitEntity. */
	private PatientEntity patientEntity;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "DOCTOR_ID", nullable = false)
	/* Relacja dwustronna z DoctorEntity.
   Jedna wizyta jest powiązana z jednym lekarzem,
   ale lekarz może mieć wiele wizyt. Kontrola relacji jest po stronie VisitEntity. */
	private DoctorEntity doctorEntity;

	@ManyToMany
	@JoinTable(
			name = "visit_treatment",
			joinColumns = @JoinColumn(name = "visit_id"),
			inverseJoinColumns = @JoinColumn(name = "treatment_id")
	)
	/* Relacja dwustronna z MedicalTreatmentEntity.
   Jedna wizyta może mieć wiele zabiegów, a jeden zabieg może być powiązany z wieloma wizytami.
   Kontrola relacji jest po stronie VisitEntity. */
	private List<MedicalTreatmentEntity> treatments;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public PatientEntity getPatientEntity() {
		return patientEntity;
	}

	public void setPatientEntity(PatientEntity patientEntity) {
		this.patientEntity = patientEntity;
	}

	public DoctorEntity getDoctorEntity() {
		return doctorEntity;
	}

	public void setDoctorEntity(DoctorEntity doctorEntity) {
		this.doctorEntity = doctorEntity;
	}

	public List<MedicalTreatmentEntity> getTreatments() {
		return treatments;
	}

	public void setTreatments(List<MedicalTreatmentEntity> treatments) {
		this.treatments = treatments;
	}
}
