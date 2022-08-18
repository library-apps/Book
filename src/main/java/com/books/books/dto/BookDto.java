package com.books.books.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class BookDto {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateBook{
        private String title;
        private String author;
        private String summary;
        private Integer pages;
        private Integer year;
        private String vendorId;
        private String image;
        private Integer isDeleted;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UpdateBook{
        private Integer id;
        private String title;
        private String author;
        private String summary;
        private Integer pages;
        private Integer year;
        private String vendorId;
        private String image;
        private Date deletedAt;
        private Integer isDeleted;
    }


}
