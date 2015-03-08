package org.mavtechnicalgroup.triio.web;

import org.mavtechnicalgroup.triio.data.TraditionalFamilyMember;
import org.mavtechnicalgroup.triio.data.TraditionalTree;
import org.mavtechnicalgroup.triio.data.Date;
import org.mavtechnicalgroup.triio.App;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.mavtechnicalgroup.triio.file.JsonFileHandler;

@RestController
public class WebController {
	
	//TODO: Modify value to include the tree's UID; modify traditionalTreeFunction.js as well
	@RequestMapping(value = "/tree/traditional/{uid}", method = RequestMethod.POST)
	void addTraditionalUser(@PathVariable("uid") String uid,
				 @RequestParam("firstName") String fn, @RequestParam("lastName") String ln,
				 @RequestParam("middleName") String mn, @RequestParam("gender") String gen,
				 @RequestParam("dd") int day, @RequestParam("mm") int month, @RequestParam("yyyy") int year) {
		TraditionalFamilyMember member = new TraditionalFamilyMember(fn, ln, mn, gen, new Date(day, month, year));
		TraditionalTree tree = (TraditionalTree) JsonFileHandler.readJsonFile(uid);
		tree.add(member);
		JsonFileHandler.writeJsonFile(tree);
	}
	
	@RequestMapping(value = "/tree/traditional/create", method = RequestMethod.POST)
	String createTraditionalTree(@RequestParam("firstName") String fn, @RequestParam("lastName") String ln,
								 @RequestParam("gender") String gen) {
		TraditionalTree tree = new TraditionalTree();
		TraditionalFamilyMember seedMember = new TraditionalFamilyMember(fn, ln, gen);
		tree.add(seedMember);
		
		JsonFileHandler.writeJsonFile(tree);
		
		return tree.getUID();
	}
	
	@RequestMapping(value = "tree/traditional/{uid}", method = RequestMethod.GET)
	ModelAndView loadTraditionalTree(@PathVariable("uid") String uid) {
		TraditionalTree tree = (TraditionalTree) JsonFileHandler.readJsonFile(uid);
		ModelAndView modelAndView = new ModelAndView("traditionalTree");
		modelAndView.addObject("tree", tree);
		return modelAndView;
	}
}
