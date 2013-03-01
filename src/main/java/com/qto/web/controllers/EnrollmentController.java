package com.qto.web.controllers;

import com.qto.web.domain.Enrollment;
import com.qto.web.domain.Tournament;

import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/enrollments")
@Controller
@RooWebScaffold(path = "enrollments", formBackingObject = Enrollment.class)
public class EnrollmentController {
	
	@RequestMapping(value = "/inscripcion_{idTorneo}", produces = "text/html")	
	public String enroll(@PathVariable("idTorneo") Long idTorneo, Model uiModel) {
		System.out.println("Me puedo inscribir!!! ");
		uiModel.addAttribute("inscripciones",Enrollment.findEnrollmentsByTournament(idTorneo));
		
        return "fichaTorneo/inscripciones";
    }
	
}
