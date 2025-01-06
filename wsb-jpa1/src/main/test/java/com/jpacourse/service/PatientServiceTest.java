package com.jpacourse.service;

import com.jpacourse.persistence.dao.DoctorDao;
import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.dao.VisitDao;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PatientServiceTest {

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private PatientService patientService;

    @Autowired
    private VisitDao visitDao;

    @Autowired
    private DoctorDao doctorDao;

    @Transactional
    @Test
    public void testShouldRemovePatientAndVisitsButNotDoctors() {

        // given
        final PatientEntity patientEntity = patientDao.findOne(1L);
        assertThat(patientEntity.getVisits()).hasSize(1);
        final VisitEntity visitEntity = patientEntity.getVisits().get(0);

        Long patientId = patientEntity.getId();
        Long visitId = visitEntity.getId();
        Long doctorId = visitEntity.getDoctorEntity().getId();

        // when
        patientService.deleteById(patientId);

        // then
        assertThat(patientDao.findOne(patientId)).isNull();
        assertThat(visitDao.findOne(visitId)).isNull();
        assertThat(doctorDao.findOne(doctorId)).isNotNull();
    }

}