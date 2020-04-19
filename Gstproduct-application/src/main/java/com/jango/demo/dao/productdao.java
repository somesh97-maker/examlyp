package com.jango.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.jango.demo.model.product;

public interface productdao extends CrudRepository<product, Integer> {

}
