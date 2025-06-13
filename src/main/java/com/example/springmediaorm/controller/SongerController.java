package com.example.springmediaorm.controller;

import com.example.springmediaorm.model.Songer;
import com.example.springmediaorm.service.IGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/home")
public class SongerController {

    @Autowired
    private IGeneralService<Songer> service;

    @GetMapping("")
    public String home(Model model) {
        List<Songer> songers = service.findAll();
        model.addAttribute("songersList", songers);
        return "/home";
    }

    @GetMapping("/create")
    public String create(Model model) {
        Songer songers = new Songer();
        model.addAttribute("songersList", songers);
        return "/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("songers") Songer songers, Model model) {
        service.save(songers);
        model.addAttribute("songersList", songers);
        return "redirect:/home";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Songer songer = service.findById(Math.toIntExact(id));
        model.addAttribute("songer", songer);
        return "/edit";
    }


}
