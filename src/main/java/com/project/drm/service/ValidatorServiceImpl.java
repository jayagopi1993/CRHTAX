package com.project.drm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.drm.dao.PersonDAO;
import com.project.drm.model.Person;
/**
 * 
 * @author Gopinath RM
 *
 */
@Service
public class ValidatorServiceImpl implements ValidatorService {

	@Autowired
	private PersonDAO personDAO;
	
	public boolean validateInputExcelsObject(Person person) throws Exception {
		if (null != person) {
			personDAO.save(person);
			return true;
		} else {
			return false;
		}
	}

}
