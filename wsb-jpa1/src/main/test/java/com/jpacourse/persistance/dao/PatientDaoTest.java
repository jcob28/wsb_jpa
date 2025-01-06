package com.jpacourse.persistance.dao;

import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.dao.VisitDao;
import com.jpacourse.persistence.entity.PatientEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;
    @Autowired
    private VisitDao visitDao;

    @Transactional
    @Test
    public void testShouldAddVisitToPatient() {
        // given
        assertThat(patientDao.findOne(7L).getVisits()).isEmpty();
        // when
        patientDao.addVisitToPatient(7L, 1L, LocalDateTime.now(), "test");
        // then
        PatientEntity patientEntity = patientDao.findOne(7L);
        assertThat(patientEntity.getVisits().size()).isEqualTo(1);
        assertThat(visitDao.findOne(patientEntity.getVisits().get(0).getId())).isNotNull();
    }

}