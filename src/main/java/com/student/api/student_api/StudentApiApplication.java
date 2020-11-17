package com.student.api.student_api;

import com.student.api.student_dto.StudentDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class StudentApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		getStudentDetails(2);

		StudentDTO student = new StudentDTO();
		student.setName("Ritovash Mazumder");
		student.setDept("CSE");
		student.setAge(21);

		addStudent(student);
	}

	public void getStudentDetails(Integer studentId){
		String url = "http://localhost:8000/api/student/{studentID}";
		RestTemplate restTemplate = new RestTemplate();
		StudentDTO studentDTO = restTemplate.getForObject(url, StudentDTO.class, studentId);
		System.out.println(studentDTO);
	}

	public void addStudent(StudentDTO studentDTO){
		String url = "http://localhost:8000/api/student/";
		RestTemplate restTemplate = new RestTemplate();
		StudentDTO addedStudent = restTemplate.postForObject(url, studentDTO, StudentDTO.class);
		System.out.println(addedStudent);
	}
}
