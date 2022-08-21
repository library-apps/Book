package com.books.books.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.books.books.model.Vendor;

@Repository
public interface VendorRepository extends MongoRepository<Vendor, Integer> {

    // public Vendor getId(String id);
    
}
