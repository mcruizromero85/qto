package com.qto.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qto.web.domain.Tournament;

@RequestMapping("/portada")
@Controller
public class InitController {
	
    @RequestMapping (produces = "text/html")
    public String show(Model uiModel) {
    	uiModel.addAttribute("tournaments", Tournament.findAllTournaments());
    	addDateTimeFormatPatterns(uiModel);
    	System.out.println("Hola");
    	return "index";
    }
	
    void addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("tournament_confirm_date_format", "dd/MM/yyyy HH:mm:ss");
        uiModel.addAttribute("tournament_init_date_format", "dd/MM/yyyy HH:mm:ss");
    }
}
