package com.student.api.student_api;

import com.student.api.student_api.service.StudentAPIService;
import com.student.api.student_api.student_dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class StudentApiApplication implements CommandLineRunner {

	@Autowired
	private StudentAPIService serstudentAPIServicevice;


	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(StudentApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		serstudentAPIServicevice.getStudentDetails(1);

		StudentDTO student = new StudentDTO();
		student.setName("Ritovash Mazumder");
		student.setDept("CSE");
		student.setAge(21);

		serstudentAPIServicevice.addStudent(student);
	}


}
