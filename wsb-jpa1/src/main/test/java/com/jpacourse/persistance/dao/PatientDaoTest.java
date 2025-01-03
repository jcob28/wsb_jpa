package com.jpacourse.persistance.dao;

import com.jpacourse.persistence.dao.PatientDao;
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

    @Transactional
    @Test
    public void testShouldAddVisitToPatient() {
        // given
        // when
        patientDao.addVisitToPatient(1L, 1L, LocalDateTime.now(), "test");
        // then
        assertThat(patientDao.findOne(1L).getVisits().size()).isEqualTo(1);
    }

}