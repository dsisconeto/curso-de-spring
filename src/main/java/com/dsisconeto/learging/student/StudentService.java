package com.dsisconeto.learging.student;

import com.dsisconeto.learging.common.NotFoundEntityException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class StudentService {

    private final IStudentRepository studentRepository;

    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student store(IStoreRequest request) {

        Student student = new Student();
        student.setName(request.getName());
        student.setCreatedAt(LocalDateTime.now());
        studentRepository.save(student);

        return student;
    }

    public Student update(IUpdateRequest request) throws NotFoundEntityException {

        Student student = getById(request.getId());
        student.setName(request.getName());
        student.setUpdatedAt(LocalDateTime.now());

        studentRepository.save(student);

        return student;

    }


    public Student getById(int id) throws NotFoundEntityException {
        Optional<Student> student = studentRepository.findById(id);

        if (!student.isPresent()) {
            throw new NotFoundEntityException("Não foi possível encontrar o estudante");
        }

        return student.get();
    }

    public void destroy(int id) throws NotFoundEntityException {

        Student student = getById(id);
        studentRepository.delete(student);
    }

}
