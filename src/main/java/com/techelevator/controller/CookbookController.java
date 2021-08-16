package com.techelevator.controller;


import com.techelevator.model.JDBCCookbookDAO;
import com.techelevator.model.JDBCRecipeDAO;
import com.techelevator.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
            modelHolder.put("userCreatedRecipes", recipeDAO.getRecipesFromUser(user.getUsername()));
            return "cookbook";
        } else { return "private";}
    }

    @RequestMapping(path = "/cookbook", method = RequestMethod.POST)
    public String deleteRecipeFromMyCookbook(@RequestParam Long recipe_id, HttpSession session, ModelMap modelHolder) {
        User user = new User();
        if (session.getAttribute("user") != null) {
            user = (User) session.getAttribute("user");
            session.setAttribute("deletedRecipe", recipeDAO.getRecipeByID(recipe_id));
            cookbookDAO.deleteRecipeFromCookbook(recipe_id, user.getId());
            return "redirect:/deletedRecipeFromCookbook";
        }
        else { return "private";}
    }

    @RequestMapping(path = "/deletedRecipeFromCookbook", method = RequestMethod.GET)
    public String displayDeletedRecipeConfirmation(ModelMap modelMap) {
        Recipe recipe = (Recipe) modelMap.get("deletedRecipe");
        return "deletedRecipeFromCookbook";
    }


//    @RequestMapping (path = "/recipeDetails")


}
