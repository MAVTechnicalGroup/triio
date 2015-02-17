package org.mavtechnicalgroup.triio.web;

import org.mavtechnicalgroup.triio.data.TraditionalFamilyMember;
import org.mavtechnicalgroup.triio.data.Date;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.mavtechnicalgroup.triio.App;
import org.mavtechnicalgroup.triio.data.TraditionalFamilyMember;

@RestController
public class WebController {
	
	//TODO: Modify value to include the tree's UID; modify traditionalTreeFunction.js as well
	@RequestMapping(value = "/tree/traditional/", method = RequestMethod.POST)
	void addUser(@RequestParam("firstName") String fn, @RequestParam("lastName") String ln,
				 @RequestParam("middleName") String mn, @RequestParam("gender") String gen,
				 @RequestParam("dd") int day, @RequestParam("mm") int month, @RequestParam("yyyy") int year) {
		TraditionalFamilyMember member = new TraditionalFamilyMember(fn, ln, mn, gen, new Date(day, month, year));
		//tree.add(member);
	}
	
	//@RequestMapping(value = "/tree/fraternity/", method = RequestMethod.POST)
	
}
