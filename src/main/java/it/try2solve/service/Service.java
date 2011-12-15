package it.try2solve.service;

import it.try2solve.data.model.BaseModel;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mysema.query.types.Predicate;


public interface Service {

	public <T extends BaseModel> T save(T obj);

	public <T extends BaseModel> void delete(T obj);
	
	public Page<? extends BaseModel> findAll(Predicate predicate, Pageable pagable);
	
	public Page<? extends BaseModel> findAll(Pageable pagable);
	
}
