package com.jango.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jango.demo.dao.productdao;
import com.jango.demo.model.product;


@RestController
public class productcontroller {
	@Autowired
	private productdao dao;
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(method=RequestMethod.POST,value="/pdt")
	 public String newproduct(@RequestBody product pro)
	 {
		 dao.save(pro);
		 return "product stored";
	 }
	 
	@GetMapping("/pdt")
	public List<product> getProducts()
	 {
		 return (List<product>) dao.findAll();
	 }
	 
	 @GetMapping("/pdt/{id}")
	 public Optional<product> getonep(@PathVariable int id)
	 {
		 return(dao.findById(id));
	 }
	 
	 @PutMapping("/pdt")
	 public String updateproduct(@RequestBody product pro)
	 {
		 dao.save(pro);
		 return "product updated";
	 }
	 
	 @DeleteMapping("/pdt/{id}")
	 public String deleteproduct(@PathVariable int id)
	 {
		 dao.deleteById(id);
		 return "product deleted";
	 }
}
