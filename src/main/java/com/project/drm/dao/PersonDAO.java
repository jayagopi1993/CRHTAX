package com.project.drm.dao;

import java.util.List;

import com.project.drm.model.Person;

/**
 * 
 * @author Gopinath RM
 *
 */
public interface PersonDAO {

	public void save(Person p);
	
	public List<Person> list();
	
}