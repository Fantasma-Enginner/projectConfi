package org.tsir.toll.conciliations.reconcile.application.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Home redirection to swagger api documentation 
 */
@Controller
public class HomeController {
	
    @GetMapping(value = "/test")
    public String test() {
        return "redirect:/swagger-ui/";
    }
    

}
