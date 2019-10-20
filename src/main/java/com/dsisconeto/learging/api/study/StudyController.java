package com.dsisconeto.learging.api.study;

import com.dsisconeto.learging.common.NotFoundEntityException;
import com.dsisconeto.learging.student.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;


@RestController
@RequestMapping("/estudantes")
public class StudyController {

    private StudentService studentService;
    private IStudentRepository studentRepository;

    public StudyController(StudentService studentService, IStudentRepository studentRepository) {
        this.studentService = studentService;
        this.studentRepository = studentRepository;
    }


    @GetMapping
    public Page<ResponseDTO> list(
            @PageableDefault(sort = "createdAt", direction = Sort.Direction.ASC) Pageable pageable
    ) {
        return studentRepository.findAll(pageable)
                .map(ResponseDTO::new);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ResponseDTO> store(
            @RequestBody @Valid StoreRequestDTO dto,
            UriComponentsBuilder uriBuilder
    ) {
        Student student = studentService.store(dto);

        URI uri = uriBuilder
                .path("/estudantes/{id}")
                .buildAndExpand(student.getId())
                .toUri();

        return ResponseEntity
                .created(uri)
                .body(new ResponseDTO(student));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> detail(@PathVariable int id) {

        try {
            Student student = studentService.getById(id);
            return ResponseEntity.ok(new ResponseDTO(student));
        } catch (NotFoundEntityException e) {
            return ResponseEntity.notFound().build();
        }

    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity update(@RequestBody UpdateRequest dto, @PathVariable int id) {
        dto.setId(id);
        try {
            studentService.update(dto);
            return ResponseEntity.noContent().build();
        } catch (NotFoundEntityException e) {
            return ResponseEntity.notFound().build();

        }
    }


    @DeleteMapping("/id")
    @Transactional
    public ResponseEntity destroy(@PathVariable int id) {

        try {
            studentService.destroy(id);
            return ResponseEntity.noContent().build();
        } catch (NotFoundEntityException e) {
            return ResponseEntity.notFound().build();
        }
    }


}
