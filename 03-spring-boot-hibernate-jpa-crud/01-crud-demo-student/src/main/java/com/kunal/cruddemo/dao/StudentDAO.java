package com.kunal.cruddemo.dao;

import com.kunal.cruddemo.entity.Student;

import java.util.ArrayList;
import java.util.List;

public interface StudentDAO {

  void save(Student theStudent);

  Student findById(int id);

  List<Student> findAll();

  List<Student> findByLastName(String lastName);

}
