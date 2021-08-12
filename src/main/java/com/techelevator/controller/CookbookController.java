package com.techelevator.controller;


import com.techelevator.model.JDBCCookbookDAO;
import com.techelevator.model.JDBCRecipeDAO;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CookbookController {

    @Autowired
    private JDBCRecipeDAO recipeDAO;
    private JDBCCookbookDAO cookbookDAO;

    @RequestMapping (path="/cookbook", method = RequestMethod.GET)
    public String getCookbook() { return "cookbook";}

    @RequestMapping (path="/cookbook", method = RequestMethod.POST) //only one GET and POST per page
    public String displayMySavedRecipes(@RequestParam long user_id, ModelMap modelHolder){
        modelHolder.put("savedRecipes", cookbookDAO.getRecipesFromMyCookbook(user_id));
        return "cookbook";
    }

//    @RequestMapping (path = "/recipeDetails")



}
