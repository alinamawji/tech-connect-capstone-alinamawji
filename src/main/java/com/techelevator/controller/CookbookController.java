package com.techelevator.controller;


import com.techelevator.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CookbookController {

    @Autowired
    private JDBCRecipeDAO recipeDAO;
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

    @RequestMapping(path = "/recipeDetails", method = RequestMethod.GET)
    public String displayRecipeDetails(@RequestParam Long recipe_id, ModelMap modelHolder, HttpSession session) {
        Recipe recipe = recipeDAO.getRecipeByID(recipe_id);
        modelHolder.put("recipe", recipe);
        List<Ingredient> ingredients = recipeDAO.getRecipeIngredients(recipe_id);
        modelHolder.put("ingredients", ingredients);
        session.getAttribute("user");

        return "recipeDetails";
    }





//    @RequestMapping (path = "/recipeDetails")


}
