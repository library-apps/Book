package com.books.books.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class VendorDto {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateVendor{
        private String vendor_name;
        private String contact_person;
        private String email;
        private String address;
        private Integer phone;
        private String status;
        private Date deleted_at;
        private Integer is_deleted;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UpdateVendor{
        private String id;
        private String vendor_name;
        private String contact_person;
        private String email;
        private String address;
        private Integer phone;
        private String status;
        private Date deleted_at;
        private Integer is_deleted;
    }
}
