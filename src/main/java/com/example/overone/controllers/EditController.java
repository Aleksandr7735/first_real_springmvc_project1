package com.example.overone.controllers;

import com.example.overone.models.ArticleModel;
import com.example.overone.repos.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/edit")
public class EditController {
    @Autowired
    ArticleRepo articleRepo;

    @GetMapping({"/{id}"})
    public String editArtic(@PathVariable(value = "id") long id, Model model) {

        Optional<ArticleModel> articleModel = articleRepo.findById(id);
        List<ArticleModel> list = new ArrayList<>();
        Optional<Object> articModel;
        articleModel.ifPresent(list::add);
        model.addAttribute("article", list);
        return "edit";
    }
    @PostMapping("/{id}")
    public RedirectView saveItem(@PathVariable(value = "id") long id,
            @RequestParam String title,
    @RequestParam String disc,
    @RequestParam String fullText){

        articleRepo.deleteById(id);

    ArticleModel articleModel= new ArticleModel();
    articleModel.setTitle(title);
    articleModel.setDisc(disc);
    articleModel.setFullText(fullText);
    articleRepo.save(articleModel);
    return new RedirectView("/");

    }
}
