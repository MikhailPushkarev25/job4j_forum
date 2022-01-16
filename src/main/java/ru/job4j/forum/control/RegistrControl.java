package ru.job4j.forum.control;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.model.User;
import ru.job4j.forum.store.AuthorityRepository;
import ru.job4j.forum.store.UserRepository;


@Controller
public class RegistrControl {

    private final PasswordEncoder encoder;
    private final AuthorityRepository auth;
    private final UserRepository users;

    public RegistrControl(PasswordEncoder encoder, AuthorityRepository auth, UserRepository users) {
        this.encoder = encoder;
        this.auth = auth;
        this.users = users;
    }

    @PostMapping("/reg")
    public String regSave(@ModelAttribute User user, Model model) {
        if (users.findByUsername(user.getUsername()) != null) {
            model.addAttribute("errorMassage", "Пользователь уже существует!");
            return "/reg";
        } else {
            user.setEnabled(true);
            user.setPassword(encoder.encode(user.getPassword()));
            user.setAuthority(auth.findByAuthority("ROLE_USER"));
            users.save(user);
        }
        return "redirect:/login";
    }

    @GetMapping("/reg")
    public String reg() {
        return "reg";
    }
}
