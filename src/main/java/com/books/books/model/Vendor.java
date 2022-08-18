package com.books.books.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import org.springframework.data.annotation.*;

import org.springframework.data.mongodb.core.mapping.*;

//Annotations
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Vendor")

//class
public class Vendor {
    @Id private int id;
    private String vendor_name;
    private String contact_person;
    private String email;
    private String address;
    private Integer phone;
    private String status;
    private Date deleted_at;
    private Integer is_deleted;
}