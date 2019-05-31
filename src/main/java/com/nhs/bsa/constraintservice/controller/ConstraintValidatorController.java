package com.nhs.bsa.constraintservice.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nhs.bsa.constraintservice.model.RegularAmount;
import com.nhs.bsa.constraintservice.model.RegularAmount.Frequency;

@Controller
public class ConstraintValidatorController {

	private static final Logger logger = LoggerFactory.getLogger(ConstraintValidatorController.class);
	
	@GetMapping("/enterAmount")
	public ModelAndView loadFormPage(Model model) {
		logger.info("Validate Amount");
		ModelAndView modelAndView = new ModelAndView("validatedAmount");
		modelAndView.addObject("regularAmount", new RegularAmount());
		modelAndView.addObject("frequencies", Frequency.values());
		return modelAndView;
	}

	@PostMapping("/addValidatedAmount")
	public String submitForm(@Valid RegularAmount amount, BindingResult result, Model model) {
		if (result.hasErrors()) {
			logger.error("Failed Validation");
			return "failed";
		}
		model.addAttribute("message", "Successfully validated amount: " + amount.toString());
		return "passed";
	}
}
