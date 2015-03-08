package org.mavtechnicalgroup.triio.web;

import org.mavtechnicalgroup.triio.data.FraternityFamilyMember;
import org.mavtechnicalgroup.triio.data.FraternityTree;
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
	
	@RequestMapping(value = "/tree/traditional/{uid}", method = RequestMethod.POST)
	void addTraditionalUser(@PathVariable("uid") String uid,
				 @RequestParam("firstName") String fn, @RequestParam("lastName") String ln,
				 @RequestParam("middleName") String mn, @RequestParam("gender") String gen,
				 //@RequestParam("dd") int day, @RequestParam("mm") int month, @RequestParam("yyyy") int year,
				 @RequestParam("mother") String mother, @RequestParam("father") String father) {
		TraditionalFamilyMember member = new TraditionalFamilyMember(fn, ln, gen);
		TraditionalTree tree = (TraditionalTree) JsonFileHandler.readJsonFile(uid);
		if(!mother.equals("")) {
			member.addMother(mother);
			tree.getNodeMap().get(mother).addChildren(member);
		}
		if(!father.equals("")) {
			member.addFather(father);
			tree.getNodeMap().get(father).addChildren(member);
		}
		tree.add(member);
		JsonFileHandler.writeJsonFile(tree);
	}
	
	@RequestMapping(value = "/tree/fraternity/{uid}", method = RequestMethod.POST)
	void addFraternityUser(@PathVariable("uid") String uid,
				 @RequestParam("firstName") String fn, @RequestParam("lastName") String ln,
				/* @RequestParam("middleName") String mn,*/ @RequestParam("gender") String gen,
				 //@RequestParam("dd") int day, @RequestParam("mm") int month, @RequestParam("yyyy") int year,
				 @RequestParam("chapter") String chapter, @RequestParam("line") String line,
				 @RequestParam("crossingClass") String crossingClass, @RequestParam("big") String big) {
		FraternityFamilyMember member = new FraternityFamilyMember(fn, ln, gen);
		System.out.println(JsonFileHandler.readJsonFile(uid));
		FraternityTree tree = (FraternityTree) JsonFileHandler.readJsonFile(uid);
		System.out.println(tree);
		
		member.setChapter(chapter);
		member.setLine(line);
		member.setCrossingClass(crossingClass);
		member.setBig(big);

		tree.getNodeMap().get(big).addLittles(member);
		
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
	
	@RequestMapping(value = "/tree/fraternity/create", method = RequestMethod.POST)
	String createFraternityTree(@RequestParam("firstName") String fn, @RequestParam("lastName") String ln,
								@RequestParam("gender") String gen, @RequestParam("chapter") String ch,
								@RequestParam("line") String line, @RequestParam("crossingClass") String crossingClass) {
		FraternityTree tree = new FraternityTree();
		FraternityFamilyMember seedMember = new FraternityFamilyMember(fn, ln, gen);
		seedMember.setChapter(ch);
		seedMember.setLine(line);
		seedMember.setCrossingClass(crossingClass);
		System.out.println(crossingClass);
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
	
	@RequestMapping(value = "tree/fraternity/{uid}", method = RequestMethod.GET)
	ModelAndView loadFraternityTree(@PathVariable("uid") String uid) {
		FraternityTree tree = (FraternityTree) JsonFileHandler.readJsonFile(uid);
		ModelAndView modelAndView = new ModelAndView("fraternityTree");
		modelAndView.addObject("tree", tree);
		return modelAndView;
	}
}
