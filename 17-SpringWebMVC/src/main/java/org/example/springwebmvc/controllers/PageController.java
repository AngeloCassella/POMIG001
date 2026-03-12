package org.example.springwebmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class PageController {

    // GET | POST

    @GetMapping("/home")
    public @ResponseBody String getHomePage() {
        return "Prima pagina Spring MVC";
    }

    // Endpoint con paramentri di tipo Query String
    // http://localhost:8080/home?paramName=paramValue&paramName=paramValue
    @GetMapping("/home/params")
    public @ResponseBody String getHomePageWithQueryStringParams(@RequestParam String name,
                                                                 @RequestParam String lastname) {
        // http://localhost:8080/home/params?name=Mario&lastname=Rossi
        return "Prima pagina Spring MVC con prametri di tipo Query String: " + name + " " +lastname;
    }

    // Endpoit con paramentri di tipo Path Variable
    // http://localhost:8080/home/paramValue
    @GetMapping("/home/params/{name}/{lastname}")
    public @ResponseBody String getHomePageWithPathParams(@PathVariable String name,
                                                          @PathVariable String lastname) {
        // http://localhost:8080/home/params/Francesca/Neri
        return "Prima pagina Spring MVC con prametri di tipo Path Variable: " + name + " " + lastname;
    }

    // Endpoint collegato ad una pagina Html creata con Thymeleaf
    @GetMapping("/page1")
    public String getPageThymeleaf() {
        // http://localhost:8080/page1
        return "pageThymeleaf";
    }

    // Endpoint collegato ad una pagina Html creata con Thymeleaf CON parametri
    @GetMapping("/page1/{name}/{lastname}")
    public String getPageThymeleaf(@PathVariable String name,
                                   @PathVariable String lastname,
                                    Map<String, Object> model) {
        // http://localhost:8080/page1/Mario/Rossi
        model.put("firstname", name);
        model.put("lastname", lastname);
        model.put("valori", "Valori passati dal Client");
        model.put("method", "Map<String, Object> model");
        return "pageThymeleaf";
    }

    // Endpoint collegato ad una pagina Html creata con Thymeleaf CON parametri
    @GetMapping("/page2/{name}/{lastname}")
    public String getPageThymeleaf(@PathVariable String name,
                                   @PathVariable String lastname,
                                   Model model) {
        // http://localhost:8080/page2/Mario/Rossi
        model.addAttribute("firstname", name);
        model.addAttribute("lastname", lastname);
        model.addAttribute("valori", "Valori passati dal Client");
        model.addAttribute("method", "Model model");
        return "pageThymeleaf";
    }

    // Endpoint collegato ad una pagina Html creata con Thymeleaf CON parametri
    @GetMapping("/page3/{name}/{lastname}")
    public String getPageThymeleaf(@PathVariable String name,
                                   @PathVariable String lastname,
                                   ModelMap model) {
        // http://localhost:8080/page2/Mario/Rossi
        model.addAttribute("firstname", name);
        model.addAttribute("lastname", lastname);
        model.addAttribute("valori", "Valori passati dal Client");
        model.addAttribute("method", "ModelMap model");
        return "pageThymeleaf";
    }

    @GetMapping("/page4")
    public ModelAndView getPageThymeleaf(@RequestParam(required = false) String name, @RequestParam String lastname) {
        // http://localhost:8080/page4?name=Mario&lastname=Rossi
        String page = (name != null) ? "pageThymeleaf" : "error";
        ModelAndView model = new ModelAndView(page);
        model.addObject("firstname", name);
        model.addObject("lastname", lastname);
        model.addObject("valori", "Valori passati dal Client");
        model.addObject("method", "ModelAndView model");
        return model;
    }

}
