package com.example.helloworld;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class WebController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/hello")
    public String hello(
            @RequestParam(name = "name", required = false, defaultValue = "") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        // Tạo ra thông tin
        List<Infor> profile = new ArrayList<>();
        profile.add(new Infor("fullname", "Nguyễn Hoàng Nam"));
        profile.add(new Infor("nickname", "lốddaf"));
        profile.add(new Infor("gmail", "loda.namnh@gmail.com"));
        profile.add(new Infor("facebook", "https://www.facebook.com/nam.tehee"));
        profile.add(new Infor("website", "https://loda.me"));

        // Đưa thông tin vào Model
        model.addAttribute("lodaProfile", profile);

        // TRả về template profile.html
        return "profile";
    }
}
