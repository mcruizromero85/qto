package com.qto.web.controllers;

import com.qto.web.domain.Gamer;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/gamers")
@Controller
@RooWebScaffold(path = "gamers", formBackingObject = Gamer.class)
public class GamerController {
}
