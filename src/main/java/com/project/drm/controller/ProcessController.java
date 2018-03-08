package com.project.drm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.drm.constant.PortalConstants;
import com.project.drm.model.AppResponse;
import com.project.drm.model.Person;
import com.project.drm.service.ValidatorService;

/**
 * 
 * @author Gopinath RM
 *
 */
@RestController
@RequestMapping("/repository")
public class ProcessController {

	@Autowired
	private ValidatorService validatorService;

	@RequestMapping(value = "/post/person", method = RequestMethod.POST)
	public AppResponse processInputExcels(@RequestBody Person person) {

		AppResponse appResponse = new AppResponse();
		try {
			if (validatorService.validateInputExcelsObject(person)) {
				appResponse.setResponseCode(PortalConstants.HTTP_CODE_SUCCESS);
				appResponse.setResponseMessage("Excels submitted for Process!!");
				return appResponse;
			} else {
				appResponse.setResponseCode(PortalConstants.HTTP_CODE_INVALID_INPUT);
				appResponse.setResponseMessage("Invalid Excels submitted please upload valid excels!!");
				return appResponse;
			}
		} catch (Exception e) {
			appResponse.setResponseCode(PortalConstants.HTTP_CODE_ERROR);
			appResponse.setResponseMessage("Sorry, Something went wrong. Try later!!");
			return appResponse;
		}
	}

	@RequestMapping(value = "/get/person", method = RequestMethod.GET)
	public AppResponse storeInputExcels() {
		AppResponse appResponse = new AppResponse();
		try {
			Person person = new Person();
			if (validatorService.validateInputExcelsObject(person)) {
				appResponse.setResponseCode(PortalConstants.HTTP_CODE_SUCCESS);
				appResponse.setResponseMessage("Excels submitted for Process!!");
				return appResponse;
			} else {
				appResponse.setResponseCode(PortalConstants.HTTP_CODE_INVALID_INPUT);
				appResponse.setResponseMessage("Invalid Excels submitted please upload valid excels!!");
				return appResponse;
			}
		} catch (Exception e) {
			appResponse.setResponseCode(PortalConstants.HTTP_CODE_ERROR);
			appResponse.setResponseMessage("Sorry, Something went wrong. Try later!!");
			return appResponse;
		}
	}

}
