package com.student.api.student_api.service;

import com.student.api.student_api.student_dto.StudentDTO;

public interface StudentAPIService {
    void getStudentDetails(Integer studentId);
    void addStudent(StudentDTO studentDTO);
}
