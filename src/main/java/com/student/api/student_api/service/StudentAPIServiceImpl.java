package com.student.api.student_api.service;

import com.student.api.student_api.student_dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service(value="studentAPIService")
public class StudentAPIServiceImpl implements StudentAPIService{

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private Environment environment;

    @Override
    public void getStudentDetails(Integer studentId){
        String url = environment.getProperty("STUDENT_API.URL") + "{studentID}";
        StudentDTO studentDTO = restTemplate.getForObject(url, StudentDTO.class, studentId);
        System.out.println(studentDTO);
    }

    @Override
    public void addStudent(StudentDTO studentDTO){
        StudentDTO addedStudent = restTemplate.postForObject(environment.getProperty("STUDENT_API.URL"),
                studentDTO, StudentDTO.class);
        System.out.println(addedStudent);
    }
}
