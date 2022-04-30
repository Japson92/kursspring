package com.clockworkjava.kursspring.controllers;

import com.clockworkjava.kursspring.components.TimeComponent;
import com.clockworkjava.kursspring.domain.Knight;
import com.clockworkjava.kursspring.domain.PlayerInformation;
import com.clockworkjava.kursspring.services.KnightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;


@Controller
public class KnightController {

    @Autowired
    TimeComponent timeComponent;

    @Autowired
    PlayerInformation playerInformation;

    @Autowired
    KnightService service;

    @RequestMapping("/knights")
    public String getKnights(Model model){
        List<Knight> allKnights = service.getAllKnights();
        model.addAttribute("knights",allKnights);
        model.addAttribute("timecomponent",timeComponent);
        model.addAttribute("playerinformation", playerInformation);
        return"knights";
    }

    @RequestMapping("/knight")
    public String getKnight(@RequestParam("id") Integer id, Model model){
        Knight knight = service.getKnight(id);
        model.addAttribute("knight", knight);
        model.addAttribute("timecomponent",timeComponent);
        model.addAttribute("playerinformation", playerInformation);
        return "knight";
    }

    @RequestMapping("/newknight")
    public String createKnight(Model model){
        model.addAttribute("knight",new Knight());
        model.addAttribute("timecomponent",timeComponent);
        model.addAttribute("playerinformation", playerInformation);
        return "knightform";
    }
    @RequestMapping(value = "/knights", method = RequestMethod.POST)
    public String saveKnights(Knight knight){
        service.saveKnight(knight);
        return "redirect:/knights";
    }

    @RequestMapping(value = "/knight/delete/{id}")
    public String deleteKnights(@PathVariable("id") Integer id){
        service.deleteKnight(id);
        return "redirect:/knights";
    }

}
