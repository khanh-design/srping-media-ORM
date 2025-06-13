package com.example.springmediaorm.controller;

import com.example.springmediaorm.model.Songer;
import com.example.springmediaorm.service.IGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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
        model.addAttribute("songer", new Songer());
        return "/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("songer") Songer songer,
                      @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                // Tạo thư mục uploads nếu chưa tồn tại
                String uploadDir = "src/main/resources/uploads/";
                File dir = new File(uploadDir);
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                // Lưu file
                String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
                File destFile = new File(uploadDir + fileName);
                file.transferTo(destFile);

                // Lưu đường dẫn file vào database
                songer.setFilePath("/uploads/" + fileName);
            } catch (IOException e) {
                e.printStackTrace();
                return "redirect:/home/create?error=upload";
            }
        }
        
        service.save(songer);
        return "redirect:/home";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        Songer songer = service.findById(id);
        model.addAttribute("songer", songer);
        return "/edit";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable int id,
                        @ModelAttribute("songer") Songer songer,
                        @RequestParam(value = "file", required = false) MultipartFile file) {
        Songer existingSonger = service.findById(id);
        if (existingSonger != null) {
            songer.setMa(id);
            
            if (file != null && !file.isEmpty()) {
                try {
                    // Xóa file cũ nếu có
                    if (existingSonger.getFilePath() != null) {
                        File oldFile = new File("src/main/resources" + existingSonger.getFilePath());
                        if (oldFile.exists()) {
                            oldFile.delete();
                        }
                    }

                    // Lưu file mới
                    String uploadDir = "src/main/resources/uploads/";
                    String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
                    File destFile = new File(uploadDir + fileName);
                    file.transferTo(destFile);

                    songer.setFilePath("/uploads/" + fileName);
                } catch (IOException e) {
                    e.printStackTrace();
                    return "redirect:/home/" + id + "/edit?error=upload";
                }
            } else {
                songer.setFilePath(existingSonger.getFilePath());
            }
            
            service.save(songer);
        }
        return "redirect:/home";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id) {
        Songer songer = service.findById(id);
        if (songer != null && songer.getFilePath() != null) {
            // Xóa file
            File file = new File("src/main/resources" + songer.getFilePath());
            if (file.exists()) {
                file.delete();
            }
        }
        service.deleteById(id);
        return "redirect:/home";
    }
}
