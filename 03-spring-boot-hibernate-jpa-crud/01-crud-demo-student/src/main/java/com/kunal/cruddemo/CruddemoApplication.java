package com.kunal.cruddemo;

import com.kunal.cruddemo.dao.StudentDAO;
import com.kunal.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class  CruddemoApplication {

	public static void main(String[] args) {

    System.out.println("Application started");
    SpringApplication.run(CruddemoApplication.class, args);
	}

  @Bean
  public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
    return runner -> {
      createStudent(studentDAO);
    };
  }

  private void createStudent(StudentDAO studentDAO) {

    //create the student object
    System.out.println("Creating new student objects");

    Student theStudent = new Student("Kunal", "Chhetri", "kunalchhetri14@gmail.com");

    //save the student object
    studentDAO.save(theStudent);

    //display the id of save student
    System.out.println("Saved student. Generated id: "+theStudent.getId());
  }

}
