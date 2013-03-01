package com.qto.web.controllers;

import com.qto.web.domain.Tournament;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/tournaments")
@Controller
@RooWebScaffold(path = "tournaments", formBackingObject = Tournament.class)
public class TournamentController {
	
	
}
