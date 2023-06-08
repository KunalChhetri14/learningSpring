package com.kunal.cruddemo.dao;

import com.kunal.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

  public Student findById(int id) {
    return entityManager.find(Student.class, 1);
  }

  @Override
  public List<Student> findAll() {
    TypedQuery<Student> theQuery= entityManager.createQuery("FROM Student where lastName='Chhetri'", Student.class);
    List<Student> students = theQuery.getResultList();
    return students;
  }
}
