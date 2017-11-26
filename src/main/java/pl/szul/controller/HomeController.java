package pl.szul.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Dawid on 29.05.2017.
 */
@Controller
@RequestMapping
public class HomeController {

    @RequestMapping("/login")
    public String loginForm(){
        return "login";
    }
}
