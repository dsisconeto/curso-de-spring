package com.dsisconeto.learging.post;

import com.dsisconeto.learging.study.reading.Checkpoint;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class PostCheckpoint extends Post {

    @OneToOne
    private Checkpoint checkpoint;


    @Override
    public String getBody() {
        return "bLÁ BLÁ";
    }
}
