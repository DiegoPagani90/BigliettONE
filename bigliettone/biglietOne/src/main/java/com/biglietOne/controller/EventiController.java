package com.biglietOne.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biglietOne.models.Evento;
import com.biglietOne.service.EventoService;

@Controller
public class EventiController {

    @Autowired
    EventoService eService;

    @RequestMapping(method = RequestMethod.GET, path = "/paginaEventi")
	public String home(HttpSession session, Model model) {

        List<Evento> listaEventi = eService.getEventi();
        model.addAttribute("listaEventi", listaEventi);
	
		return "paginaEventi.html";
	
	}

    @RequestMapping(method = RequestMethod.GET, path = "/paginaEvento")
	public String evento(HttpSession session, Model model) {

       
		return "paginaEvento.html";
	
	}
    
}
