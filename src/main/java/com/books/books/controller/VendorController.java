package com.books.books.controller;

import com.books.books.dto.VendorDto.*;
import com.books.books.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import lombok.SneakyThrows;
// import io.swagger.annotations.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/vendor")
// @Api("REST API Documentation for Library Project")
// @ApiResponses(value = { 
//     @ApiResponse(code = 200, message = "Successfully retrieve the data!"),
//     @ApiResponse(code = 201, message = "Successfully create a book!"),
//     @ApiResponse(code = 401, message = "You are not authorized!"),
//     @ApiResponse(code = 403, message = "Forbidden data."),
//     @ApiResponse(code = 404, message = "Data has been deleted or not exist."),
//     @ApiResponse(code = 500, message = "Server Error") 
// })
// @ApiOperation(value = "An API for Books", produces = MediaType.APPLICATION_JSON_VALUE)

public class VendorController {
    @Autowired
    private VendorService vendorService;

    @SneakyThrows(Exception.class)
    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getVendor(@PathVariable(value="id") Integer id){
        log.info("GET http://localhost:8080/api/v1/vendor/{} is called", id);
		return vendorService.getVendor(id);
    }

    //POST
    @SneakyThrows(Exception.class)
    @PostMapping(value = "/add")
    public ResponseEntity<Object> createVendor(@RequestBody CreateVendor dto){
        log.info("POST http://localhost:8080/api/v1/vendor/add is called");
        return vendorService.createVendor(dto);
    }

    //PUT
    @SneakyThrows(Exception.class)
    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateVendor(@RequestBody UpdateVendor dto){
        log.info("PUT http://localhost:8080/api/v1/vendor/{} is called");
        return vendorService.updateVendor(dto);
    }
    //DELETE
    @SneakyThrows(Exception.class)
    @DeleteMapping(value = "/delete/{id_vendor}")
    public ResponseEntity<Object> deleteVendor(@PathVariable(name = "id") Integer id){
        log.info("DELETE http://localhost:8080/api/v1/vendor/delete/{} is called", id);
        return vendorService.deleteVendor(id);
    }
    //GETALL
    @SneakyThrows(Exception.class)
    @GetMapping(value = "/")
    public ResponseEntity<Object> getBooks(){
        log.info("GET http://localhost:8080/api/v1/vendor/ is called");
		return vendorService.getVendors();
    }
}

