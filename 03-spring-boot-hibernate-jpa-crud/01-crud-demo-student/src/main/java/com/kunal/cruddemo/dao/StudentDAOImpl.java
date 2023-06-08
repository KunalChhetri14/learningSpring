package com.kunal.cruddemo.dao;

import com.kunal.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {

  //define fields or entity maanger
  private EntityManager entityManager;

  //inject entity manager using constructor injection

  @Autowired
  public StudentDAOImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  //implement save methods
  @Override
  @Transactional
  public void save(Student theStudent) {
//    entityManager.setProperty("hibernate.default_schema", "student_schema");
    entityManager.persist(theStudent);
  }
}
