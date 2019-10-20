package com.dsisconeto.learging.study.reading;

import com.dsisconeto.learging.student.Student;
import com.dsisconeto.learging.study.Study;
import com.dsisconeto.learging.study.reading.book.Book;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Reading extends Study {

    @ManyToOne
    private Book book;
    @ManyToOne
    private Student student;
    @OneToMany
    private List<Checkpoint> checkpoints;


    public List<Checkpoint> getCheckpoints() {
        return checkpoints;
    }

    public void setCheckpoints(List<Checkpoint> checkpoints) {
        this.checkpoints = checkpoints;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
