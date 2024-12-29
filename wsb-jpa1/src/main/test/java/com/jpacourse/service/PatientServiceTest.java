package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.service.impl.PatientServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientDao patientDao;

    @Transactional
    @Test
    public void testShouldDeletePatientAndCascadingVisits() {
        // given
        PatientEntity pagtientEntity = patientDao.findOne(1L);
        assertThat(pagtientEntity).isNotNull();
        assertThat(pagtientEntity.getVisits()).isNotEmpty();

        // when
        patientService.delete(pagtientEntity.getId());

        // then
        assertThat(patientDao.findOne(1L)).isNull();
    }

    @Test
    public void testShouldNotDeleteDoctors() {
        // given
        PatientEntity pagtientEntity = patientDao.findOne(1L);
        assertThat(pagtientEntity).isNotNull();
        assertThat(pagtientEntity.getVisits()).isNotEmpty();

        // when
        patientService.delete(pagtientEntity.getId());

        // then
        assertThat(patientDao.findOne(1L)).isNull();
        assertThat(doctorDao.findOne(1L)).isNotNull();
    }

    @Transactional
    @Test
    public void testShouldFindPatientById() {
        // given

        // when
        PatientTO patientTO = patientService.findById(1L);

        // then
        assertThat(patientTO).isNotNull();
        assertThat(patientTO.getFirstName()).isEqualTo("Jan");
        assertThat(patientTO.getLastName()).isEqualTo("Kowalski");
        assertThat(patientTO.getBirthDate()).isEqualTo("1990-01-01");
    }
}