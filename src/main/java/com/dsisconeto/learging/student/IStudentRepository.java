package com.dsisconeto.learging.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface IStudentRepository extends JpaRepository<Student, Integer> {


}
