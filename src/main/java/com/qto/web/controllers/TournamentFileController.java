package com.qto.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qto.web.domain.Tournament;

@RequestMapping("/fichaTorneo")
@Controller
public class TournamentFileController {
	
	@RequestMapping(value = "/{id}", produces = "text/html")	
	public String show(@PathVariable("id") Long id, Model uiModel) {
		System.out.println("Detalle Torneo: " + id);
        uiModel.addAttribute("tournament", Tournament.findTournament(id));
        return "fichaTorneo";
    }
	
   
}
