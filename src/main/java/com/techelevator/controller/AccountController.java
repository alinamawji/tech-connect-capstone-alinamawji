package com.techelevator.controller;

import com.techelevator.authentication.AuthProvider;
import com.techelevator.model.User;
import com.techelevator.model.UserDAO;
import org.bouncycastle.math.raw.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;


/**
 * AccountController
 */
@Controller
public class AccountController {
    @Autowired
    private AuthProvider auth;

    @Autowired
    UserDAO userDAO;

    @RequestMapping(method = RequestMethod.GET, path = {"/", "/index"})
    public String index(ModelMap modelHolder) {
        modelHolder.put("user", auth.getCurrentUser());

        return "index";
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login(ModelMap modelHolder) {
        return "login";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String username, @RequestParam String password, RedirectAttributes flash, HttpSession session) {
        if (auth.signIn(username, password)) {
            User user = userDAO.getValidUserWithPassword(username, password);
            System.out.println(user.getFirstName());
            session.setAttribute("user", user);
            return "redirect:/loginConfirmation";
        } else {
            flash.addFlashAttribute("message", "Login Invalid");
            return "redirect:/login";
        }
    }

    @RequestMapping(path = "/loginConfirmation", method = RequestMethod.GET)
    public String displayLoginConfirmation(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return "loginConfirmation";
    }

    @RequestMapping(path = "/logoff", method = RequestMethod.GET)
    public String displayLogOff(HttpSession session) {
        User user = (User) session.getAttribute("user");
        auth.logOff();
        return "logoutConfirmation";
    }

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String register(ModelMap modelHolder) {
        if (!modelHolder.containsAttribute("user")) {
            modelHolder.put("user", new User());
        }
        return "register";
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String register(@Valid @ModelAttribute("user") User user, BindingResult result, RedirectAttributes flash) {
        flash.addFlashAttribute("user", user);
        if (result.hasErrors()) {
            flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "user", result);
            flash.addFlashAttribute("message", "Please fix the following errors:");
            return "redirect:/register";
        }
        System.out.println(user.getFirstName());
        auth.register(user.getFirstName(), user.getLastName(), user.getUsername(), user.getEmail(), user.getPassword(), user.getRole());
        return "redirect:/registerConfirmation";
    }


    @RequestMapping(path = "/registerConfirmation", method = RequestMethod.GET)
    public String displayRegisterConfirmation( ModelMap modelHolder) {
            User user = (User) modelHolder.get("user");
        return "registerConfirmation";
    }

}



