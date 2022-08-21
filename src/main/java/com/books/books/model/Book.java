package com.books.books.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

// import org.bson.types.ObjectId;
import org.springframework.data.annotation.*;

import org.springframework.data.mongodb.core.mapping.*;

//Annotations
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="Book")

//class
public class Book {
    @Id
    private String id;
    private String title;
    private String author;
    private String summary;
    private Integer pages;
    private Integer year;
    private String vendor_id;
    private String image;
    private Date deleted_at;
    private Integer is_deleted;

    // public ObjectId getId(String string) {
    //     return id;
    // }
}
