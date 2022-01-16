package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
        model.addAttribute("posts", service.getAll());
        return "post/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Post post) {
      service.save(post);
        return "redirect:/";
   }
}
