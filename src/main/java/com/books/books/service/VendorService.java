package com.books.books.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import com.books.books.dto.VendorDto.*;
import com.books.books.model.*;
import com.books.books.repository.VendorRepository;

import lombok.SneakyThrows;
import lombok.val;

@Service
public class VendorService {
    @Autowired
    private VendorRepository vendorRepository;

	// createBook
    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> createVendor(CreateVendor dto){
        HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		Map<String, Object> res = new HashMap<String, Object>();

		Vendor vendor = new Vendor();

		vendor.setVendor_name(dto.getVendor_name());
        vendor.setContact_person(dto.getContact_person());
        vendor.setEmail(dto.getEmail());
        vendor.setAddress(dto.getAddress());
        vendor.setPhone(dto.getPhone());
        vendor.setStatus(dto.getStatus());
        vendor.setIs_deleted(0);

		vendorRepository.save(vendor);

		res.put("code", HttpStatus.CREATED.value());
		res.put("message", "success");
		res.put("data",vendor);

        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(res);
    }
	
	// updateBook
    // @SneakyThrows(Exception.class)
    // public ResponseEntity<Object> updateVendor(UpdateVendor dto){
    //     HttpHeaders headers = new HttpHeaders();
	// 	headers.setContentType(MediaType.APPLICATION_JSON);

	// 	Map<String, Object> res = new HashMap<String, Object>();

	// 	val vendor = vendorRepository.getId(dto.getId());

    //     if(Optional.ofNullable(vendor).isPresent()){            
    //         vendor.setVendor_name(dto.getVendor_name());
    //         vendor.setContact_person(dto.getContact_person());
    //         vendor.setEmail(dto.getEmail());
    //         vendor.setAddress(dto.getAddress());
    //         vendor.setPhone(dto.getPhone());
    //         vendor.setStatus(dto.getStatus());
    //         vendor.setIs_deleted(dto.getIs_deleted());

    //         vendorRepository.save(vendor);
    
    //         res.put("message", "success");
    //         res.put("data", vendor);
    //     } else {
    //         res.put("message", "failed");
    //         res.put("data", null);
    //     }

    //     res.put("code", HttpStatus.OK.value());

    //     return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(res);
    // }

	// getBook
    @SneakyThrows(Exception.class)
	public ResponseEntity<Object> getVendor(Integer id) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		Map<String, Object> res = new HashMap<String, Object>();

		val aVendor = vendorRepository.findById(id);

		if (Optional.ofNullable(aVendor).isPresent()) {
			res.put("message", "success");
			res.put("data", aVendor);
		} else {
			res.put("message", "failed");
			res.put("data", null);
		}

		res.put("code", HttpStatus.OK.value());

		return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(res);
	}

	// getBooks
	@SneakyThrows(Exception.class)
	public ResponseEntity<Object> getVendors() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		Map<String, Object> res = new HashMap<String, Object>();

		val vendors = vendorRepository.findAll();

		res.put("code", HttpStatus.OK.value());
		res.put("message", "success");
		res.put("data", vendors);

		return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(res);
	}

	// deleteBook
    // @SneakyThrows(Exception.class)
	// public ResponseEntity<Object> deleteVendor(Integer id) {

	// 	HttpHeaders headers = new HttpHeaders();
	// 	headers.setContentType(MediaType.APPLICATION_JSON);

	// 	Map<String, Object> res = new HashMap<String, Object>();

	// 	val vendor = vendorRepository.findById(id).orElse(null);

	// 	if (Optional.ofNullable(vendor).isPresent()) {

	// 		vendor.setDeleted_at(new Date());
    //         vendor.setIs_deleted(1);

    //         vendorRepository.save(vendor);

	// 		res.put("message", "success");
	// 		res.put("data", vendor);

	// 	} else {
	// 		res.put("message", "failed");
	// 		res.put("data", null);
	// 	}

	// 	res.put("code", HttpStatus.OK.value());

	// 	return ResponseEntity.status(HttpStatus.OK).headers(headers).body(res);
	// }

    
}
