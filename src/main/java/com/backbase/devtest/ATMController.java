package com.backbase.devtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by bbates on 1/16/17.
 */
@Controller
public class ATMController {
    ATMManager atmManager;

    /**
     * Constructed for the MVC Controller for access to ATM data
     * @param atmManager manager of ATM data
     */
    @Autowired
    public ATMController(ATMManager atmManager ){
         this.atmManager=atmManager;
    }

    /**
     * listATMJSON
     * @param city city filter for ATM's
     * @return array of atm objects given a city or all of the atm's if its not passed
     */
    @RequestMapping(value = "/api/locator/ATM", method = RequestMethod.GET)
        public @ResponseBody
       String listATMJSON(@RequestParam(defaultValue = "") String city) {
        if(city==null || city.isEmpty())
           return atmManager.listATMJSON();
        else
            return atmManager.listATMJSONByCity(city);
        }

    /**
     * listATMByCityPost method to return ATM list filtered by city in HTML
     * @param city passed
     * @return Model and View object to be rendered for HTML view
     */
    @RequestMapping(value = "/user/locator/ATM", method = RequestMethod.POST)
      public ModelAndView listATMByCityPost(@RequestParam(defaultValue = "") String city) {
         return new ModelAndView("atmList", "atmList", atmManager.listATMByCity(city));
      }

    /**
     * atmForm
     * @return view name to generate form
     */
    @RequestMapping(value = "/user/locator/atmform", method = RequestMethod.GET)
            public String atmForm() {
                return "atmform";
            }

    /**
     * loginPage
     * @return login page view
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
        public String loginPage() {
            return "login";
        }

    /**
     * loginPagePost
     * @return login page view
     */
        @RequestMapping(value = "/login", method = RequestMethod.POST)
            public String loginPagePost() {
                return "login";
            }

    /**
     * logoutPage
     * @param request http request object
     * @param response http response object
     * @return  redirect to the login page with the logout indicator set
     */
        @RequestMapping(value="/logout", method = RequestMethod.GET)
        public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth != null){
                new SecurityContextLogoutHandler().logout(request, response, auth);
            }
            return "redirect:/login?logout";
        }


}
