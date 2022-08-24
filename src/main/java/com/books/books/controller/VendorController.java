package com.books.books.controller;

import com.books.books.dto.VendorDto.*;
import com.books.books.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import lombok.SneakyThrows;
// import org.springframework.security.access.prepost.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/vendor")
public class VendorController {
    @Autowired
    private VendorService vendorService;

    // @SneakyThrows(Exception.class)
    // @GetMapping(value = "/{id}")
    // public ResponseEntity<Object> getVendor(@PathVariable(value="id") String id){
    //     log.info("GET http://localhost:8098/api/v1/vendor/{} is called", id);
	// 	return vendorService.getVendor(id);
    // }

    @SneakyThrows(Exception.class)
    @PostMapping(value = "/add")
    // @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> createVendor(@RequestBody CreateVendor dto){
        log.info("POST http://localhost:8098/api/v1/vendor/add is called");
        return vendorService.createVendor(dto);
    }

    //PUT
    // @SneakyThrows(Exception.class)
    // @PutMapping(value = "/{id}")
    // public ResponseEntity<Object> updateVendor(@RequestBody UpdateVendor dto){
    //     log.info("PUT http://localhost:8098/api/v1/vendor/{} is called");
    //     return vendorService.updateVendor(dto);
    // }
    //DELETE
    // @SneakyThrows(Exception.class)
    // @DeleteMapping(value = "/delete/{id_vendor}")
    // public ResponseEntity<Object> deleteVendor(@PathVariable(name = "id") Integer id){
    //     log.info("DELETE http://localhost:8098/api/v1/vendor/delete/{} is called", id);
    //     return vendorService.deleteVendor(id);
    // }
    //GETALL
    @SneakyThrows(Exception.class)
    @GetMapping(value = "/")
    public ResponseEntity<Object> getBooks(){
        log.info("GET http://localhost:8098/api/v1/vendor/ is called");
		return vendorService.getVendors();
    }
}

