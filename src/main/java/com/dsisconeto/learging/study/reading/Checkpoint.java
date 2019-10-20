package com.dsisconeto.learging.study.reading;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Checkpoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int page;
    private LocalDateTime createdAt;

    @ManyToOne
    private Reading reading;

    public int getId() {
        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public LocalDateTime getCreatedAt() {

        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {

        this.createdAt = createdAt;
    }
}
