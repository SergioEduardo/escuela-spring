package mx.axiomagency.alternativecourses.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class InitController {

    private static final String INDEX_PAGE = "index";
    private static final String DASHBOARD_PAGE = "dashboard";

    @GetMapping(value = {"/", "/alternative-courses"})
    public String initViewLayer(){
        return INDEX_PAGE;
    }

    @GetMapping("/dashboard")
    public String getDashboardPage(){
        return DASHBOARD_PAGE;
    }
}
