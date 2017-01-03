package com.rodionbykov.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rodionbykov.model.Nota;
import com.rodionbykov.service.NotaService;

@Controller
public class NotaController {
	private static final Logger logger = LoggerFactory.getLogger(NotaController.class);

	@Autowired
	private NotaService notaService;

	@RequestMapping(value = "/notas", method = RequestMethod.GET)
	public ModelAndView userListPage() {
		ModelAndView mav = new ModelAndView("list");

		List<Nota> notaList = notaService.findAll();

		mav.addObject("userList", notaList);

		return mav;
	}
}
