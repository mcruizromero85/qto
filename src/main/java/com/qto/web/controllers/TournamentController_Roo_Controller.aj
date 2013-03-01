// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.qto.web.controllers;

import com.qto.web.controllers.TournamentController;
import com.qto.web.domain.Gamer;
import com.qto.web.domain.Tournament;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect TournamentController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String TournamentController.create(@Valid Tournament tournament, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, tournament);
            return "tournaments/create";
        }
        uiModel.asMap().clear();
        tournament.persist();
        return "redirect:/tournaments/" + encodeUrlPathSegment(tournament.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String TournamentController.createForm(Model uiModel) {
        populateEditForm(uiModel, new Tournament());
        return "tournaments/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String TournamentController.show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("tournament", Tournament.findTournament(id));
        uiModel.addAttribute("itemId", id);
        return "tournaments/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String TournamentController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("tournaments", Tournament.findTournamentEntries(firstResult, sizeNo));
            float nrOfPages = (float) Tournament.countTournaments() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("tournaments", Tournament.findAllTournaments());
        }
        addDateTimeFormatPatterns(uiModel);
        return "tournaments/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String TournamentController.update(@Valid Tournament tournament, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, tournament);
            return "tournaments/update";
        }
        uiModel.asMap().clear();
        tournament.merge();
        return "redirect:/tournaments/" + encodeUrlPathSegment(tournament.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String TournamentController.updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, Tournament.findTournament(id));
        return "tournaments/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String TournamentController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Tournament tournament = Tournament.findTournament(id);
        tournament.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/tournaments";
    }
    
    void TournamentController.addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("tournament_confirm_date_format", "dd/MM/yyyy HH:mm:ss");
        uiModel.addAttribute("tournament_init_date_format", "dd/MM/yyyy HH:mm:ss");
    }
    
    void TournamentController.populateEditForm(Model uiModel, Tournament tournament) {
        uiModel.addAttribute("tournament", tournament);
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("gamers", Gamer.findAllGamers());
    }
    
    String TournamentController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        } catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
    
}
