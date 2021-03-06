package ru.job4j.forum.control;

import liquibase.pro.packaged.P;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;



@Controller
public class PostControl {

    private final PostService service;

    public PostControl(PostService service) {
        this.service = service;
    }

    @GetMapping("/create")
    public String create(Model model) {
        Post post = new Post();
        model.addAttribute("posts", post);
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "post/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Post post) {
      service.save(post);
        return "redirect:/";
   }

   @GetMapping("/update")
    public String edit(@RequestParam("id") long id, Model model) {
        model.addAttribute("post", service.findById(id));
        return "post/update";
   }
}
