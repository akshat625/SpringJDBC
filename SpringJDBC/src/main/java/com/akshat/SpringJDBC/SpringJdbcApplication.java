package com.akshat.SpringJDBC;

import com.akshat.SpringJDBC.model.Student;
import com.akshat.SpringJDBC.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

//what is the role of @SpringBootApplication?
//@SpringBootApplication is a combination of three annotations:
//@Configuration: It indicates that the class has @Bean definition methods.
//@ComponentScan: It tells Spring to scan and bootstrap other components defined in the current package (where the main class is) and all the sub-packages.
//@EnableAutoConfiguration: It tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {

		//what is the role of ApplicationContext?
		//ApplicationContext is a container for all the beans. It is responsible for instantiating, configuring, and assembling the beans.
		//It gets created at the time of application startup.
		//It is responsible for managing the beans and their dependencies.
		//It is a sub-interface of BeanFactory. It provides more enterprise-specific functionality than BeanFactory.

		//what is the role of SpringApplication?
		//SpringApplication is a class that provides support for quickly building Spring applications.
		//It provides static run method that is used to run the Spring application.
		//It performs the following tasks:
		//It sets up the default configuration.
		//It starts the Spring application context. It is a container for all the beans.

		ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);

		//what is the role of getBean() method?
		//getBean() method is used to get the bean instance from the Spring container. It takes the bean name as a parameter and returns the bean instance.
		//It is a method of the ApplicationContext interface.
		Student s = context.getBean(Student.class);
		s.setRollNo(06);
		s.setName("Akshat");
		s.setMarks(93);

		//what is the role of StudentService?
		//StudentService is a service class that provides the service of adding a student and getting the list of students.
		//It is a Spring bean and is managed by the Spring container.
		//It uses StudentRepo to save the student and get the list of students.
		StudentService service = context.getBean(StudentService.class);
		service.addStudent(s);

		List<Student> students = service.getStudent();
		System.out.println(students);
	}

}
