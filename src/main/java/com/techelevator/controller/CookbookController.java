package com.techelevator.controller;


import com.techelevator.model.JDBCCookbookDAO;
import com.techelevator.model.JDBCRecipeDAO;
import com.techelevator.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CookbookController {

    @Autowired
    private JDBCRecipeDAO recipeDAO;

    @Autowired
    private JDBCCookbookDAO cookbookDAO;

    @RequestMapping(path = "/cookbook", method = RequestMethod.GET)
    public String getSavedRecipes(HttpSession session, ModelMap modelHolder) {
        User user = new User();
        if(session.getAttribute("user") != null) {
            user = (User) session.getAttribute("user");
            modelHolder.put("savedRecipes", cookbookDAO.getRecipesFromMyCookbook(user.getId()));
            return "cookbook";
        } else { return "private";}
    }


//    @RequestMapping (path = "/recipeDetails")


}
