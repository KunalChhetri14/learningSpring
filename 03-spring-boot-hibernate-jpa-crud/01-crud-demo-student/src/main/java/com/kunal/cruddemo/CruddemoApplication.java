package com.kunal.cruddemo;

import com.kunal.cruddemo.dao.StudentDAO;
import com.kunal.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class  CruddemoApplication {

	public static void main(String[] args) {

    System.out.println("Application started");
    SpringApplication.run(CruddemoApplication.class, args);
	}

  @Bean
  public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
    return runner -> {
//      createStudent(studentDAO);
      displayAllStudents(studentDAO);
      displayByLastName(studentDAO, "sharama");
    };
  }

  private void displayByLastName(StudentDAO studentDAO, String lastName) {
    List<Student> students = studentDAO.findByLastName(lastName);
    System.out.println("Student details with last Name "+ lastName +"  are:");
    students.forEach(item -> {
      System.out.println(item.toString());
    });
  }

  private void displayAllStudents(StudentDAO studentDAO) {
    List<Student> students = studentDAO.findAll();
    System.out.println("Student details are:");
    students.forEach(item -> {
      System.out.println(item.toString());
    });
  }

  private void createStudent(StudentDAO studentDAO) {

    //create the student object
    System.out.println("Creating new student objects");

    Student theStudent = new Student("Samundra", "sharama", "samundra@gmail.com");

    //save the student object
    studentDAO.save(theStudent);

    //display the id of save student
    System.out.println("Saved student. Generated id: "+theStudent.getId());

    System.out.println("Retrieving student with id: "+ theStudent.getId());

    Student studentDetails = studentDAO.findById(1);

    System.out.println(studentDetails.toString());
  }

}
